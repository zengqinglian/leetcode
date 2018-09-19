package carFleet;

import java.util.TreeMap;

public class Solution {
    // slow solution - 50ms beat 40%
    public int carFleet(int target, int[] position, int[] speed) {
	TreeMap<Integer, Double> map = new TreeMap<>();

	for (int i = 0; i < position.length; i++) {
	    double time = (target - position[i]) * 1.0 / speed[i];
	    map.put(position[i], time);
	}
	
	double curtime = 0;
	int count = 0;
	for (int key : map.descendingKeySet()) {

	    double time = map.get(key);

	    if (curtime == 0) {
		curtime = time;
		count++;
		continue;
	    }

	    if (curtime < time) {
		count++;
		curtime = time;
	    }
	}

	return count;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] position = { 0, 4, 2 };
	int[] speed = { 2, 1, 3 };
	s.carFleet(10, position, speed);
    }
}
