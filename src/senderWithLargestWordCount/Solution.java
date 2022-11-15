package senderWithLargestWordCount;

import java.util.HashMap;
import java.util.Map;
/*
Runtime: 141 ms, faster than 46.96% of Java online submissions for Sender With Largest Word Count.
Memory Usage: 106.7 MB, less than 30.87% of Java online submissions for Sender With Largest Word Count.
 */
public class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (int i=0; i<messages.length; i++) {
            Integer v = map.get(senders[i]);
            if (v == null ) {
                v= messages[i].split(" ").length;
            }else {
                v += messages[i].split(" ").length;
            }
            map.put(senders[i], v);
            max = Math.max(v, max);
        }
        String name = null;
        for (String key : map.keySet()) {
            if (map.get(key) == max) {
                if (name == null ) {
                    name = key;
                }else {
                    if (name.compareTo(key) < 0) {
                        name = key;
                    }
                }
            }
        }
        return name;

    }
}
