package longestMountaininArray;

public class Solution {
    // 6ms solution - meet avg speed
    public int longestMountain(int[] A) {
	if (A.length < 3) {
	    return 0;
	}

	boolean foundBeginning = false;
	boolean increased = false;
	int result = 0;
	int count = 0;
	for (int i = 1; i < A.length; i++) {
	    if (!foundBeginning) {
		if (A[i - 1] < A[i]) {
		    foundBeginning = true;
		    count = 2;
		    increased = true;
		}
	    } else {
		if (A[i - 1] < A[i]) {
		    if(!increased) {
			increased = true;
			result = Math.max(result, count);
			count = 2;
		    } else {
			count++;
		    }
		} else if (A[i - 1] > A[i]) {
		    count++;
		    if (increased) {
			increased = false;
		    }
		} else {
		    foundBeginning = false;
		    increased = false;
		    if (count >= 3) {
			result = Math.max(result, count);
		    }
		    count = 0;
		}
	    }
	}

	if (foundBeginning && !increased)
	    result = Math.max(result, count);

	return result;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 0, 0, 1, 0, 0, 1, 1, 1, 1, 1 };
	s.longestMountain(A);
    }
}
