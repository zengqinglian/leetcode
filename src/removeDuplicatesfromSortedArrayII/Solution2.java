package removeDuplicatesFromSortedArrayii;
/*
Runtime
0ms
Beats
100.00%
of users with Java
Memory
44.26MB
Beats
71.43%
of users with Java
 */
public class Solution2 {
    public int removeDuplicates(int[] nums) {
        int replaceIndex = -1;
        int currentValue = Integer.MIN_VALUE;
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            if (replaceIndex >=0) {
                if (currentValue == nums[i]) {
                    count++;
                    if (count <=2) {
                        int temp = nums[replaceIndex];
                        nums[replaceIndex] = nums[i];
                        nums[i] = temp;
                        replaceIndex++;
                    }
                }else {
                    currentValue = nums[i];
                    count=1;
                    int temp = nums[replaceIndex];
                    nums[replaceIndex] = nums[i];
                    nums[i] = temp;
                    replaceIndex++;
                }
            }else{
                if (currentValue == nums[i]) {
                    if (count >= 2) {
                        replaceIndex = i;
                    }
                    count++;
                }else{
                    count=1;
                    currentValue = nums[i];
                }
            }
        }
        if (replaceIndex<0) {
            return nums.length;
        }
        return replaceIndex;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0,0,1,1,1,1,2,2,2,3,3};
        s.removeDuplicates(nums);
    }
}
