package maxConsecutiveOnesIII;

public class Solution {
    // 4ms solution , beat 80%
    public int longestOnes(int[] A, int K) {
	int i = 0;
	int j = 0;
	int len = 0;
	int max = 0;
	while (j < A.length) {
	    int val = A[j];
	    if (val == 1) {
		len++;
		j++;
	    } else {
		if (K > 0) {
		    K--;
		    len++;
		    j++;
		} else {
		    for (int n = i; n <= j; n++) {
			if (A[n] == 1) {
			    len--;
			} else {
			    i = n + 1;
			    j++;
			    break;
			}
		    }
		}

	    }
	    max = Math.max(max, len);
	}

	return max;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };

	s.longestOnes(A, 3);
    }
}
