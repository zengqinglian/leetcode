package robotBoundedInCircle;

public class Solution {
    // 0ms solution , beat 100%
    public boolean isRobotBounded(String instructions) {
	int x = 0;
	int y = 0;
	int plusX = 0;
	int plusY = 1;

	for (char c : instructions.toCharArray()) {
	    if (c == 'G') {
		x += plusX;
		y += plusY;
		continue;
	    }

	    if (c == 'L') {
		if (plusX == 1) {
		    plusX = 0;
		    plusY = 1;
		} else if (plusX == -1) {
		    plusX = 0;
		    plusY = -1;
		}
		else {
		    if (plusY == 1) {
			plusX = -1;
			plusY = 0;
		    } else {
			plusX = 1;
			plusY = 0;
		    }
		}
	    }

	    if (c == 'R') {
		if (plusX == 1) {
		    plusX = 0;
		    plusY = -1;
		}
		else if (plusX == -1) {
		    plusX = 0;
		    plusY = 1;
		}
		else {
		    if (plusY == 1) {
			plusX = 1;
			plusY = 0;
		    }
		    else {
			plusX = -1;
			plusY = 0;
		    }
		}
	    }

	}

	if (x == 0 && y == 0) {
	    return true;
	}

	if (plusX == 0 && plusY == 1) {
	    return false;
	}
	return true;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.isRobotBounded("LGLGGLGLG");
    }
}
