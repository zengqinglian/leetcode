package minimumSwapsToMakeSequencesIncreasing;

public class Solution1 {
    // 17ms DP solution beat 2%
    public int minSwap(int[] A, int[] B) {
	if (A.length == 1) {
	    return 0;
	}
	int[][][] dp = new int[A.length][2][3];

	int[] initialCase1 = new int[3];
	initialCase1[0] = A[0];
	initialCase1[1] = B[0];
	initialCase1[2] = 0;

	int[] initialCase2 = new int[3];
	initialCase2[0] = B[0];
	initialCase2[1] = A[0];
	if (A[0] != B[0]) {
	    initialCase2[2] = 1;
	} else {
	    initialCase2[2] = 0;
	}

	int[][] init = { initialCase1, initialCase2 };

	dp[0] = init;

	for (int i = 1; i < A.length; i++) {
	    int[] preCase1 = dp[i - 1][0];
	    int[] preCase2 = dp[i - 1][1];


	    int[] case1 = null;
	    int[] case2 = null;

	    if ((preCase1 != null && preCase1[0] < A[i] && preCase1[1] < B[i])
		    || (preCase2 != null && preCase2[0] < A[i] && preCase2[1] < B[i])) {
		case1 = new int[3];
		case1[0] = A[i];
		case1[1] = B[i];
		if (A[i] == B[i]) {
		    if (preCase1 != null)
			case1[2] = preCase1[2];
		    if (preCase2 != null) {
			case1[2] = Math.min(case1[2], preCase2[2]);
		    }

		} else {
		    int newVal = Integer.MAX_VALUE;
		    if (preCase1 != null && preCase1[0] < A[i] && preCase1[1] < B[i] && newVal > preCase1[2]) {
			newVal = preCase1[2];
		    }
		    if (preCase2 != null && preCase2[0] < A[i] && preCase2[1] < B[i] && newVal > preCase2[2]) {
			newVal = preCase2[2];
		    }
		    case1[2] = newVal;
		}
	    }
	    dp[i][0] = case1;

	    if ((preCase1 != null && preCase1[0] < B[i] && preCase1[1] < A[i])
		    || (preCase2 != null && preCase2[0] < B[i] && preCase2[1] < A[i])) {
		case2 = new int[3];
		case2[0] = B[i];
		case2[1] = A[i];
		if (A[i] == B[i]) {
		    if (preCase1 != null)
			case2[2] = preCase1[2];
		    if (preCase2 != null) {
			case2[2] = Math.min(case2[2], preCase2[2]);
		    }
		} else {
		    int newVal = Integer.MAX_VALUE;
		    if (preCase1 != null && preCase1[0] < B[i] && preCase1[1] < A[i] && newVal > preCase1[2]) {
			newVal = preCase1[2] + 1;
		    }
		    if (preCase2 != null && preCase2[0] < B[i] && preCase2[1] < A[i] && newVal > preCase2[2]) {
			newVal = preCase2[2] + 1;
		    }
		    case2[2] = newVal;
		}
	    }
	    dp[i][1] = case2;
	}

	int result = Math.min(dp[A.length - 1][0][2], dp[A.length - 1][1][2]);
	return result;

    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	int[] A = { 0, 7, 8, 10, 10, 11, 12, 13, 19, 18 };
	int[] B = { 4, 4, 5, 7, 11, 14, 15, 16, 17, 20 };
	// int[] A = { 1, 3, 5, 4 };
	// int[] B = { 1, 2, 3, 7 };
	s.minSwap(A, B);
    }
}
