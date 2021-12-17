package avoidFloodinTheCity;

import java.util.*;
/*
Runtime: 67 ms, faster than 49.54% of Java online submissions for Avoid Flood in The City.
Memory Usage: 60.7 MB, less than 35.32% of Java online submissions for Avoid Flood in The City.
 */
public class Solution1 {
    public int[] avoidFlood(int[] rains) {
        Map<Integer,Integer> fullLakes = new HashMap<>();
        TreeSet<Integer> zeroPos = new TreeSet<>();
        for(int i=0; i<rains.length; i++){
            if(rains[i] == 0) {
                zeroPos.add(i);
            }else  {
                if(fullLakes.containsKey(rains[i])) {
                    int pos = fullLakes.get(rains[i]);
                    Integer previousZero = zeroPos.higher(pos);
                    if(previousZero!=null){
                        rains[previousZero] = rains[i];
                        zeroPos.remove(previousZero);
                        fullLakes.put(rains[i],i);
                        rains[i] = -1;
                    }else {
                        return new int[0];
                    }
                }else{
                    fullLakes.put(rains[i], i);
                    rains[i] = -1;
                }
            }
        }
        if(!zeroPos.isEmpty()){
            for(int key : zeroPos){
                rains[key] = 1;
            }
        }
        return rains;
    }
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] rains = {1,0,2,0,3,0,2,0,0,0,1,2,3};
        s.avoidFlood(rains);
    }
}
