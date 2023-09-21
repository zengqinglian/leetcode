package beautifulArrangement;
/*
Runtime
35 ms
Beats
69.91%
Memory
38.9 MB
Beats
82.64%
 */
public class Solution {
    public int countArrangement(int n) {
        boolean[] used = new boolean[n+1];
        int res = helper(n, used, 1);
        return res;
    }

    private int helper(int n, boolean[] used, int idx) {
        if (idx == n) {
            int sum = 0;
            for(int i=1; i<used.length; i++) {
                if ( !used[i] && (i % idx ==0 || idx % i ==0 ) ){
                    sum++;
                }
            }
            return sum;
        }
        int sum = 0;
        for(int i=1; i<used.length; i++) {
            if ( !used[i] && (i % idx ==0 || idx % i ==0 ) ){
                used[i]= true;
                sum += helper(n, used, idx+1);
                used[i] = false;
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.countArrangement(1);
    }

}
