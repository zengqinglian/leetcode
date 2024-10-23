package jumpGamevii;

import java.util.LinkedList;
import java.util.Queue;
/*
Memory Limit Exceeded
 */
public class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int idx = q.poll();
                for(int j=idx+minJump; j<Math.min(idx+maxJump+1, s.length()); j++) {
                    if (s.charAt(j) == '0') {
                        if (j == s.length()-1) {
                            return true;
                        }else{
                            q.add(j);
                        }
                    }
                }
            }
        }
        return false;
    }
}
