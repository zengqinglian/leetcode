package divideArrayInSetsOfkConsecutiveNumbers;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    //135ms solution, meet avg 50%
    public boolean isPossibleDivide(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int n : nums){
            Integer i = map.get(n);
            if(i == null){
                map.put(n, 1);
            }else {
                map.put(n, i + 1);
            }

        }
        for(int key : map.keySet()){
            if(map.get(key) ==0){
                continue;
            }
            int num = map.get(key);
            Map<Integer, Integer> subMap = map.subMap(key+1, key+k);
            if(subMap.size() !=k-1){
                return false;
            }
            for(int subkey : subMap.keySet()){
                int v = subMap.get(subkey);
                if(v<num){
                    return false;
                }else{
                    map.put(subkey, v-num);
                }
            }
        }

        return true;
    }
}
