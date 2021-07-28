package longestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
/*
Runtime: 55 ms, faster than 52.26% of Java online submissions for Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit.
Memory Usage: 52.1 MB, less than 62.12% of Java online submissions for Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit.
 */
public class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Queue<Integer> q = new LinkedList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(nums[0],1);
        q.add(nums[0]);
        int res = 1;
        for(int i =1; i<nums.length; i++){
            q.add(nums[i]);
            Integer val = map.get(nums[i]);
            if(val == null){
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], val+1);
            }
            while(map.lastKey()- map.firstKey() > limit){
                int pop = q.poll();
                if(map.get(pop)==1){
                    map.remove(pop);
                }else{
                    map.put(pop,map.get(pop)-1);
                }
            }
            res = Math.max(res, q.size());
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {8,2,4,7};
        s.longestSubarray(nums, 4);
    }
}
