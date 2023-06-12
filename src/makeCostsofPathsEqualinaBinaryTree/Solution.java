package makeCostsofPathsEqualinaBinaryTree;

import java.util.LinkedList;
import java.util.Queue;
/*
Runtime
14 ms
Beats
20%
Memory
54.8 MB
Beats
69.87%
 */
public class Solution {
    private int max=0;
    public int minIncrements(int n, int[] cost) {
        updateCost(1, n, cost, 0);
        int childrenSize = (n +1) / 2 ;
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i=0; i<childrenSize; i+=2) {
            int first = max - cost[n-1-i];
            int second = max - cost[n-1-i-1];
            int smaller = Math.min(first, second);
            int bigger = Math.max(first, second);
            q.add(smaller);
            res += (bigger-smaller);
        }
        while(q.size() >=2) {
            int first = q.poll();
            int second = q.poll();
            int smaller = Math.min(first, second);
            int bigger = Math.max(first, second);
            q.add(smaller);
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
        Solution s= new Solution();
        int[] cost = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        s.minIncrements(15, cost);
    }

}
