package maxSumofaPairWithEqualSumofDigits;

import java.util.HashMap;
import java.util.Map;
/*
96ms solution , beat 90%
 */
public class Solution {
    public int maximumSum(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i=0 ; i<nums.length; i++) {
            int v = getSum(nums[i]);
            int[] arr = map.get(v);
            if (arr == null) {
                arr = new int[2];
                map.put(v, arr);
            }
            if (nums[i] > arr[0]) {
                arr[1] = arr[0];
                arr[0] = nums[i];
            }else if (nums[i]> arr[1]) {
                arr[1] = nums[i];
            }
        }
        int res = -1;
        for(int[] arr : map.values()) {
            if (arr[1]> 0) {
                res = Math.max(res, arr[0]+ arr[1]);
            }
        }
        return res;
    }

    private int getSum(int num) {
        int sum = 0;
        while (num>0) {
            sum += (num%10);
            num=num/10;
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {18,43,36,13,7};
        s.maximumSum(nums);
    }
}
