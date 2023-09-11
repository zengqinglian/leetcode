package matchstickstoSquare;

import java.util.Arrays;
/*
Runtime
118 ms
Beats
49.16%
Memory
40.5 MB
Beats
35.53%
 */
public class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int stick: matchsticks) {
            sum += stick;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int avg = sum /4;
        Arrays.sort(matchsticks);
        int len = 4;
        int startIndex = matchsticks.length-1;
        for (int i=matchsticks.length-1; i>=0; i--) {
            if (matchsticks[i] > avg) {
                return false;
            }
            if (matchsticks[i] == avg) {
                len--;
                startIndex--;
            }
        }
        if (len ==0) {
            return true;
        }

        int[] status = new int[len];
        boolean res = checkHelper(status, matchsticks, startIndex, avg);
        return res;
    }

    private boolean checkHelper(int[] status, int[] matchsticks, int startIndex, int target) {
        if (startIndex < 0) {
            for (int val : status) {
                if ( val != target) {
                   return false;
                }
            }
            return true;
        }
        for (int i=0; i<status.length; i++) {
            int val = matchsticks[startIndex];
            status[i] += val;
            if (status[i] > target) {
                status[i]-=val;
                continue;
            }
            if (checkHelper(status, matchsticks, startIndex-1, target)) {
                return true;
            }
            status[i]-=val;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] matchsticks = {1,1,2,2,2};
        s.makesquare(matchsticks);
    }
}
