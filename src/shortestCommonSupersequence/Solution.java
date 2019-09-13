package shortestCommonSupersequence;

public class Solution {
    // 34ms solution , beat 12%
    public String shortestCommonSupersequence(String str1, String str2) {
	if (str1.length() == 0) {
	    return str2;
	}
	if (str2.length() == 0) {
	    return str1;
	}
	String[][] dp = new String[str1.length()][str2.length()];
	for (int i = 0; i < str1.length(); i++) {
	    for (int j = 0; j < str2.length(); j++) {
		if (i == 0) {
		    if (str1.charAt(i) == str2.charAt(j)) {
			dp[i][j] = String.valueOf(str1.charAt(i));
		    } else {
			if (j > 0) {
			    dp[i][j] = dp[i][j - 1];
			}else {
			    dp[i][j] = "";
			}
		    }
		} else {
		    if (str1.charAt(i) == str2.charAt(j)) {
			if(j==0) {
			    dp[i][j] = String.valueOf(str1.charAt(i));
			}else {
			    String pre = dp[i][j-1];
			    String potentialNew = dp[i - 1][j - 1] + String.valueOf(str1.charAt(i));
			    if (potentialNew.length() > pre.length()) {
				dp[i][j] = potentialNew;
			    } else {
				dp[i][j] = pre;
			    }
			}
		    } else {
			if (j > 0) {
			    String pre = dp[i][j - 1];
			    String potentialNew = dp[i - 1][j];
			    if (potentialNew.length() > pre.length()) {
				dp[i][j] = potentialNew;
			    } else {
				dp[i][j] = pre;
			    }
			} else {
			    dp[i][j] = dp[i - 1][j];
			}
		    }
		}
	    }
	}

	String commonStr = dp[str1.length() - 1][str2.length() - 1];
	int start1 = 0;
	int start2 = 0;
	if (!commonStr.isEmpty()) {
	    start1 = str1.indexOf(commonStr.charAt(0));
	    start2 = str2.indexOf(commonStr.charAt(0));
	}else {
	    return str1 + str2;
	}
	
	StringBuffer sb = new StringBuffer();
	sb.append(shortestCommonSupersequence(str1.substring(0, start1), str2.substring(0, start2)));
	sb.append(commonStr.charAt(0));
	
	int index = 1;
	int index1 = start1 + 1;
	int index2 = start2 + 1;
	
	
	while (index < commonStr.length()) {
	    char c = commonStr.charAt(index);
	    if (str1.charAt(index1) == c && str2.charAt(index2) == c) {
		sb.append(c);
		index++;
		index1++;
		index2++;
	    } else if (str1.charAt(index1) == c && str2.charAt(index2) != c) {
		sb.append(str2.charAt(index2));
		index2++;
	    } else if (str1.charAt(index1) != c && str2.charAt(index2) == c) {
		sb.append(str1.charAt(index1));
		index1++;
	    } else {
		sb.append(str1.charAt(index1));
		if (str2.charAt(index2) != str1.charAt(index1))
		    sb.append(str2.charAt(index2));
		index1++;
		index2++;
	    }

	}
	
	// sb.append(commonStr.charAt(commonStr.length() - 1));
	
	sb.append(shortestCommonSupersequence(str1.substring(index1), str2.substring(index2)));
	
	return sb.toString();

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.shortestCommonSupersequence("adbcbccdcadcbcbcbbdccbddcdccababccbccbddbbbcabdbdacdbccccbabacaa",
		"dcbaddabcaadabacbbbddccbbccdbadbdaccdccbbbdbddcbacbdbcdcaddbdadabcbaacbaaaaadbcba");
    }
}
