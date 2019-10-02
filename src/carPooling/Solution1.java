package carPooling;

public class Solution1 {
    // improve solution , 1ms , beat 99%
    public boolean carPooling(int[][] trips, int capacity) {
	int[] upOff = new int[1001];
	
	for(int[] trip : trips) {
	    upOff[trip[1]]+=trip[0];
	    upOff[trip[2]] -= trip[0];
	}

	for (int v : upOff) {
	    capacity -= v;
	    if (capacity < 0) {
		return false;
	    }
	}
	return true;
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	int[][] trips = { { 2, 1, 5 }, { 3, 3, 7 } };
	s.carPooling(trips, 4);
    }
}
