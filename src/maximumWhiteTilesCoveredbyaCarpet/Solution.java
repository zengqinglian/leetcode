package maximumWhiteTilesCoveredbyaCarpet;

import java.util.Arrays;
import java.util.Comparator;
/*
Runtime: 65 ms, faster than 83.28% of Java online submissions for Maximum White Tiles Covered by a Carpet.
Memory Usage: 60.2 MB, less than 99.38% of Java online submissions for Maximum White Tiles Covered by a Carpet.
 */
public class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        if (carpetLen == 1) {
            return 1;
        }
        Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));
        int headIndex = 0;
        int totalwhite = tiles[0][1]-tiles[0][0]+1;
        int res = totalwhite;
        for (int i=1; i<tiles.length; i++) {
            if (res >= carpetLen || tiles[i][1]-tiles[i][0]+1>=carpetLen) {
                return carpetLen;
            }
            int[] top =  tiles[headIndex];
            if (top==null || tiles[i][1]-top[0] +1 <= carpetLen) {
                totalwhite += (tiles[i][1] - tiles[i][0]+1);
                res = Math.max(res, totalwhite);
            }else if (tiles[i][0] - top[0]+1 > carpetLen) {
                headIndex++;
                totalwhite -= (top[1] - top[0]+1);
                i--;
            }else {
                int covered = (top[0]+carpetLen - tiles[i][0]) + totalwhite;
                res = Math.max(res, covered);
                headIndex++;
                totalwhite -= (top[1] - top[0]+1);
                i--;
            }
        }
        return Math.min(res, carpetLen);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //int[][] tiles = {{1,5},{10,11},{12,18},{20,25},{30,32}};
        int[][] tiles = {{1,1000000000}} ;
        s.maximumWhiteTiles(tiles, 1000);
    }
}
