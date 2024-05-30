package courseScheduleiv;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] dependences = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int prereq = prerequisite[0];
            int target = prerequisite[1];
            if (graph[prereq]==null) {
                graph[prereq] = new ArrayList<>();
            }
            graph[prereq].add(target);
            dependences[target]++;
        }
        int tookcourse = 0;
        boolean[] finishedCourses = new boolean[numCourses];
        Set<Integer>[] resultSets = new HashSet[numCourses];
        while (tookcourse < numCourses) {
            boolean found = false;
            for (int i = 0; i < numCourses; i++) {
                if (!finishedCourses[i] && dependences[i] ==0) {
                    found = true;
                    finishedCourses[i] = true;
                    tookcourse++;
                    if (graph[i] != null) {
                        for (int unlocked : graph[i]) {
                            dependences[unlocked]--;
                            if (resultSets[unlocked]==null) {
                                resultSets[unlocked] = new HashSet<>();
                            }
                            resultSets[unlocked].add(i);
                            if (resultSets[i]!=null) {
                                resultSets[unlocked].addAll(resultSets[i]);
                            }
                        }
                    }
                }
                if (found) {
                    break;
                }
            }
            if (!found) {
                break;
            }
        }
        List<Boolean> res = new ArrayList<>();
        for (int[] query : queries) {
            res.add(resultSets[query[1]]!=null && resultSets[query[1]].contains(query[0]));
        }
        return res;
    }
}
