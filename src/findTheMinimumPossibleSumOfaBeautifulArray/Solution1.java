package findTheMinimumPossibleSumOfaBeautifulArray;
/*
Runtime
1ms
Beats 29.79%
Analyze Complexity
Memory
41.30 MB
Beats 14.89%
 */
public class Solution1 {
    public int minimumPossibleSum(int n, int target) {
        int halfTarget = target / 2;
        long sum = (1L + halfTarget ) * halfTarget /2;
        sum %= 1_000_000_007;
        if (halfTarget == n) {
            return (int)sum %1_000_000_007 ;
        }else if (halfTarget > n) {
            long total =( (1L+n) % 1_000_000_007) * n % 1_000_000_007 /2 ;
            return (int)total%1_000_000_007;
        }else {
            long total = sum + (( 1L*target + target + (n - halfTarget -1) ) * (n-halfTarget) /2)%1_000_000_007;
            return (int)total % 1_000_000_007;
        }

    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.minimumPossibleSum(100000, 100000);
    }
}
