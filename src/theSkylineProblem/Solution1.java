package theSkylineProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution1 {
    // over time limit
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings.length == 0) {
            return new ArrayList<int[]>();
        }
        if (buildings.length == 1) {
            List<int[]> result = new ArrayList<>();
            int[] rt1 = { buildings[0][0], buildings[0][2] };
            result.add(rt1);
            int[] rt2 = { buildings[0][1], 0 };
            result.add(rt2);
            return result;
        }

        TreeMap<Integer, Integer> caches = new TreeMap<>();
        for (int[] building : buildings) {
            for (int i = building[0]; i <= building[1] && i >= 0; i++) {
                if (caches.containsKey(i)) {
                    caches.put(i, Math.max(caches.get(i), building[2]));
                } else {
                    caches.put(i, building[2]);
                }
            }
        }

        TreeSet<int[]> result = new TreeSet<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }

        });

        int[] rt1 = { caches.firstKey(), caches.get(caches.firstKey()) };
        result.add(rt1);
        int[] rt2 = { caches.lastKey(), 0 };
        result.add(rt2);

        int previous = -1;
        for (int i : caches.keySet()) {
            if (previous != -1) {
                if (i - previous == 1) {
                    if (caches.get(previous) < caches.get(i)) {
                        int[] rt = { i, caches.get(i) };
                        result.add(rt);
                    }
                } else {
                    int[] rt = { i, caches.get(i) };
                    result.add(rt);
                }
            }
            previous = i;
        }

        previous = -1;
        for (int i : caches.descendingKeySet()) {
            if (previous != -1) {
                if (i - previous == -1) {
                    if (caches.get(previous) < caches.get(i)) {
                        int[] rt = { i, caches.get(previous) };
                        result.add(rt);
                    }
                } else {
                    int[] rt = { i, 0 };
                    result.add(rt);
                }
            }
            previous = i;
        }

        return new ArrayList<int[]>(result);

    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[][] buildings = { { 0, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };
        s.getSkyline(buildings);
    }
}
