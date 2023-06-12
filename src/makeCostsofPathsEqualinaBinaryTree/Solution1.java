package makeCostsofPathsEqualinaBinaryTree;
/*
Runtime
8 ms
Beats
73.62%
Memory
55.8 MB
Beats
5.87%
 */
public class Solution1 {
    private int max=0;
    public int minIncrements(int n, int[] cost) {
        updateCost(1, n, cost, 0);
        int res = 0;
        for (int i=0; i<n-1; i+=2) {
            int first = cost[n-1-i];
            int second = cost[n-1-i-1];
            int smaller = Math.min(first, second);
            int bigger = Math.max(first, second);
            int idx = (n-i-2) /2;
            cost[idx] = bigger;
            res += (bigger-smaller);
        }
        return res;
    }
    private void updateCost(int i, int n, int[] cost, int sum) {
        if (i*2 > n) {
            cost[i-1]=cost[i-1] + sum;
            max = Math.max(max, cost[i-1]);
        } else {
            int newSum= sum + cost[i-1];
            updateCost(i*2, n, cost, newSum);
            updateCost(i*2+1, n, cost, newSum);
        }
    }

    public static void main(String[] args) {
        Solution1 s= new Solution1();
        int[] cost = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        s.minIncrements(15, cost);
    }

}
