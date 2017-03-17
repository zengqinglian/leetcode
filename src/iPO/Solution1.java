package iPO;

import java.util.PriorityQueue;

public class Solution1 {
    /*
     * Create (capital, profit) pairs and put them into PriorityQueue pqCap.
     * This PriorityQueue sort by capital increasingly. Keep polling pairs from
     * pqCap until the project out of current capital capability. Put them into
     * PriorityQueue pqPro which sort by profit decreasingly. Poll one from
     * pqPro, it's guaranteed to be the project with max profit and within
     * current capital capability. Add the profit to capital W. Repeat step 2
     * and 3 till finish k steps or no suitable project (pqPro.isEmpty()). Time
     * Complexity: For worst case, each project will be inserted and polled from
     * both PriorityQueues once, so the overall runtime complexity should be
     * O(NlgN), N is number of projects.
     */
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> capitalQueue = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> profitsQueue = new PriorityQueue<>((a, b) -> (b[1] - a[1]));

        for (int i = 0; i < Profits.length; i++) {
            capitalQueue.add(new int[] { Capital[i], Profits[i] });
        }

        for (int i = 0; i < k; i++) {
            while (!capitalQueue.isEmpty() && capitalQueue.peek()[0] <= W) {
                profitsQueue.add(capitalQueue.poll());
            }

            if (profitsQueue.isEmpty())
                break;

            W += profitsQueue.poll()[1];
        }

        return W;
    }
}
