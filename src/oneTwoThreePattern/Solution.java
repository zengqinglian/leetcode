package oneTwoThreePattern;

import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    // overtime limit solution , failed 92/95
    public boolean find132pattern(int[] nums) {
	if(nums.length<3) {
	    return false;
	}

	TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();

	for (int i = 0; i < nums.length; i++) {
	    TreeSet<Integer> set = map.get(nums[i]);
	    if (set == null) {
		set = new TreeSet<>();
		map.put(nums[i], set);
	    } 
	    set.add(i);
	}

	for (int smallKey : map.keySet()) {
	    int smallKeyIndex = map.get(smallKey).first();
	    for (int largeKey : map.descendingKeySet()) {
		if (smallKey < largeKey) {
		    Integer largeKeyIndex = map.get(largeKey).higher(smallKeyIndex);
		    if (largeKeyIndex!=null && smallKeyIndex < largeKeyIndex) {
			SortedMap<Integer, TreeSet<Integer>> subMap = map.subMap(smallKey + 1, largeKey);
			for(TreeSet<Integer> set : subMap.values()) {
			    if (set.last() > largeKeyIndex) {
				return true;
			    }
			}
		    }
		}

	    }

	}
	return false;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] nums = { 3, 5, 0, 3, 4 };
	s.find132pattern(nums);
    }
}
