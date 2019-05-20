package convertToBase2;

public class Solution {
    // 1ms solution , beat 100%
    public String baseNeg2(int N) {
	if (N == 0) {
	    return "0";
	}
	StringBuilder sb = new StringBuilder();
	while (N != 1) {
	    if (N > 0) {
		int mod = N % 2;
		sb.append(mod);
		N = N / -2;
	    } else {
		int mod = N % 2;
		if (mod == 0) {
		    sb.append(0);
		    N = N / (-2);
		} else {
		    sb.append(1);
		    N = (N / (-2) + 1);
		}
	    }
	}

	sb.append(1);
	

	return sb.reverse().toString();
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.baseNeg2(6);
    }
}
