package jumpGamevii;
/*
Someone's dp + slide window
 */
public class Solution2 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length(), pre = 0;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = 1; i < n; ++i) {
            if (i >= minJump && dp[i - minJump])
                pre++;
            if (i > maxJump && dp[i - maxJump - 1])
                pre--;
            dp[i] = pre > 0 && s.charAt(i) == '0';
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        solution.canReach("00111010", 3, 5);
    }
}
