package grumpyBookstoreOwner;

public class Solution {
    // 3ms solution , beat 80%
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {

	int startIndex = 0;
	int max = 0;

	if (X >= customers.length) {
	    int res = 0;
	    for (int v : customers) {
		res += v;
	    }
	    return res;
	}

	for (int i = 0; i < X; i++) {
	    if (grumpy[i] == 1) {
		max += customers[i];
	    }
	}
	int val = max;
	for (int i = 1; i <= customers.length - X; i++) {
	    if (grumpy[i - 1] == 1) {
		val = val - customers[i - 1];
	    }
	    if (grumpy[i + X - 1] == 1) {
		val = val + customers[i + X - 1];
	    }
	    if (val > max) {
		startIndex = i;
		max = val;
	    }
	}
	int res = 0;
	for (int i = 0; i < startIndex; i++) {
	    if (grumpy[i] == 0) {
		res += customers[i];
	    }
	}

	for (int i = startIndex; i < startIndex + X; i++) {
	    if (grumpy[i] == 0) {
		res += customers[i];
	    }
	}

	for (int i = startIndex + X; i < customers.length; i++) {
	    if (grumpy[i] == 0) {
		res += customers[i];
	    }
	}

	return res + max;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] customers = { 2, 6, 6, 9 };
	int[] grumpy = { 0, 0, 1, 1 };
	s.maxSatisfied(customers, grumpy, 1);
    }
}
