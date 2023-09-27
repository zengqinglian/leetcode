package powerfulIntegers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
Runtime
1 ms
Beats
100%
Memory
40.2 MB
Beats
57.66%
 */
public class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        List<Integer> res = new ArrayList<>();
        if (bound <2) {
            return res;
        }
        if (x == 1 && y == 1) {
            res.add(2);
            return res;
        }
        if (x == 1 || y ==1) {
            int val = x==1 ? y : x;
            int total = 1;
            while (total+1<=bound) {
                res.add(total+1);
                total = total * val;
            }
            return res;
        }
        Set<Integer> set = new HashSet<>();

        int totalX = 1;
        int totalY = 1;
        while(totalX < bound) {
            while(totalY + totalX <= bound) {
                set.add(totalY + totalX);
                totalY = totalY * y;
            }
            totalX = totalX * x;
            totalY = 1;
        }
        res.addAll(set);
        return res;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.powerfulIntegers(2,1,10);
    }
}
