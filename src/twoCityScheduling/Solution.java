package twoCityScheduling;

import java.util.Arrays;
/*
Runtime
2 ms
Beats
78.23%
Memory
40.9 MB
Beats
25.56%
 */
public class Solution {
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a,b)-> Integer.compare(Math.abs(b[0]-b[1]), Math.abs(a[0]-a[1])));
        int a = costs.length/2;
        int b = a;
        int res = 0;
        for (int[] cost : costs) {
            if (a > 0 && b>0 ) {
                res+= Math.min(cost[0],cost[1]);
                if (cost[0]>=cost[1]) {
                    b--;
                }else{
                    a--;
                }
            }else if (a>0 && b==0) {
                res+=cost[0];
                a--;
            }else{
                res+=cost[1];
                b--;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] costs = {{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}};
        s.twoCitySchedCost(costs);
    }
}
