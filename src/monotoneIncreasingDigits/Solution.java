package monotoneIncreasingDigits;

public class Solution {
    // 24ms solution
    public int monotoneIncreasingDigits(int N) {

	String s = String.valueOf(N);
	
	int[] digits = new int[s.length()];

	digits[0] = Integer.valueOf(String.valueOf(s.charAt(0)));
	
	boolean traceBack = true;

	for (int i = 1; i < s.length(); i++) {
	    int cur = Integer.valueOf(String.valueOf(s.charAt(i)));
	    int pre = digits[i - 1];
	    
	    if (pre > cur) {
		digits[i] = 9;
		if (traceBack) {
		    digits[i - 1] = digits[i - 1] - 1;
		    changePrevious(i - 1, digits);
		    traceBack = false;
		}
	    } else {
		digits[i] = cur;
	    }
	}

	int total = 0;
	for (int i : digits) {
	    total = total * 10 + i;
	}

	return total;
    }

    private void changePrevious(int index, int[] digits) {
	while (index > 0) {
	    if (index - 1 >= 0) {
		if (digits[index] < digits[index - 1]) {
		    digits[index] = 9;
		    digits[index - 1] = digits[index - 1] - 1;
		} else {
		    return;
		}
	    }
	    index--;
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.monotoneIncreasingDigits(334225);
    }
}
