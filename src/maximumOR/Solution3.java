package maximumOR;
/*
Runtime
5 ms
Beats
74.63%
Memory
56.3 MB
Beats
89.4%
 */
public class Solution2 {
    public long maximumOr(int[] nums, int k) {
        long[] prefix = new long[nums.length];
        long[] suffix = new long[nums.length];

        long prefixSum = 0;
        long suffixSum = 0;
        for (int i=0; i<nums.length; i++) {
            prefixSum = prefixSum | nums[i];
            prefix[i] = prefixSum;
            suffixSum = suffixSum | nums[nums.length-1-i];
            suffix[nums.length-1-i] = suffixSum;
        }
        long res = 0;
        for (int i=0; i<nums.length;i++) {
            long newRes = ((long)nums[i]) << k;
            if (i-1 >=0) {
                newRes = newRes | prefix[i-1];
            }
            if (i+1 < nums.length) {
                newRes = newRes | suffix[i+1];
            }
            res = Math.max(res, newRes);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {8,1,2};
        Solution2 s= new Solution2();
        s.maximumOr(array, 2);
    }
}
