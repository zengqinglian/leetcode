package countUnguardedCellsInTheGrid;
/*
Runtime: 20 ms, faster than 99.25% of Java online submissions for Count Unguarded Cells in the Grid.
Memory Usage: 77 MB, less than 87.59% of Java online submissions for Count Unguarded Cells in the Grid.
 */
public class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] status = new int[m][n];
        int total = m * n;
        for(int[] wall : walls) {
            status[wall[0]][wall[1]] = 2;
        }
        for(int[] guard : guards) {
            status[guard[0]][guard[1]] = 2;
        }
        total -= walls.length;
        for (int[] guard:guards) {
            total--;
            for (int x = guard[0]+1; x<m; x++) {
                if (status[x][guard[1]]!=2) {
                    if (status[x][guard[1]]==0){
                        total--;
                        status[x][guard[1]]=1;
                    }
                }else{
                    break;
                }
            }
            for (int x = guard[0]-1; x>=0; x--) {
                if (status[x][guard[1]]!=2) {
                    if (status[x][guard[1]]==0) {
                        total--;
                        status[x][guard[1]]=1;
                    }
                }else{
                    break;
                }
            }
            for (int x = guard[1]+1; x<n; x++) {
                if (status[guard[0]][x]!=2) {
                    if (status[guard[0]][x]==0) {
                        status[guard[0]][x] = 1;
                        total--;
                    }
                }else{
                    break;
                }
            }
            for (int x = guard[1]-1; x>=0; x--) {
                if (status[guard[0]][x]!=2) {
                    if (status[guard[0]][x]==0) {
                        status[guard[0]][x] = 1;
                        total--;
                    }
                }else{
                    break;
                }
            }
        }

        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] guards = {{1,5},{1,1},{1,6},{0,2}};
        int[][] walls = {{0,6},{0,3},{0,5}};
        s.countUnguarded(2,7, guards, walls);
    }
}
