package mirrorReflection;

public class Solution {
    // 4ms solution , beat 50%
    public int mirrorReflection(int p, int q) {
	int point = getResult(p, q, 0, 0, 0);
	return point;
    }

    // v vertical direction , 0, up, 1 down
    // h horizontal direction, 0 left to right, 1, right to left
    private int getResult(int p, double q, double start, int v, int h) {
	double mod = (p - start) % q;
	if (Math.abs(mod - q) < 0.0001 || mod < 0.0001) {
	    double div = (p - start) / q;

	    int result = (int) Math.floor(div);

	    if (Math.abs(mod - q) < 0.0001) {
		result++;
	    }

	    if (v == 0) {
		if (h == 0) {
		    if (result % 2 == 0) {
			return 2;
		    } else {
			return 1;
		    }
		} else {
		    if (result % 2 == 0) {
			return 1;
		    } else {
			return 2;
		    }
		}
	    } else {
		if (h == 0) {
		    if (result % 2 == 1) {
			return 0;
		    } else {
			return getResult(p, q, 0, 1, 0);
		    }
		} else {
		    if (result % 2 == 0) {
			return 0;
		    } else {
			return getResult(p, q, 0, 1, 0);
		    }
		}
	    }
	} else {
	    double div = (p - start) / q;
	    int result = (int) Math.floor(div);
	    double top = (mod / q) * p;
	    double newStart = ((p - top) / top) * mod;

	    if (v == 0 && h == 0) {
		if (result % 2 == 1) {
		    return getResult(p, q, newStart, 1, 0);
		} else {
		    return getResult(p, q, newStart, 1, 1);
		}

	    } else if (v == 0 && h == 1) {
		if (result % 2 == 1) {
		    return getResult(p, q, newStart, 1, 1);
		} else {
		    return getResult(p, q, newStart, 1, 0);
		}

	    } else if (v == 1 && h == 0) {
		if (result % 2 == 1) {
		    return getResult(p, q, newStart, 0, 0);
		} else {
		    return getResult(p, q, newStart, 0, 1);
		}

	    } else {
		if (result % 2 == 1) {
		    return getResult(p, q, newStart, 0, 1);
		} else {
		    return getResult(p, q, newStart, 0, 0);
		}

	    }
	}

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.mirrorReflection(5, 3);
    }
}
