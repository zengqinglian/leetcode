package partitionLabels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    // 22ms, beat 35%
    public List<Integer> partitionLabels(String S) {

	Map<Character, Integer> map = new HashMap<>();
	int[] countArray = new int[S.length()];

	for (int i = 0; i < S.length(); i++) {
	    char c = S.charAt(i);
	    if (!map.containsKey(c)) {
		map.put(c, i);
		countArray[i] = i;
	    } else {
		int start = map.get(c);
		for (int j = start + 1; j <= i; j++) {
		    countArray[j] = countArray[start];
		}
	    }
	}

	List<Integer> result = new ArrayList<>();

	int start = 0;
	int end = 1;
	result.add(1);
	while (end < S.length()) {
	    if (countArray[end] != countArray[start]) {
		result.set(result.size() - 1, (end - start));
		result.add(1);
		start = end;
		end = start;
	    }
	    end++;
	}

	result.set(result.size() - 1, (end - start));

	return result;

    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	s.partitionLabels("vhaagbqkaq");
    }
}
