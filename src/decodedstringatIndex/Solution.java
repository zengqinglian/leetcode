package decodedstringatIndex;

public class Solution {
    // over memory limit , failed on 16 /45
    public String decodeAtIndex(String S, int K) {
	if (K == 1) {
	    return String.valueOf(S.charAt(0));
	}

	long length = 0;
	StringBuilder sb = new StringBuilder();
	for (int i = 0; i < S.length(); i++) {
	    char c = S.charAt(i);
	    if (c >= '2' && c <= '9') {
		length = length * (c - '0');
	    } else {
		length++;
	    }
	    if (length == K) {
		if (c >= '2' && c <= '9') {
		    return sb.substring(sb.length() - 1);
		} else {
		    return String.valueOf(c);
		}
	    } else if (length > K) {
		int remain = (int) (length % K);
		return sb.substring(remain - 1, remain);
	    } else {
		if (c >= '2' && c <= '9') {
		for (int j = 1; j <= (c - '0' - 1); j++) {
		    sb.append(sb.toString());
		}
		} else {
		    sb.append(c);
		}
	    }
	}
	return "";
    }


    public static void main(String[] args) {
	Solution s = new Solution();
	s.decodeAtIndex("vk6u5xhq9v", 554);
    }
}
