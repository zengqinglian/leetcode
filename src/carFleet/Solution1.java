package carFleet;

import java.util.Arrays;

public class Solution1 {
    // someone's solution without sorting or treemap. meet avg 50%
    public int carFleet(int target, int[] position, int[] speed) {
	int fleets = 0;
	double max = -1;

	double[] distribution = new double[target + 1];

	Arrays.fill(distribution, -1);

	for (int i = 0; i < position.length; i++) {
	    distribution[position[i]] = (double) (target - position[i]) / speed[i];
	}

	for (int i = distribution.length - 1; i >= 0; i--) {
	    if (distribution[i] > max) {
		max = distribution[i];
		fleets++;
	    }
	}

	return fleets;
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	int[] position = { 10, 10, 8, 0, 5, 3, 9 };
	int[] speed = { 2, 3, 4, 1, 1, 3, 5 };
	s.carFleet(12, position, speed);
    }
}
