package greatestSumDivisibleByThree;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    //time over solution  . failed 24/40
    public int maxSumDivThree(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for(int n : nums){
            Set<Integer> newSet = new HashSet<>();
            for(int v : set){
                int newVal = v+n;
                newSet.add(newVal);
                if(newVal%3==0){
                    max = Math.max(max, newVal);
                }
            }
            set.add(n);
            set.addAll(newSet);
            if(n%3==0){
                max = Math.max(max, n);
            }
        }
        return max;
    }
}
