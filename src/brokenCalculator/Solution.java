package brokenCalculator;

public class Solution {
    // overtime solution
    public int brokenCalc(int X, int Y) {
	if (X == Y) {
	    return 0;
	}
	if (Y < X) {
	    return X - Y;
	}

	if (X * 2 >= Y) {
	    int cnt = (X * 2 - Y) + 1;

	    for (int i = X - 1; i > X / 2; i--) {
		int newCnt = (X - i) + brokenCalc(i * 2, Y) + 1;
		cnt = Math.min(cnt, newCnt);

	    }
	    return cnt;
	}

	int cnt = 1 + brokenCalc(X * 2, Y);
	for (int i = X - 1; i > X / 2; i--) {
	    int newCnt = (X - i) + brokenCalc(i * 2, Y) + 1;
	    cnt = Math.min(cnt, newCnt);

	}
	return cnt;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	System.out.println(s.brokenCalc(5, 23));
    }
}
