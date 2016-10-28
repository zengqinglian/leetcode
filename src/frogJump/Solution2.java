package frogJump;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    // back tracking
    public boolean canCross(int[] stones) {
        if (stones.length <= 1)
            return true;
        Set<String> visited = new HashSet<>();
        if (stones[1] != 1)
            return false;
        return canCross(stones, visited, 1, 1);
    }

    private boolean canCross(int[] stones, Set<String> visited, int k, int pos) {
        if (pos == stones.length - 1)
            return true;
        if (k <= 0)
            return false;
        if (!visited.add(k + "," + pos)) {
            return false;
        }
        int des = stones[pos] + k;
        for (int i = pos + 1; i < stones.length; i++) {
            if (stones[i] > des + 1)
                break;
            else if (stones[i] >= des - 1 && stones[i] <= des + 1) {
                if (canCross(stones, visited, stones[i] - stones[pos], i))
                    return true;
            }
        }
        return false;
    }
}
