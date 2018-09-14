package splitArrayintoFibonacciSequence;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    // 7ms solution ,beat 60%
    public List<Integer> splitIntoFibonacci(String S) {
	List<Integer> result = new ArrayList<>();
	int end = S.charAt(0) == '0' ? 0 : (S.length() - 1) / 2;
	end = Math.min(end, 10);
	for (int i = 0; i <= end; i++) {
	    String first = S.substring(0, i + 1);
	    for (int j = i + 1; j < S.length(); j++) {
		String second = S.substring(i + 1, j + 1);
		int s = j + 1;
		int one;
		int two;
		try {
		    one = Integer.valueOf(first);
		    two = Integer.valueOf(second);
		} catch (Exception e) {
		    break;
		}
		if (getResult(S, first, second, one, two, s, result)) {
		    result.add(two);
		    result.add(one);
		    Collections.reverse(result);
		    return result;
		}
	    }
	}
	return result;
    }

    private boolean getResult(String S, String first, String second, int one, int two, int s, List<Integer> result) {

	String sum = String.valueOf(one + two);
	int third = Integer.valueOf(sum);
	int len = sum.length();
	if (len > S.length() - s + 1) {
	    return false;
	} else if (len == S.length() - s) {
	    if (S.substring(s).equals(sum)) {
		result.add(third);
		return true;
	    } else {
		return false;
	    }
	} else {
	    int newS = s + len;

	    if (len > S.length() - newS) {
		return false;
	    } else {
		if (S.substring(s, newS).equals(sum)) {
		    if (getResult(S, second, sum, two, third, newS, result)) {
			result.add(third);
			return true;
		    } else {
			return false;
		    }
		} else {
		    return false;
		}

	    }
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.splitIntoFibonacci("214748364721474836422147483641");
    }
}
