package rabbitsinForest;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 7ms solution beat 50%
    public int numRabbits(int[] answers) {
	Map<Integer, Integer> map = new HashMap<>();
	for(int i : answers) {
	    if(map.containsKey(i)) {
		map.put(i, map.get(i)+1);
	    }else {
		map.put(i, 1);
	    }
	}

	int min = 0;
	for (int i : map.keySet()) {
	    int num = map.get(i);
	    min += (num / (i + 1)) * (i + 1);
	    int addon = num % (i + 1);
	    if (addon > 0) {
		min += (i + 1);
	    }
	}



	return min;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] answers = { 0, 2, 0, 2, 1 };
	s.numRabbits(answers);
    }
}
