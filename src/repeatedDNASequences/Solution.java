package repeatedDNASequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // 30ms solution , meet avg speed, beat 50%
    public List<String> findRepeatedDnaSequences(String s) {
	List<String> result = new ArrayList<>();
	if (s.length() < 11) {
	    return result;
	}

	Map<String, Integer> map = new HashMap<>();
	for (int i = 0; i <= s.length() - 10; i++) {
	    String sub = s.substring(i, i + 10);
	    Integer I = map.get(sub);
	    if (I == null) {
		map.put(sub, 1);
	    } else {
		if (I == 1) {
		    result.add(sub);
		    map.put(sub, 2);
		}
	    }
	}
	return result;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.findRepeatedDnaSequences("AAAAAAAAAAA");
    }
}
