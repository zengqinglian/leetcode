package avoidFloodinTheCity;

import java.util.HashSet;
import java.util.Set;
/*
Over time limited
76 / 80 test cases passed.
 */
public class Solution {
    public int[] avoidFlood(int[] rains) {
        Set<Integer> fullLakes = new HashSet<>();
        for(int i=0; i<rains.length; i++){
            if(rains[i] == 0) {
                int target = -1;
                for(int j= i+1; j<rains.length; j++) {
                    if(rains[j]> 0 && fullLakes.contains(rains[j])) {
                        target = j;
                        break;
                    }
                }
                if(target >0) {
                    fullLakes.remove(rains[target]);
                    rains[i] = rains[target];
                }else {
                    rains[i] = 1;
                }
            }else  {
                if(fullLakes.contains(rains[i])) {
                    return new int[0];
                }else{
                    fullLakes.add(rains[i]);
                    rains[i] = -1;
                }
            }
        }
        return rains;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] rains = {1,2,0,0,2,1};
        s.avoidFlood(rains);
    }
}
