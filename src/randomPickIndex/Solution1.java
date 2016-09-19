package randomPickIndex;

import java.util.ArrayList;
import java.util.Random;

public class Solution1 {
    int[] nums;
    Random rand;

    public Solution1(int[] nums) {
        this.nums = nums;
        this.rand = new Random();
    }

    public int pick(int target) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                list.add(i);
        }
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        return list.get(index);
    }
}
