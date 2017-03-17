package iPO;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2 {
    // Choose the one with the maximum profit among the ones with affordable
    // capital at each run. Abort if nothing is affordable.
    // this is quick since the last test case.
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        int myC = W;
        PriorityQueue<pair> store = new PriorityQueue<pair>();
        List<pair> next = new ArrayList<pair>();
        for (int i = 0; i < Profits.length; i++)
            store.offer(new pair(Capital[i], Profits[i]));
        for (int i = 0; i < k; i++) {
            while (!store.isEmpty() && store.peek().C > myC) {
                next.add(store.poll());
            }
            if (store.isEmpty())
                return myC;
            myC += store.poll().P;
            for (int j = 0; j < next.size(); j++)
                store.offer(next.get(j));
            next.clear();
        }
        return myC;
    }
}

class pair implements Comparable<pair> {
    int C;
    int P;

    public pair(int cap, int pro) {
        C = cap;
        P = pro;
    }

    public int compareTo(pair p) {
        return -1 * (P - p.P);
    }

    public String toString() {
        return "[" + C + "," + P + "]";
    }
}

