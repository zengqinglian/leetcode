package corporateFlightBookings;

public class Solution {
    // 9ms solution, beat 65%
    public int[] corpFlightBookings(int[][] bookings, int n) {
	int[][] states = new int[n][2];
	for (int[] book : bookings) {
	    states[book[0] - 1][0] += book[2];
	    states[book[1] - 1][1] += book[2];
	}
	int cur = 0;
	int[] result = new int[n];
	for (int i = 0; i < result.length; i++) {
	    if (states[i][0] > 0) {
		result[i] = cur + states[i][0];
		cur = result[i];
		
	    } else if (result[i] == 0) {
		result[i] = cur;
	    }
	    if (states[i][1] > 0) {
		cur -= states[i][1];
	    }
	}
	return result;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[][] bookings = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
	s.corpFlightBookings(bookings, 5);
    }
}
