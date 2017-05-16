package killProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution1 {
    // improvement beat 75% . map and cache result
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> cache = new HashMap<>();

        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) == 0) {
                continue;
            }
            if (cache.containsKey(ppid.get(i))) {
                cache.get(ppid.get(i)).add(pid.get(i));
            } else {
                List<Integer> li = new ArrayList<>();
                li.add(pid.get(i));
                cache.put(ppid.get(i), li);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        queue.add(kill);

        while (!queue.isEmpty()) {
            int e = queue.poll();
            result.add(e);
            if (cache.containsKey(e)) {
                queue.addAll(cache.get(e));
            }
        }
        return result;
    }
}
