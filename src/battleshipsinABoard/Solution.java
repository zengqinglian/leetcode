package battleshipsinABoard;

public class Solution {
    // slow solution
    public int countBattleships(char[][] board) {
        int h = board.length;
        if (h == 0) {
            return 0;
        }

        int w = board[0].length;
        if (w == 0) {
            return 0;
        }
        
        boolean[][] grid = new boolean[h][w];

        int result = 0;

        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if (grid[i][j]) {
                    continue;
                } else if (board[i][j] == '.') {
                    grid[i][j] = true;
                    continue;
                } else {
                    boolean hasLeft=false;
                    boolean hasTop = false;
                    if (i == 0) {
                        hasTop = false;
                    } else {
                        hasTop = board[i - 1][j] == 'X' ? true : false;
                    }

                    if (j == 0) {
                        hasLeft = false;
                    } else {
                        hasLeft = board[i][j - 1] == 'X' ? true : false;
                    }

                    if (!hasLeft && !hasTop) {
                        result++;
                        grid[i][j] = true;
                    }
                }
                
            }
        }
        

        return result;
    }

    public static void main(String[] args) {

    }
}
