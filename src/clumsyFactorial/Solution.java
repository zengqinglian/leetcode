package clumsyFactorial;

public class Solution {
    // 2ms solution , beat 50%
    public int clumsy(int N) {
	int remain = N % 4;
	int[] arr = new int[N / 4 + 1];
	int idx = 0;
	int extra = 0;
	for (int i = N; i >= 4; i = i - 4) {
	    int res = Math.floorDiv(i * (i - 1), (i - 2));
	    extra += (i - 3);
	    arr[idx] = res;
	    idx++;
	}

	if (remain == 1) {
	    arr[idx] = 1;
	}
	if (remain == 2) {
	    arr[idx] = 2;
	}
	if (remain == 3) {
	    arr[idx] = 6;
	}

	int res = arr[0];
	for (int i = 1; i < arr.length; i++) {
	    res -= arr[i];
	}

	return res + extra;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.clumsy(10);
    }
}
