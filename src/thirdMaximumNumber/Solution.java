package thirdMaximumNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 10ms solution - beat 30%
    public int thirdMax(int[] nums) {
        List<Integer> list = new ArrayList<>(3);
        list.add(null);
        list.add(null);
        list.add(null);
        for (int i : nums) {
            if (list.get(0) == null) {
                list.set(0, i);
            } else if (list.get(0) <= i) {
                if (list.get(0) < i) {
                    list.set(2, list.get(1));
                    list.set(1, list.get(0));
                    list.set(0, i);
                }
            } else if (list.get(1) == null) {
                list.set(1, i);
            } else if (list.get(1) <= i) {
                if (list.get(1) < i) {
                    list.set(2, list.get(1));
                    list.set(1, i);
                }
            } else if (list.get(2) == null) {
                list.set(2, i);
            } else if (list.get(2) < i) {
                list.set(2, i);
            }
        }

        if (list.get(2) == null) {
            return list.get(0);
        }
        return list.get(2);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 3, 2, 2 };
        s.thirdMax(nums);
    }
}
