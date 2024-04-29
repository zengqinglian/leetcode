package numberOfBlackBlocks;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
/*
Runtime 157 ms
Beats
45.59%
of users with Java
Memory 55.65MB
Beats
88.24%
of users with Java
 */
public class Solution1 {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        Map<Key, Integer> res = new HashMap<>();
        for(int[] coord : coordinates) {
            int x = coord[0];
            int y = coord[1];
            if (x<m-1 && y<n-1) {
                Key key = new Key(x, y);
                int v = res.getOrDefault(key,0);
                res.put(key, v+1);
            }
            if (x-1>=0 && y<n-1) {
                Key key = new Key(x-1, y);
                int v = res.getOrDefault(key,0);
                res.put(key, v+1);
            }
            if (y-1>=0 && x<m-1) {
                Key key = new Key(x, y-1);
                int v = res.getOrDefault(key,0);
                res.put(key, v+1);
            }
            if (x-1>=0 && y-1>=0) {
                Key key = new Key(x-1, y-1);
                int v = res.getOrDefault(key,0);
                res.put(key, v+1);
            }
        }
        long[] r = new long[5];
        for(int v : res.values()) {
            r[v]++;
        }
        long t = 0;
        for (int i=1; i<5; i++) {
            t+=r[i];
        }
        r[0] = ((long) (m - 1) * (n - 1)) - t;
        return r;
    }
    private static class Key {
        int x =0;
        int y=0;
        public Key(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Key key = (Key) o;
            return x == key.x && y == key.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
