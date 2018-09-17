package loudandRich;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // 19 ms solution . beat 60%
    public int[] loudAndRich(int[][] richer, int[] quiet) {

	int[] result = new int[quiet.length];
	Arrays.fill(result, Integer.MAX_VALUE);
	List<Integer>[] group = new List[quiet.length];
	for (int[] arr : richer) {
	    int big = arr[0];
	    int small = arr[1];
	    if(group[small]==null) {
		List<Integer> li = new ArrayList<>();
		group[small] = li;
	    }
	    group[small].add(big);
	}

	for (int i = 0; i < group.length; i++) {
	    int index = updateResult(i, group, result, quiet);
	    if (quiet[i] > quiet[index]) {
		result[i] = index;
	    } else {
		result[i] = i;
	    }
	}
	return result;
    }

    private int updateResult(int i, List<Integer>[] group, int[] result, int[] quiet) {

	if (result[i] != Integer.MAX_VALUE) {
	    return result[i];
	}

	List<Integer> li = group[i];
	if (li == null || li.size() == 0) {
	    return i;
	} else {
	    int min = Integer.MAX_VALUE;
	    int index=-1;
	    for (int j : li) {
		int ret = updateResult(j, group, result, quiet);
		if (min > quiet[ret]) {
		    index = ret;
		    min = quiet[ret];
		}
	    }
	    result[i] = index;
	    
	    return index;
	}
    }

    public static void main(String[] args) {
	// int[][] richer = { { 1, 0 }, { 2, 1 }, { 3, 1 }, { 3, 7 }, { 4, 3 }, { 5, 3
	// }, { 6, 3 } };
	int[][] richer = { { 0, 1 }, { 1, 2 } };
	int[] quiet = { 1, 0, 2 };
	Solution s = new Solution();
	s.loudAndRich(richer, quiet);
    }

}
