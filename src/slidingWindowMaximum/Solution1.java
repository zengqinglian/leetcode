package slidingWindowMaximum;

import java.util.TreeMap;
/*
Runtime
431
ms
Beats
5.79%
of users with Java
Memory
61.11
MB
Beats
28.10%
of users with Java
 */
public class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i=0; i<k; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }
        int[] res = new int[nums.length - k +1];
        res[0] = map.lastKey();
        int index = 1;
        for (int i=k; i<nums.length; i++) {
            int removeItem = nums[i - k];
            if (map.get(removeItem) == 1) {
                map.remove(removeItem);
            }else{
                map.put(removeItem, map.get(removeItem)-1);
            }
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            res[index++] = map.lastKey();
        }
        return res;
    }
}
