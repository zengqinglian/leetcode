package courseScheduleII;

import java.util.ArrayList;
import java.util.List;
/*
Runtime
3 ms
Beats
98.94%
Memory
44.4 MB
Beats
86.68%
 */
public class Solution1 {
    private int idx = 0;
    int[] res;
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
        res  = new int[numCourses];
        boolean[] courseTook = new boolean[numCourses];

        for(int i=0; i<relations.length; i++) {
            if (courseTook[i]){
                continue;
            }
            boolean canTake =  checkCourse (i, relations, courseTook, res, new boolean[numCourses]);
            if (!canTake) {
                return new int[0];
            }else{
                if (!courseTook[i]) {
                    courseTook[i] = true;
                    res[idx++] = i;
                }
            }
        }
        return res;
    }

    private boolean checkCourse(int course, List<Integer>[] relations, boolean[] courseTook, int[] res, boolean[] visited) {
        if (courseTook[course]) {
            return true;
        }
        if (visited[course]){
            return false;
        }
        visited[course]=true;

        if (relations[course]==null) {
            if (!courseTook[course]) {
                courseTook[course] = true;
                res[idx++] = course;
            }
            return true;
        }
        for (int pre : relations[course]) {
            boolean b = checkCourse(pre, relations, courseTook, res, visited);
            if (!b) {
                return false;
            }else{
                if (!courseTook[pre]) {
                    courseTook[pre] = true;
                    res[idx++] = pre;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[][] prerequisites = {{0,1},{1,0}};
        //int[][] prerequisites = {{0,1}};
        s.findOrder(2,prerequisites);
    }
}
