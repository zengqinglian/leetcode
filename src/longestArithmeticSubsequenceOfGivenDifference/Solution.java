package longestArithmeticSubsequenceOfGivenDifference;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 50ms solution , beat 50% , avg
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 1;
        for(int a : arr){
            int target = a - difference;
            Integer targetCnt = map.get(target);
            if(targetCnt != null){
                int newVal = Math.max(targetCnt+1, map.getOrDefault(a,0));
                map.put(a, newVal);
                res = Math.max(res, newVal);
            }else{
                map.put(a, 1);
            }
        }
        return res;
    }


}
