package gasStation;
/*
3ms
Beats 44.13%
of users with Java
Memory 54.94MB
Beats 96.55%
of users with Java
 */
public class Solution1 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int[] diff = new int[gas.length];
        int total = 0;
        for (int i=0; i<gas.length; i++) {
            diff[i] = gas[i] - cost[i];
            total += diff[i];
        }
        if (total < 0) {
            return -1;
        }
        if (gas.length == 1) {
            return 0;
        }
        for (int i=0; i<gas.length; i++) {
            int preIndex = i==0 ? gas.length-1 : i-1;
            if (diff[i]>0 && diff[preIndex]<=0) {
                int sum = 0;
                for (int j=0; j<gas.length; j++) {
                    int idx = i + j;
                    if (idx >= gas.length) {
                        idx = idx - gas.length;
                    }
                    sum += diff[idx];
                    if (sum < 0) {
                        break;
                    }
                }
                if (sum >= 0) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] gas = {2,0,0};
        int[] cost = {0,1,0};
        Solution1 solution = new Solution1();
        solution.canCompleteCircuit(gas, cost);
    }
}
