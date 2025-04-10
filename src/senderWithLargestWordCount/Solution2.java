package senderWithLargestWordCount;

import java.util.HashMap;
import java.util.Map;

/*
Runtime
57 ms
Beats 46.29%
Analyze Complexity
Memory
54.35 MB
Beats 81.98%
 */
public class Solution2 {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> countMap = new HashMap<>();
        int max = 0;
        for (int i=0; i<messages.length; i++) {
            int cnt = messages[i].split(" ").length;
            countMap.compute(senders[i], (k,v)->  (v == null)? cnt: v+cnt);
            max = Math.max(max, countMap.get(senders[i]));
        }
        Map.Entry<String, Integer> res = null;
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == max) {
                if (res == null) {
                    res = entry;
                }else{
                    if (res.getKey().compareTo(entry.getKey()) < 1) {
                        res = entry;
                    }
                }
            }
        }
        return res.getKey();
    }
}
