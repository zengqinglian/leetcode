package rangeSumofSortedSubarraySums;
/*
Runtime: 8 ms, faster than 100.00% of Java online submissions for Range Sum of Sorted Subarray Sums.
Memory Usage: 41.1 MB, less than 54.69% of Java online submissions for Range Sum of Sorted Subarray Sums.
 */
public class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        int[] sums = new int[100 * n + 1];
        for(int i= 0; i<n ; i++) {
            int res = nums[i];
            sums[res]++;
            for(int j=i+1; j<n; j++ ) {
                res+=nums[j];
                sums[res]++;
            }
        }
        int index = 0;
        int res = 0;
        boolean inRange = false;
        for(int i=1; i<sums.length; i++) {
            if(!inRange) {
                if(sums[i] >0){
                    index += sums[i];
                    if(index >= left && index<right) {
                        inRange = true;
                        res+=((index - left + 1)*i);
                        res%=1_000_000_007;
                    }else if (index >= left && index>=right) {
                        res+=((right - left + 1)*i);
                        res%=1_000_000_007;
                        return res;
                    }
                }
            }else{
                if(sums[i] >0){
                    index += sums[i];
                    if(index>=right){
                        int diff = index - right;
                        res+=(i*(sums[i]-diff));
                        res%=1_000_000_007;
                        return res;
                    }else{
                        res+=(sums[i]*i);
                        res%=1_000_000_007;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums={7,5,8,5,6,4,3,3};
        s.rangeSum(nums,8,2,6);
    }
}
