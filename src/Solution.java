package multiplyStrings;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 40ms solution , beat only 12%
    private static int[][] table = new int[10][10];
    static {
	for (int i = 0; i <= 9; i++) {
	    for (int j = 0; j <= 9; j++) {
		table[i][j] = i * j;
	    }
	}
    }

    public String multiply(String num1, String num2) {
	if (num1.equals("0") || num2.equals("0")) {
	    return "0";
	}

	int l1 = num1.length();
	int l2 = num2.length();
	int[][] tempResult = new int[l1][l2 + 1];

	Map<Integer, int[]> cache = new HashMap<>();

	for (int i = l1 - 1; i >= 0; i--) {
	    char c1 = num1.charAt(i);
	    int key = c1 - '0';
	    if (cache.containsKey(key)) {
		tempResult[i] = cache.get(key);
	    } else {
		if (key == 0) {
		    continue;
		}
		int forward = 0;
		for (int j = l2 - 1; j >= 0; j--) {
		    char c2 = num2.charAt(j);
		    int total = table[key][c2 - '0'];
		    tempResult[i][j + 1] = forward + (total % 10);
		    forward = total / 10;
		}

		if (forward > 0) {
		    tempResult[i][0] = forward;
		}
		cache.put(key, tempResult[i]);
	    }
	}

	StringBuilder sb = new StringBuilder();

	int forward = 0;
	int i = l2;
	boolean hasNum = true;

	while (hasNum) {
	    hasNum = false;
	    int res = 0;
	    for (int j = l1 - 1; j >= 0; j--) {
		int pos = i + (l1 - j - 1);
		if (pos >= 0 && pos <= l2) {
		    res += tempResult[j][pos];
		    hasNum = true;
		}
	    }
	    sb.append((res + forward) % 10);
	    forward = (res + forward) / 10;
	    i--;
	}

	return sb.reverse().toString().replaceFirst("^0+", "");


    }
    public static void main(String[] args) {
	Solution s = new Solution();
	s.multiply("9", "9");
    }
}
