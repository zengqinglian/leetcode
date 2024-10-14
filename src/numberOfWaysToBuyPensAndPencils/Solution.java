package numberOfWaysToBuyPensAndPencils;
/*
Runtime
13 ms
Beats 40.84%
Analyze Complexity
Memory
39.98 MB
Beats 98.50%
 */
public class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        long res = 0L;
        int min = Math.min(cost1, cost2);
        int max = Math.max(cost1, cost2);
        for (int i=0; i<= total/max; i++) {
            res++;
            int remain = total - i * max;
            res += (remain/min);
        }
        return res;
    }
}
