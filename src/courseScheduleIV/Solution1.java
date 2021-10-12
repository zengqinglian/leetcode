package courseScheduleIV;

import java.util.ArrayList;
import java.util.List;
/*
Add cache,
Runtime: 34 ms, faster than 81.65% of Java online submissions for Course Schedule IV.
Memory Usage: 87.7 MB, less than 19.38% of Java online submissions for Course Schedule IV.
 */
public class Solution1 {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites,
                                             int[][] queries) {
        Boolean[][] reachable = new Boolean[numCourses][numCourses];
        List<Integer>[] prerequisitesGraph = new List[numCourses];
        for(int[] prerequisit : prerequisites){
            reachable[prerequisit[0]][prerequisit[1]] = true;

            if(prerequisitesGraph[prerequisit[0]] == null){
                prerequisitesGraph[prerequisit[0]] = new ArrayList<>();
            }
            prerequisitesGraph[prerequisit[0]].add(prerequisit[1]);
        }
        List<Boolean> res = new ArrayList<>();
        for(int[] query : queries) {
            res.add(check(query[0], query[1], reachable, prerequisitesGraph));
        }
        return res;
    }

    private boolean check(int start, int end, Boolean[][] reachable, List<Integer>[] prerequisitesGraph) {
        if(reachable[start][end] !=null){
            return reachable[start][end];
        }
        if(prerequisitesGraph[start] == null){
            reachable[start][end] = false;
            return false;
        }
        boolean flag = false;
        for(int newStart : prerequisitesGraph[start]) {
            if(newStart == end) {
                flag = true;
                break;
            }
            flag = check(newStart, end, reachable, prerequisitesGraph);
            if(flag){
                break;
            }
        }
        reachable[start][end]=flag;
        return flag;
    }
}
