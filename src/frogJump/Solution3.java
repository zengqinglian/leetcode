package frogJump;

import java.util.*;
/*
Runtime
46 ms
Beats
52.35%
Analyze Complexity
Memory
50.16 MB
Beats
42.87%
 */
public class Solution3 {
    public boolean canCross(int[] stones) {
        if (stones.length ==1) {
            return true;
        }
        if (stones.length >=2 && stones[1] !=1) {
            return false;
        }
        if (stones.length ==2 && stones[1] ==1) {
            return true;
        }
        Set<Status> visited = new HashSet<>();
        Queue<Status> q = new LinkedList<>();
        Status init = new Status(1, 1);
        visited.add(init);
        q.add(init);
        while(!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Status cur = q.poll();
                for (int j = cur.index+1; j<stones.length; j++) {
                    if (stones[j] - stones[cur.index] > cur.steps+1) {
                        break;
                    }
                    if (stones[j] - stones[cur.index] <= cur.steps+1 && stones[j] - stones[cur.index] >= cur.steps-1) {
                        if (j == stones.length-1) {
                            return true;
                        }
                        Status possibleStatus = new Status(j, stones[j]-stones[cur.index]);
                        if (visited.contains(possibleStatus)) {
                            continue;
                        }
                        visited.add(possibleStatus);
                        q.add(possibleStatus);
                    }
                }
            }
        }
        return false;
    }
    private static class Status {
        int index;
        int steps;
        Status(int index, int steps) {
            this.index = index;
            this.steps = steps;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Status status = (Status) o;
            return index == status.index && steps == status.steps;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, steps);
        }
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        solution.canCross(new int[]{0,1,3,6,7});
    }
}
