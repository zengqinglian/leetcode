package kDivisibleElementsSubarrays;

import java.util.HashSet;
import java.util.Set;
/*
Runtime: 263 ms, faster than 73.46% of Java online submissions for K Divisible Elements Subarrays.
Memory Usage: 56.2 MB, less than 93.20% of Java online submissions for K Divisible Elements Subarrays.
 */
public class Solution1 {
    public int countDistinct(int[] nums, int k, int p) {
        Set<String> hs = new HashSet<>();

        for(int i=0; i<nums.length; ++i) {
            int cnt = 0;
            StringBuilder sb = new StringBuilder();

            for(int j=i; j<nums.length; ++j) {

                if(nums[j]%p == 0) {
                    cnt++;
                }

                if(cnt > k) {
                    break;
                }

                sb.append(nums[j] + ",");

                hs.add(sb.toString());
            }
        }

        return hs.size();
    }
}
