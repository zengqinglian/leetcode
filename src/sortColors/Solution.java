package sortColors;

public class Solution {
    public void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i : nums) {
            count[i] = count[i] + 1;
        }
        int index = 0;
        for (int i = 0; i < count.length; i++) {
            for (int j = 1; j <= count[i]; j++) {
                nums[index++] = i;
            }
        }
    }
}
