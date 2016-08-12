package shuffleanArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Solution {

    private int[] nums;
    private List<Integer> set = new ArrayList<>();
    public Solution(int[] nums) {
        this.nums = nums;
        for (int i : nums) {
            set.add(i);
        }
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        set.clear();
        for (int i : nums) {
            set.add(i);
        }
        return this.nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (set.size() == 1) {
                result[i] = set.get(0);
            } else {
                Random random = new Random();
                int index = random.nextInt(set.size());
                result[i] = set.get(index);
                set.remove(index);
            }
        }
        reset();
        return result;
    }

}

/**
 * Your Solution object will be instantiated and called as such: Solution obj =
 * new Solution(nums); int[] param_1 = obj.reset(); int[] param_2 =
 * obj.shuffle();
 */
