package countNumberofTexts;
/*
Runtime: 60 ms, faster than 63.41% of Java online submissions for Count Number of Texts.
Memory Usage: 50.1 MB, less than 85.15% of Java online submissions for Count Number of Texts.
 */
public class Solution {
    public int countTexts(String pressedKeys) {
        int length = Math.max(4, pressedKeys.length()+1);
        int[][] dp = new int[length][2];
        int[] res0={1,1};
        int[] res1={1,1};
        int[] res2={2,2};
        int[] res3={4,4};
        dp[0]=res0;
        dp[1]=res1;
        dp[2]=res2;
        dp[3]=res3;
        for (int i=4; i<dp.length; i++){
            long v3 = 0L+ dp[i-1][0] + dp[i-2][0]+ dp[i-3][0];
            long v4 = 0L+ dp[i-1][1] + dp[i-2][1]+ dp[i-3][1] + dp[i-4][1];
            int[] newV = {(int)(v3 % 1_000_000_007), (int)(v4 % 1_000_000_007) };
            dp[i] = newV;
        }
        char pre = '-';
        int count = 0;
        long res = 1L;
        for (char c : pressedKeys.toCharArray()) {
            if (c == pre) {
                count++;
            }else {
                if (count>0) {
                    if (pre == '7' || pre=='9') {
                        res *= dp[count][1];

                    }else {
                        res *= dp[count][0];
                    }
                    res %= 1_000_000_007;
                }
                count = 1;
                pre = c;
            }
        }
        if (pre == '7' || pre=='9') {
            res *= dp[count][1];

        }else {
            res *= dp[count][0];
        }
        res %= 1_000_000_007;
        return (int)res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.countTexts("22227777");
    }
}
