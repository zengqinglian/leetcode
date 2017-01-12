package totalHammingDistance;

public class Solution {
    // the direct solution. calculate each and loop through the array
    // Native and over time limit solution
    public int totalHammingDistance(int[] nums) {
        int length = nums.length;
        if (length == 0 || length == 1) {
            return 0;
        }
        int total = 0;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                total += hammingDistance(nums[i], nums[j]);
            }
        }
        return total;
    }

    private int hammingDistance(int i1, int i2) {
        int bitSum = i1 ^ i2;
        int result = 0;
        if (bitSum == 0) {
            return result;
        }
        if (bitSum == 1) {
            return 1;
        }

        return getNumberOfOnes(bitSum);
    }

    private int getNumberOfOnes(int bitSum) {
        int count = 0;
        while (bitSum > 1) {
            if (bitSum % 2 == 1) {
                count++;
            }
            bitSum = bitSum / 2;
        }
        if (bitSum == 1) {
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 14, 2 };
        Solution s = new Solution();
        s.totalHammingDistance(nums);
    }
}
