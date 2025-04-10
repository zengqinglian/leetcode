package senderWithLargestWordCount;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
/*
Runtime
82ms Beats
22.97%
Analyze Complexity
Memory
55.14 MB
Beats
41.70%
 */
public class Solution1 {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> countMap = new HashMap<>();
        int max = 0;
        for (int i=0; i<messages.length; i++) {
            int cnt = messages[i].split(" ").length;
            countMap.compute(senders[i], (k,v)->  (v == null)? cnt: v+cnt);
            max = Math.max(max, countMap.get(senders[i]));
        }
        final int targetValue = max;
        var res = countMap.entrySet().stream().filter(e-> e.getValue() == targetValue).sorted(Collections.reverseOrder(Map.Entry.comparingByKey())).collect(Collectors.toList());
        return res.get(0).getKey();
    }

    public static void main(String[] args) {
        String[] messages = {"Hello userTwooo","Hi userThree","Wonderful day Alice","Nice day userThree"};
        String[] senders ={"Alice","userTwo","userThree","Alice"};
        Solution s = new Solution();
        s.largestWordCount(messages,senders);
    }
}
