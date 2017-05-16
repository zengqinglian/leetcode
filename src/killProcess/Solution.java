package killProcess;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    // BFS - time over
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(kill);

        while (!queue.isEmpty()) {
            int e = queue.poll();
            result.add(e);
            for (int i = 0; i < ppid.size(); i++) {
                if (ppid.get(i) == e) {
                    queue.add(pid.get(i));
                }
            }
        }

        return result;
    }
}
