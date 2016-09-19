package randomPickIndex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();
    public Solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
    }

    public int pick(int target) {
        List<Integer> possibles = map.get(target);
        if (possibles.size() == 1) {
            return possibles.get(0);
        }
        Random random = new Random();
        int index = random.nextInt(possibles.size());
        return possibles.get(index);
    }
}
