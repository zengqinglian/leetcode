package brokenCalculator;

public class Solution1 {
    // backward solution. meet avg speed.
    public int brokenCalc(int X, int Y) {
	int ans = 0;
	while (Y > X) {
	    ans++;
	    if (Y % 2 == 1)
		Y++;
	    else
		Y /= 2;
	}

	return ans + X - Y;
    }
}
