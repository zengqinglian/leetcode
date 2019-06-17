package capacityToShipPackagesWithinDays;

public class Solution {
    // 7ms solution, faster than 90%
    public int shipWithinDays(int[] weights, int D) {

	int total = 0;
	int min = 0;
	for (int i = 0; i <= weights.length - D; i++) {
	    total += weights[i];
	    min = Math.max(min, weights[i]);
	}

	int max = total;

	for (int i = weights.length - D + 1, j = 0; i < weights.length; i++, j++) {
	    total -= weights[j];
	    total += weights[i];
	    min = Math.max(min, weights[i]);
	    max = Math.max(max, total);
	}

	int start = min;
	int end = max;
	

	while (start <= end) {
	    int mid = (start + end) / 2;
	    int days = checkDays(mid, weights);
	    if (days == D) {
		end = mid;
		if (mid == start) {
		    return mid;
		}
	    } else if (days > D) {
		if (mid == start) {
		    return end;
		}
		start = mid;
	    } else {
		if (mid == start) {
		    return start;
		}
		end = mid;
	    }

	}

	return -1;

	// int res = help(weights, 1, D, 0, avg);

	// return res;

    }

    private int checkDays(int mid, int[] weights) {
	int days=0;
	int total=0;
	for(int w : weights) {
	    int newTotal = total + w;
	    if (newTotal > mid) {
		days++;
		total = w;
	    } else {
		total = newTotal;
	    }
	}
	return days + 1;
    }


    public static void main(String[] args) {
	Solution s = new Solution();
	int[] weights = { 1, 2, 3, 4, 5 };
	int D = 5;
	s.shipWithinDays(weights, D);
    }
}
