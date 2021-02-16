package bulbSwitcherIII;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    //28ms solution, beat 10%
    public int numTimesAllBlue(int[] light) {
        int res = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i : light){
            q.add(i);
            int top = q.peek();
            if(top == q.size()){
                res++;
            }
        }
        return res;
    }
}
