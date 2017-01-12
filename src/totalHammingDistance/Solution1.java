package totalHammingDistance;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    // cache result, still over time limit
    private Map<Integer, Integer> cache = new HashMap<>();
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
        if (cache.containsKey(bitSum)) {
            return cache.get(bitSum);
        } else {
            result = getNumberOfOnes(bitSum);
            cache.put(bitSum, result);
            return result;
        }
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
}
