package rangeProductQueriesofPowers;

import java.util.ArrayList;
import java.util.List;
/*
Runtime
9 ms
Beats
93.65%
Memory
82.7 MB
Beats
96.83%
 */
public class Solution {
    public int[] productQueries(int n, int[][] queries) {

        String s = Integer.toBinaryString(n);
        int[] res = new int[queries.length];

        List<Integer> powers = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(s.length()-1-i)=='1') {
                sum+=i;
                powers.add(sum);
            }

        }

        int[] cache = new int[sum+1];

        int r = 1;
        cache[0]=1;
        for (int i=1; i<cache.length; i++) {
            r = r * 2 % 1_000_000_007;
            cache[i] = r;
        }

        for (int i=0; i<queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int product = start -1 >=0 ? powers.get(end)-powers.get(start-1):powers.get(end);
            res[i] = cache[product];
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] queries = {{0,0}};
        s.productQueries(2, queries);
    }
}
