package maximumOR;
/*
Time Limit Exceeded
 */
public class Solution1 {
    public long maximumOr(int[] nums, int k) {
        int length =0;
        for (int i=0; i<nums.length; i++) {
            length = Math.max(length, Integer.toBinaryString(nums[i]).length());
        }
        long res = 0;
        for (int i=0; i<nums.length; i++) {

            if (Integer.toBinaryString(nums[i]).length() == length) {
                long newRes = (((long)nums[i]) << k);
                for(int j=0; j<nums.length; j++) {
                    if (i!=j) {
                        newRes = newRes | nums[j];
                    }
                }
                res = Math.max(res, newRes);
            }

        }
        return res;
    }
}
