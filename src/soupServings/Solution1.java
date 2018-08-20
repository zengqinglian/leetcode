package soupServings;

public class Solution1 {

    // over time limit - update to N=80
    private static double result = 0;

    public double soupServings(int N) {
	updateResult(N, N, 1.0);

	return result;
    }

    public void updateResult(int leftA, int leftB, double odds) {
	double newOdds = (odds * 0.25);
	if (leftA - 100 <= 0) {
	    result += newOdds;
	} else {
	    updateResult(leftA - 100, leftB, newOdds);
	}

	// case 2
	if (leftA - 75 <= 0 && leftB - 25 <= 0) {
	    result += (newOdds / 2);
	} else if (leftA - 75 <= 0 && leftB - 25 > 0) {
	    result += newOdds;
	} else if (leftA - 75 > 0 && leftB - 25 > 0) {
	    updateResult(leftA - 75, leftB - 25, newOdds);
	}

	// case 3
	if (leftA - 50 <= 0 && leftB - 50 <= 0) {
	    result += (newOdds / 2);
	} else if (leftA - 50 <= 0 && leftB - 50 > 0) {
	    result += newOdds;
	} else if (leftA - 50 > 0 && leftB - 50 > 0) {
	    updateResult(leftA - 50, leftB - 50, newOdds);
	}

	// case 4
	if (leftA - 25 <= 0 && leftB - 75 <= 0) {
	    result += (newOdds / 2);
	} else if (leftA - 25 <= 0 && leftB - 75 > 0) {
	    result += newOdds;
	} else if (leftA - 25 > 0 && leftB - 75 > 0) {
	    updateResult(leftA - 25, leftB - 75, newOdds);
	}
    }
}
