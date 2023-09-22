package randomFlipMatrix;

import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

/*
Runtime
26 ms
Beats
52.90%
Memory
44.8 MB
Beats
23.19%
 */
public class Solution {
    private int[][] pos;
    private int size;
    private Set<Point> set;
    private int m;
    private int n;

    public Solution(int m, int n) {
        size = m * n;
        this.m = m ;
        this.n = n;
        if (size >= 10000) {
            set = new HashSet<>();
        }else{
            pos = new int[m*n][2];
            int idx = 0;
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    int[] p = {i,j};
                    pos[idx++]= p;
                }
            }
        }
    }

    public int[] flip() {
        if (size >= 10000) {
            Random rand = new Random();
            int randomX =  rand.nextInt(m);
            int randomY =  rand.nextInt(n);
            Point random = new Point(randomX, randomY);
            while (set.contains(random)) {
                randomX =  rand.nextInt(m);
                randomY =  rand.nextInt(n);
                random = new Point(randomX, randomY);
            }
            int[] res = {randomX, randomY};
            set.add(random);
            return res;
        }else {
            Random rand = new Random();
            int random = rand.nextInt(size);
            int[] res = pos[random];
            pos[random] = pos[size - 1];
            pos[size - 1] = res;
            size--;
            return res;
        }
    }

    public void reset() {
        if (size >= 10000) {
            set.clear();
        }else {
            size = pos.length;
        }
    }

    private static class Point {
        private int x;
        private int y;
        Point(int x , int y) {
            this.x =x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return 23 * x + y;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
