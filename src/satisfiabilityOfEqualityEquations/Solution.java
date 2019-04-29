package satisfiabilityOfEqualityEquations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
    // 6ms solution , beat 80%
    public boolean equationsPossible(String[] equations) {
	Set<Character>[] set = new Set[26];
	for (String s : equations) {
	    if (s.substring(1, 3).equals("==")) {
		char c1 = s.charAt(0);
		char c2 = s.charAt(3);
		if (set[c1 - 'a'] == null) {
		    set[c1 - 'a'] = new HashSet<>();
		}
		if (set[c2 - 'a'] == null) {
		    set[c2 - 'a'] = new HashSet<>();
		}
		set[c1 - 'a'].add(c1);
		set[c1 - 'a'].add(c2);
		set[c2 - 'a'].add(c1);
		set[c2 - 'a'].add(c2);
	    }
	}

	boolean[] vistited = new boolean[26];
	List<Set<Character>> li = new ArrayList<>();
	for (int i = 0; i < 26; i++) {
	    if (!vistited[i] && set[i] != null) {
		Set<Character> newSet = new HashSet<>();
		Queue<Set<Character>> q = new LinkedList<>();
		q.add(set[i]);
		vistited[i] = true;
		while (!q.isEmpty()) {
		    Set<Character> node = q.poll();
		    newSet.addAll(node);
		    for (char c : node) {
			if (!vistited[c - 'a'] && set[c - 'a'] != null) {
			    q.add(set[c - 'a']);
			    vistited[c - 'a'] = true;
			}
		    }
		}
		li.add(newSet);
	    }
	}

	for (String s : equations) {
	    if (s.substring(1, 3).equals("!=")) {
		char c1 = s.charAt(0);
		char c2 = s.charAt(3);
		if (c1 == c2) {
		    return false;
		}
		for (Set<Character> group : li) {
		    if (group.contains(c1) && group.contains(c2)) {
			return false;
		    }
		}
	    }
	}
	return true;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	String[] equations = { "a==b", "e==c", "b==c", "a!=e" };
	s.equationsPossible(equations);
    }
}
