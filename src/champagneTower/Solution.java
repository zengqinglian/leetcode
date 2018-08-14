package champagneTower;

public class Solution {
    // 18ms solution beat 70%
    public double champagneTower(int poured, int query_row, int query_glass) {
	if (query_row == 0) {
	    if (poured >= 1) {
		return 1;
	    }
	    return poured;
	}
	int row = 1;
	double[] tracker = new double[1];
	tracker[0] = poured;
	while (row <= query_row) {
	    double[] newArr = new double[row + 1];
	    for (int i = 0; i < newArr.length; i++) {
		if (i == 0)
		    newArr[i] = tracker[i] > 1.0 ? ((tracker[i] - 1) / 2.0) : 0.0;
		else if (i == newArr.length - 1)
		    newArr[i] = tracker[i - 1] > 1.0 ? ((tracker[i - 1] - 1) / 2.0) : 0.0;
		else
		    newArr[i] = (tracker[i] > 1.0 ? ((tracker[i] - 1) / 2.0) : 0.0)
			    + (tracker[i - 1] > 1.0 ? ((tracker[i - 1] - 1) / 2.0) : 0.0);
	    }
	    tracker = newArr;
	    row++;
	}

	return tracker[query_glass] >= 1 ? 1 : tracker[query_glass];
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.champagneTower(10, 3, 0);
    }
}
