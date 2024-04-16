package sortColors;
/*
Runtime
0ms
Beats
100.00%
of users with Java
Memory
41.65MB
Beats
65.38%
of users with Java

 */
public class Solution1 {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        for(int i=0; i<nums.length && i<= right; ) {
            if (nums[i] ==0) {
                int temp = nums[left];
                nums[left] = 0;
                nums[i]=temp;
                left++;
                if(i<=left) {
                    i = left;
                }
            }else if (nums[i] == 1) {
                i++;
            }else{
                int temp = nums[right];
                nums[right] = 2;
                nums[i]=temp;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,0,2,1,1,0};
        s.sortColors(nums);
        System.out.println("ok");
    }
}
