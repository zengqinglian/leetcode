package deleteColumnstoMakeSortedII;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // 8ms solution - beat 70%
    public int minDeletionSize(String[] A) {

	Set<Integer> deletedPos = new HashSet<>();
	Set<Integer> goodPos = new HashSet<>();

	if (A.length <= 1) {
	    return 0;
	}

	for (int i = 1; i < A.length; i++) {
	    int idx = 0;
	    while (idx < A[0].length()) {
		if (deletedPos.contains(idx)) {
		    idx++;
		    continue;
		}

		char front = A[i - 1].charAt(idx);
		char back = A[i].charAt(idx);
		if (front < back) {
		    goodPos.add(idx);
		    break;
		} else if (front == back) {
		    goodPos.add(idx);
		    idx++;
		} else {
		    deletedPos.add(idx);
		    if (goodPos.remove(idx)) {
			i = 0;
			break;
		    }
		    idx++;
		}
	    }

	}

	return deletedPos.size();
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	String[] A = { "doeeqiy", "yabhbqe", "twckqte" };
	s.minDeletionSize(A);
    }
}
