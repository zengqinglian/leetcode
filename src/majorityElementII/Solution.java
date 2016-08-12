package majorityElementII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // Boyer-Moore Majority Vote algorithm
    public List<Integer> majorityElement(int[] nums) {
        int max1 = 0;
        int max2 = 1; // make sure these two numbers are different.
        int count1 = 0;
        int count2 = 0;

        for (int num : nums) {
            if (num == max1) {
                count1++;
            } else if (num == max2) {
                count2++;
            } else if (count1 == 0) {
                max1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                max2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        List<Integer> result = new ArrayList<Integer>();
        for (int num : nums) {
            if (num == max1) {
                count1++;
            } else if (num == max2) {
                count2++;
            }
        }
        if (count1 > nums.length / 3) {
            result.add(max1);
        }
        if (count2 > nums.length / 3) {
            result.add(max2);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 3, 2, 9, 8, 4, 1, 1, 1, 5, 1, 6, 1, 7, 1, 2, 1, 9, 1, 2 };
        s.majorityElement(nums);
    }
}
