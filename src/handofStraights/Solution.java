package handofStraights;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // 40ms solution beat 80%
    public boolean isNStraightHand(int[] hand, int W) {
	if(hand.length % W !=0) {
	    return false;
	}

	if (W == 1) {
	    return true;
	}

	Arrays.sort(hand);

	int len = hand.length / W;
	Map<Integer, List<Integer>> map = new HashMap<>();
	int size = 0;
	for (int i : hand) {
	    if (map.containsKey(i - 1)) {
		List<Integer> li = map.get(i - 1);
		int l = li.get(li.size() - 1);
		li.remove(li.size() - 1);
		size--;
		if (l < W - 1) {
		    List<Integer> newList = map.get(i);
		    if(newList==null) {
			newList = new ArrayList<>();
			map.put(i, newList);
		    }
		    newList.add(l + 1);
		    size++;
		}

		if (li.size() == 0) {
		    map.remove(i - 1);
		}

	    } else {

		List<Integer> newList = map.get(i);
		if (newList == null) {
		    newList = new ArrayList<>();
		    map.put(i, newList);
		}
		newList.add(1);
		size++;
		if (size > len) {
		    return false;
		}
	    }
	}
	if(map.isEmpty()) {
	    return true;
	}else {
	    return false;
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] hand = { 1, 2, 3, 6, 2, 3, 4, 7, 8 };
	s.isNStraightHand(hand, 3);
    }
}
