package leastNumberofUniqueIntegersAfterKRemovals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Runtime: 55 ms, faster than 62.46% of Java online submissions for Least Number of Unique Integers after K Removals.
Memory Usage: 57.4 MB, less than 37.74% of Java online submissions for Least Number of Unique Integers after K Removals.
 */
public class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            Integer v = map.get(arr[i]);
            if(v==null){
                map.put(arr[i],1);;
            }else{
                map.put(arr[i], v+1);
            }
        }
        List<Integer> sorted =
                map.values().parallelStream().sorted().collect(Collectors.toList());


        int index = 0;
        while(k>0){
            k-=sorted.get(index++);
        }
        int res = sorted.size() - index + 1;
        if(k==0)
           res--;
        return res;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {5,5,4};
        s.findLeastNumOfUniqueInts(arr,1);
    }
}
