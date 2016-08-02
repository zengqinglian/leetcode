package countNumberswithUniqueDigits;

public class Solution
{
    // math solution
    public int countNumbersWithUniqueDigits( int n ) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        if (n == 0) {
            return 1;
        }
        if(n==1){
            return 10;
        }
        dp[1] = 10;
        int total = 0;
        int digits = 2;
        while(digits<=n){
            total = 0;
            for (int i = 1; i <= digits; i++) {
                if(i==1){
                    total=9;
                } else if (i == 2) {
                    total *= 9;
                } else {
                    total *= (9 - i + 2);
                }
            }
            dp[digits] = dp[digits - 1] + total;
            digits++;
        }
        
        return dp[n];

    }


    public static void main( String[] args ) {
        Solution s = new Solution();
        s.countNumbersWithUniqueDigits(3);
    }
}
