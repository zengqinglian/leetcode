package minimumCostForTickets;

public class Solution {
    // 5ms meet avg spped. beat 50%
    public int mincostTickets(int[] days, int[] costs) {
	int[] dp = new int[days.length + 1];

	for (int i = 0; i < days.length; i++) {
	    int day = days[i];
	    if (dp[i + 1] == 0) {
		dp[i + 1] = dp[i] + costs[0];
	    } else {
		dp[i + 1] = Math.min(dp[i + 1], dp[i] + costs[0]);
	    }

	    dp[i + 1] = Math.min(dp[i + 1], dp[i] + costs[1]);
	    for (int j = i + 1; j < days.length; j++) {
		if (days[j] - day <= 6) {
		    if (dp[j + 1] == 0) {
			dp[j + 1] = dp[i] + costs[1];
		    } else {
			dp[j + 1] = Math.min(dp[j + 1], dp[i] + costs[1]);
		    }
		} else {
		    break;
		}
	    }

	    dp[i + 1] = Math.min(dp[i + 1], dp[i] + costs[2]);
	    for (int j = i + 1; j < days.length; j++) {
		if (days[j] - day <= 29) {
		    if (dp[j + 1] == 0) {
			dp[j + 1] = dp[i] + costs[2];
		    } else {
			dp[j + 1] = Math.min(dp[j + 1], dp[i] + costs[2]);
		    }
		} else {
		    break;
		}
	    }

	}
	return dp[days.length];

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] days = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31 };
	int[] costs = { 2, 7, 15 };
	s.mincostTickets(days, costs);
    }
}
