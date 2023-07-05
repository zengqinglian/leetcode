package factorialTrailingZeroes;
/*
Runtime
1 ms
Beats
37.63%
Memory
39.2 MB
Beats
92.92%
 */
public class Solution {
    public int trailingZeroes(int n) {
        if (n==0) {
            return 0;
        }
        int count = 0;
        while(n>=5) {
            n = n / 5;
            count += n;
        }
        return count;
    }
}
