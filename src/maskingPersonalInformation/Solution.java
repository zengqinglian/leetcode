package maskingPersonalInformation;

public class Solution {
    // 3ms solution - meet avg speed
    public String maskPII(String S) {
	StringBuilder sb = new StringBuilder();
	int length = S.length();

	int index = length - 1;
	boolean isEmail=false;
	boolean isNumber = false;
	
	while (index >= 0) {
	    if (!isEmail && !isNumber) {
		char c = S.charAt(index);
		if (c >= '0' && c <= '9') {
		    isNumber = true;
		    break;
		}
		if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
		    isEmail = true;
		    break;
		}

		index--;
	    }
	}

	if (isEmail) {
	    int atPos = S.indexOf('@');
	    sb.append(S.substring(0, 1).toLowerCase());
	    sb.append("*****");
	    sb.append(S.substring(atPos - 1).toLowerCase());
	}

	int count = 0;
	if (isNumber) {
	    while (index >= 0) {
		if (count < 4) {
		    char c = S.charAt(index);
		    if (c >= '0' && c <= '9') {
			sb.append(c);
			count++;
		    }
		    index--;
		    continue;
		}

		if (count == 4) {
		    char c = S.charAt(index);
		    if (c >= '0' && c <= '9') {
			sb.append('-');
			sb.append('*');
			index--;
			count++;
		    } else {
			index--;
		    }
		    continue;
		}

		if (count > 4 && count < 10) {
		    char c = S.charAt(index);
		    if (c >= '0' && c <= '9') {
			if (count - 4 > 0 && (count - 4) % 3 == 0) {
			    sb.append('-');
			}
			sb.append('*');
			count++;
			index--;
		    } else {
			index--;
		    }
		    continue;
		}

		if (count == 10) {
		    char c = S.charAt(index);
		    if (c >= '0' && c <= '9') {
			sb.append('-');
			sb.append('*');
			count++;
			index--;
		    } else {
			index--;
		    }
		    continue;
		}

		if (count > 10) {
		    char c = S.charAt(index);
		    if (c >= '0' && c <= '9') {
			sb.append('*');
			count++;
			index--;
		    } else {
			index--;
		    }
		    continue;
		}
	    }

	    if (count > 10) {
		sb.append('+');
	    }

	}

	return isNumber ? sb.reverse().toString() : sb.toString();

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.maskPII("1(234)567-890");
    }
}
