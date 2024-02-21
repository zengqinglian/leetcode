package courseScheduleII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] dependants = new List[numCourses];
        int[] dependantsCount = new int[numCourses];
        int[] ans = new int[numCourses];
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
        for (int i=0; i<numCourses; i++) {
            if (dependantsCount[i] ==0) {
                canTakes.add(i);
            }
        }
        int index = 0;
        while (!canTakes.isEmpty()) {
            int course = canTakes.poll();
            ans[index++] = course;
            if (dependants[course]!=null) {
                for (int deps : dependants[course]) {
                    dependantsCount[deps]--;
                    if (dependantsCount[deps] ==0) {
                        canTakes.add(deps);
                    }
                }
            }
        }
        if (index != numCourses) {
            return new int[0];
        }
        return ans;
    }
}
