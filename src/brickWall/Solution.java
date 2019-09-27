package brickWall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // 10ms solution , beat 90%
    public int leastBricks(List<List<Integer>> wall) {
	Map<Integer, Integer> map = new HashMap<>();
	int max = 0;
	for (int i = 0; i < wall.size(); i++) {
	    int cnt = 0;
	    for (int j = 0; j < wall.get(i).size() - 1; j++) {
		int v = wall.get(i).get(j);
		cnt += v;
		Integer val = map.get(cnt);
		if (val == null) {
		    map.put(cnt, 1);
		    max = Math.max(max, 1);
		} else {
		    map.put(cnt, 1 + val);
		    max = Math.max(max, 1 + val);
		}
	    }
	}
	
	return wall.size() - max;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	List<List<Integer>> wall = new ArrayList<>();
	List<Integer> li1 = Arrays.asList(1, 2, 2, 1);
	List<Integer> li2 = Arrays.asList(3, 1, 2);
	List<Integer> li3 = Arrays.asList(1, 3, 2);
	List<Integer> li4 = Arrays.asList(2, 4);
	List<Integer> li5 = Arrays.asList(3, 1, 2);
	List<Integer> li6 = Arrays.asList(1, 3, 1, 1);
	wall.add(li1);
	wall.add(li2);
	wall.add(li3);
	wall.add(li4);
	wall.add(li5);
	wall.add(li6);

	s.leastBricks(wall);
    }
}
