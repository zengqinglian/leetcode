package longestTurbulentSubarray;

public class Solution1 {
    // 5ms solution , beat 90%
    public int maxTurbulenceSize(int[] A) {
	int max = 1;
	boolean isUp = false;
	for (int i = 0, j = 0; i < A.length; i++) {
	   if(i==j) {
	       continue;
	    } else {
		if (A[i] == A[i - 1]) {
		    j = i;
		} else if (A[i] > A[i - 1]) {
		    if (!isUp) {
			max = Math.max(i - j + 1, max);
		    } else {
			j = i - 1;
		    }
		    isUp = true;
		} else {
		    if (isUp) {
			max = Math.max(i - j + 1, max);
		    } else {
			j = i - 1;
		    }
		    isUp = false;
		}
	   }
	   

	}
	return max;
    }

}
