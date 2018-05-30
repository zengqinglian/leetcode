package pyramidTransitionMatrix;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    // 22ms solution meet 50% avg speed
    public boolean pyramidTransition(String bottom, List<String> allowed) {
	List<Set<Character>> valids = new ArrayList<>();
	for (char c : bottom.toCharArray()) {
	    Set<Character> set = new HashSet<>();
	    set.add(c);
	    valids.add(set);
	}
	return check(valids, allowed);

    }

    private boolean check(List<Set<Character>> valids, List<String> allowed) {
	if (valids.size() == 2) {
	    for (String s : allowed) {
		if (valids.get(0).contains(s.charAt(0)) && valids.get(1).contains(s.charAt(1))) {
		    return true;
		}
	    }
	    return false;
	} else {
	    List<Set<Character>> newList = new ArrayList<>();
	    for (int i = 1; i < valids.size(); i++) {
		Set<Character> set = new HashSet<>();
		for (String s : allowed) {
		    if (valids.get(i - 1).contains(s.charAt(0)) && valids.get(i).contains(s.charAt(1))) {
			set.add(s.charAt(2));
		    }
		}
		if (set.size() == 0) {
		    return false;
		}
		newList.add(set);
	    }
	    return check(newList, allowed);
	}
    }
}
