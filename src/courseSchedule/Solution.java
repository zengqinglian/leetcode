package courseSchedule;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
Runtime
6 ms
Beats
53.89%
Memory
44.5 MB
Beats
27.40%
 */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] dependencies = new List[numCourses];
        List<Integer>[] preRequirements = new List[numCourses];

        for (int[] pre : prerequisites) {
            int preReq = pre[0];
            int course = pre[1];

            List<Integer> li = dependencies[preReq];
            if (li == null) {
                li = new ArrayList<>();
                dependencies[preReq] = li;
            }
            li.add(course);

            List<Integer> li2 = preRequirements[course];
            if (li2 == null) {
                li2 = new ArrayList<>();
                preRequirements[course]= li2;
            }
            li2.add(preReq);
        }

        int[] courses = new int[numCourses];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if (courses[i]>0) {
                continue;
            }
            if (preRequirements[i] == null) {
                q.add(i);
                courses[i] = 1;
                count++;
            }
            while (!q.isEmpty()) {
                int pos = q.poll();
                if (dependencies[pos]== null) {
                    continue;
                }
                for(int newPos : dependencies[pos]) {
                    courses[newPos]++;
                    if (preRequirements[newPos]!=null && preRequirements[newPos].size() == courses[newPos]) {
                        count++;
                        q.add(newPos);
                    }
                }
            }
        }
        return count == numCourses;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] prerequisites = {{1,0},{1,2}};
        s.canFinish(3,prerequisites);
    }
}
