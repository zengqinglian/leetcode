package courseScheduleII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
Runtime
22 ms
Beats
6.20%
Memory
45 MB
Beats
16.78%
 */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] relations = new List[numCourses];
        for(int[] req: prerequisites) {
            int preReq = req[1];
            int course = req[0];
            List<Integer> relation = relations[course];
            if (relation == null) {
                relation = new ArrayList<>();
                relations[course] = relation;
            }
            relation.add(preReq);
        }
        int[] res  = new int[numCourses];
        int idx = 0;
        boolean[] courseTook = new boolean[numCourses];
        while(idx<numCourses) {
            boolean found = false;
            for(int i=0; i<relations.length;i++) {
                if (!courseTook[i]) {
                    if (relations[i] == null || relations[i].isEmpty()) {
                        courseTook[i]=true;
                        res[idx++] = i;
                        found = true;

                    } else if (checkDependency(courseTook, relations[i])) {
                        courseTook[i]=true;
                        res[idx++] = i;
                        found = true;
                    }
                }
            }
            if (!found) {
                break;
            }
        }
        if (idx != numCourses) {
            return new int[0];
        }
        return res;
    }

    private boolean checkDependency(boolean[] courseTook, List<Integer> relation) {
        for(int v : relation) {
            if (!courseTook[v]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
        int[][] prerequisites = {{0,1}};
        s.findOrder(2,prerequisites);
    }
}
