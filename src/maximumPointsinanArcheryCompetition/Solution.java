package maximumPointsinanArcheryCompetition;

import java.util.Arrays;
/*
Runtime: 6 ms, faster than 84.78% of Java online submissions for Maximum Points in an Archery Competition.
Memory Usage: 42.9 MB, less than 58.70% of Java online submissions for Maximum Points in an Archery Competition.
 */
public class Solution {
    int max=0;
    int[] res = new int[12];
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int[] state = new int[12];
        getMax(11, aliceArrows,state,0, 0, numArrows);
        return res;
    }

    private void getMax(int i, int[] aliceArrows, int[] myArrows, int score, int used, int numArrows) {
        if(i<=0){
            myArrows[i] = numArrows - used;
            if (score > max) {
                res = Arrays.copyOf(myArrows, 12);
                max = score;
            }
            myArrows[i] = 0;
            return;
        }
        if (used == numArrows) {
            if (score > max) {
                res = Arrays.copyOf(myArrows, 12);
                max = score;
            }
        }

        if (numArrows-used>aliceArrows[i]) {
            myArrows[i] = aliceArrows[i] + 1;
            getMax(i - 1, aliceArrows, myArrows, score+i, used+myArrows[i], numArrows);
            myArrows[i] = 0;
        }
        getMax(i-1, aliceArrows, myArrows, score, used, numArrows);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] aliceArrows = {0,0,1,1,3,0,0,0,0,2,0,0};
        s.maximumBobPoints(7, aliceArrows);

    }
}
