package flowerPlantingWithNoAdjacent;

import java.util.*;
/*
Runtime
25 ms
Beats
33.82%
Memory
54.4 MB
Beats
40.53%
 */
public class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        if (n == 1) {
            int[] res = {1};
            return res;
        }
        if (n == 2) {
            int[] res = {1, 2};
            return res;
        }
        if (n == 3) {
            int[] res = {1, 2, 3};
            return res;
        }
        if (n == 4) {
            int[] res = {1, 2, 3, 4};
            return res;
        }
        int[] ans = new int[n];
        Set<Integer>[] links = new Set[n];
        for (int[] path : paths) {
            int a = path[0]-1;
            int b = path[1]-1;
            if (links[a] == null) {
                links[a] = new HashSet<>();
            }
            links[a].add(b);
            ans[a] = getFlower(links, a, ans);

            if (links[b] == null) {
                links[b] = new HashSet<>();
            }
            links[b].add(a);
            ans[b] = getFlower(links, b, ans);
        }
        for (int i=0; i<n; i++) {
            if (ans[i] == 0) {
                ans[i] = 1;
            }
        }
        return ans;
    }

    private int getFlower(Set<Integer>[] links, int a, int[] ans) {
        if (links[a]==null) {
            return 1;
        }
        boolean[] flower = new boolean[5];
        for (int link : links[a]) {
            flower[ans[link]] = true;
        }
        for (int i=1; i<5; i++) {
            if (!flower[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] paths = {{4,1},{4,2},{4,3},{2,5},{1,2},{1,5}};
        s.gardenNoAdj(5,paths);
    }
}
