package partitionLabels;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    // 40ms solution , beat 10%
    public List<Integer> partitionLabels(String S) {
	List<Set<Character>> checkList = new ArrayList<>();
	List<Integer> result = new ArrayList<>();
	for (char c : S.toCharArray()) {
	    boolean found = false;
	    int index = -1;
	    for (int i = 0; i < checkList.size(); i++) {
		if (checkList.get(i).contains(c)) {
		    found = true;
		    index = i;
		    break;
		}
	    }
	    if (!found) {
		Set<Character> newSet = new HashSet<>();
		newSet.add(c);
		checkList.add(newSet);
		result.add(1);
	    } else {
		for (int j = checkList.size() - 1; j > index; j--) {
		    Set<Character> removeSet = checkList.remove(j);
		    checkList.get(index).addAll(removeSet);
		    int removeInt = result.remove(j);
		    result.set(index, result.get(index) + removeInt);
		}
		checkList.get(index).add(c);
		result.set(index, result.get(index) + 1);
	    }
	}
	return result;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.partitionLabels("ababcbacadefegdehijhklij");
    }
}
