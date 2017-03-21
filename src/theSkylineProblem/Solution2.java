package theSkylineProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution2 {
    public List<int[]> getSkyline(int[][] buildings) {
        Map<Integer, List<int[]>> cps = new TreeMap<>(); // ordered by the
                                                         // critical points
        for (int[] b : buildings) {
            cps.putIfAbsent(b[0], new LinkedList<>());
            cps.putIfAbsent(b[1], new LinkedList<>());
            cps.get(b[0]).add(b);
            cps.get(b[1]).add(b);
        }

        // heap for the currently active buildings
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] b1, int[] b2) {
                return Integer.compare(b2[2], b1[2]);
            }
        });

        List<int[]> res = new ArrayList<>();
        // iterate from left to right over the critical points
        for (Map.Entry<Integer, List<int[]>> entry : cps.entrySet()) {
            int c = entry.getKey();
            List<int[]> bs = entry.getValue();

            for (int[] b : bs) {
                if (c == b[0]) { // this critical point is a left edge of
                                 // building `b`
                    heap.add(b);
                } else { // right edge
                    heap.remove(b);
                }
            }

            if (heap.isEmpty()) {
                // the heap is empty, so the skyline is 0
                res.add(new int[] { c, 0 });
            } else {
                int h = heap.peek()[2];
                if (res.isEmpty() || res.get(res.size() - 1)[1] != h) {
                    // only add the highest rectangle if it different than
                    // before
                    res.add(new int[] { c, h });
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[][] buildings = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };
        s.getSkyline(buildings);
    }
}
