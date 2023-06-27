package buildanArrayWithStackOperations;

import java.util.ArrayList;
import java.util.List;
/*
Runtime
0 ms
Beats
100%
Memory
41.8 MB
Beats
87.65%
 */
public class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> res = new ArrayList<>();
        int cur = 1;
        for (int i=0; i<target.length;i++) {
            if (cur == target[i]) {
                res.add("Push");
                cur++;
            }else {
                res.add("Push");
                res.add("Pop");
                cur++;
                i--;
            }
        }
        return res;
    }
}
