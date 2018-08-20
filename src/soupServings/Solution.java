package soupServings;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // over memory limit solution , deal with up to 500
    public double soupServings(int N) {
	if (N == 0) {
	    return 0.5;
	}
	Queue<QueueObj> q = new LinkedList<>();
	QueueObj init = new QueueObj(1.0, N, N);

	q.add(init);

	double result = 0;
	while (!q.isEmpty()) {
	    QueueObj obj = q.poll();
	    // case 1
	    double newOdds = (obj.odds * 0.25);
	    if (obj.leftA - 100 <= 0) {
		result += newOdds;
	    } else {
		q.add(new QueueObj(newOdds, obj.leftA - 100, obj.leftB));
	    }

	    // case 2
	    if (obj.leftA - 75 <= 0 && obj.leftB - 25 <= 0) {
		result += (newOdds / 2);
	    } else if (obj.leftA - 75 <= 0 && obj.leftB - 25 > 0) {
		result += newOdds;
	    } else if (obj.leftA - 75 > 0 && obj.leftB - 25 > 0) {
		q.add(new QueueObj(newOdds, obj.leftA - 75, obj.leftB - 25));
	    }

	    // case 3
	    if (obj.leftA - 50 <= 0 && obj.leftB - 50 <= 0) {
		result += (newOdds / 2);
	    } else if (obj.leftA - 50 <= 0 && obj.leftB - 50 > 0) {
		result += newOdds;
	    } else if (obj.leftA - 50 > 0 && obj.leftB - 50 > 0) {
		q.add(new QueueObj(newOdds, obj.leftA - 50, obj.leftB - 50));
	    }

	    // case 4
	    if (obj.leftA - 25 <= 0 && obj.leftB - 75 <= 0) {
		result += (newOdds / 2);
	    } else if (obj.leftA - 25 <= 0 && obj.leftB - 75 > 0) {
		result += newOdds;
	    } else if (obj.leftA - 25 > 0 && obj.leftB - 75 > 0) {
		q.add(new QueueObj(newOdds, obj.leftA - 25, obj.leftB - 75));
	    }

	}
	return result;
    }

    private class QueueObj {
	private double odds;
	private int leftA;
	private int leftB;

	private QueueObj(double odds, int leftA, int leftB) {
	    super();
	    this.odds = odds;
	    this.leftA = leftA;
	    this.leftB = leftB;
	}

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.soupServings(75);
    }
}
