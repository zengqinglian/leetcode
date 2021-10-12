package courseScheduleIV;

import java.util.ArrayList;
import java.util.List;

/*
28 / 68 test cases passed.
Timeover solutions
 */
public class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites,
                                             int[][] queries) {
        List<Integer>[] prerequisitesGraph = new List[numCourses];

        for(int[] prerequisit : prerequisites){
            if(prerequisitesGraph[prerequisit[1]] == null){
                prerequisitesGraph[prerequisit[1]] = new ArrayList<>();
            }
            prerequisitesGraph[prerequisit[1]].add(prerequisit[0]);
        }
        List<Boolean> res = new ArrayList<>();
        for(int[] query : queries) {
            res.add(check(query[0], query[1], prerequisitesGraph));
        }
        return res;
    }

    private boolean check(int pre, int course, List<Integer>[] prerequisitesGraph) {

        if(prerequisitesGraph[course] == null){
            return false;
        }
        boolean res = false;
        for(int preCourse : prerequisitesGraph[course]) {
            if(preCourse == pre) {
                return true;
            }
            res = check(pre, preCourse, prerequisitesGraph);
            if(res){
                break;
            }
        }
        return res;
    }
}
