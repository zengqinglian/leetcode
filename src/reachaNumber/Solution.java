package reachaNumber;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 31 / 73 testcases passed, OT
 */
public class Solution {
    public int reachNumber(int target) {
        if (target == 1 || target == -1) {
            return 1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; true; i++) {
            if (q.isEmpty()) {
                q.add(i);
                q.add(i*-1);
            }else{
                int size = q.size();
                for (int j=0; j<size; j++) {
                    int v = q.poll();
                    if (v+i ==target || v-i == target) {
                        return i;
                    }else {
                        q.add(i + v);
                        q.add(v - i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.reachNumber(-1000000000);
    }
}
