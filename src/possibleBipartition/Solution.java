package possibleBipartition;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    // 40ms solution, beat 50%
    public boolean possibleBipartition(int N, int[][] dislikes) {
	List<Integer>[] checker = new List[N + 1];
	for (int i = 0; i < dislikes.length; i++) {
	    int[] dislike = dislikes[i];
	    List<Integer> li = checker[dislike[0]];
	    if (li == null) {
		li = new ArrayList<>();
		checker[dislike[0]] = li;
	    }
	    li.add(dislike[1]);
	}
	boolean[] dp = new boolean[N+1];
	for (int i = 1; i <= N; i++) {
	    if (!dp[i] && checker[i]!=null) {
		boolean[] set1 = new boolean[N + 1];
		boolean[] set2 = new boolean[N + 1];
		set1[i] = true;
		Stack<Integer> stack = new Stack<>();
		stack.add(i);
		dp[i] = true;
		while (!stack.isEmpty()) {
		    int key = stack.pop();
		    List<Integer> values = checker[key];
		    if (values != null) {
			if (set1[key]) {
			    for (int val : values) {
				if (set1[val]) {
				    return false;
				}
				set2[val] = true;
				if (!dp[val]) {
				    stack.push(val);
				    dp[val] = true;
				}
			    }
			} else if (set2[key]) {
			    for (int val : values) {
				if (set2[val]) {
				    return false;
				}
				set1[val] = true;
				stack.push(val);
				if (!dp[val]) {
				    stack.push(val);
				    dp[val] = true;
				}
			    }
			}
		    }
		}
	    }
	}

	return true;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[][] dislikes = { { 4, 7 }, { 4, 8 }, { 5, 6 }, { 1, 6 }, { 3, 7 }, { 2, 5 }, { 5, 8 }, { 1, 2 }, { 4, 9 },
		{ 6, 10 }, { 8, 10 }, { 3, 6 }, { 2, 10 }, { 9, 10 }, { 3, 9 }, { 2, 3 }, { 1, 9 }, { 4, 6 }, { 5, 7 },
		{ 3, 8 }, { 1, 8 }, { 1, 7 }, { 2, 4 } };

	s.possibleBipartition(10, dislikes);
    }
}
