package courseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<Integer>[] dependants = new List[n];
        int[] dependantsCount = new int[n];
        int ans = 0;
        for (int[] courses : prerequisites) {
            int course = courses[0];
            int prerequisity = courses[1];
            if (dependants[prerequisity] == null) {
                dependants[prerequisity] =  new ArrayList<>();
            }
            dependants[prerequisity].add(course);
            dependantsCount[course]++;
        }
        Queue<Integer> canTakes = new LinkedList<>();
        for (int i=0; i<n; i++) {
            if (dependantsCount[i] ==0) {
                canTakes.add(i);
            }
        }
        while (!canTakes.isEmpty()) {
            int course = canTakes.poll();
            ans++;
            if (dependants[course]!=null) {
                for (int deps : dependants[course]) {
                    dependantsCount[deps]--;
                    if (dependantsCount[deps] ==0) {
                        canTakes.add(deps);
                    }
                }
            }
        }
        return ans == n;
    }
}
