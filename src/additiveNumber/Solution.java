package additiveNumber;

import java.util.Arrays;

public class Solution {
    // 0ms solution , beat 100%
    public boolean isAdditiveNumber(String num) {
	for (int i = 0; i < num.length() - i - 2; i++) {
	    String n1 = num.substring(0, i + 1);
	    for (int j = i + 1; j < num.length(); j++) {
		String n2 = num.substring(i + 1, j + 1);
		if (check(num, j + 1, n1.toCharArray(), n2.toCharArray())) {
		    return true;
		}
	    }
	}
	return false;
    }

    private boolean check(String num, int index, char[] n1, char[] n2) {
	if ((n1[0] == '0' && n1.length > 1) || (n2[0] == '0' && n2.length > 1)) {
	    return false;
	}
	int len = Math.max(n1.length, n2.length) + 1;
	char[] sum = new char[len];
	int promote = 0;
	for (int i = n1.length - 1, j = n2.length - 1, l = len - 1; i >= 0 || j >= 0; i--, j--, l--) {
	    int a = 0;
	    if(i>=0) {
		a = n1[i] - '0';
	    }
	    int b =0;
	    if(j>=0) {
		b= n2[j] - '0';
	    }

	    if (a + b + promote >= 10) {
		sum[l] = (char) ((a + b + promote - 10) + '0');
		promote = 1;
	    } else {
		sum[l] = (char) ((a + b + promote) + '0');
		promote = 0;
	    }
	}
	String sumStr = "";
	if (promote == 1) {
	    sum[0] = (char) 1 + '0';
	    sumStr = String.valueOf(sum);
	} else {
	    sumStr = String.valueOf(Arrays.copyOfRange(sum, 1, len));
	}

	if (sumStr.length() > num.length() - index) {
	    return false;
	}
	for (int i = 0; i < sumStr.length(); i++) {
	    char sumChr = sumStr.charAt(i);
	    char numChr = num.charAt(index);
	    if (sumChr != numChr) {
		return false;
	    } else {
		index++;
	    }
	}
	if (index < num.length()) {
	    return check(num, index, n2, sumStr.toCharArray());
	} else {
	    return true;
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.isAdditiveNumber("199100199");
    }
}
