package swapAdjacentinLRString;

public class Solution {
    // very slow solution 350ms beat 0%
    public boolean canTransform(String start, String end) {
	if (start.length() != end.length()) {
	    return false;
	}

	return check(start, end, 0);
    }

    private boolean check(String start, String end, int i) {
	if (i == start.length() - 1) {
	    if (start.charAt(i) == end.charAt(i)) {
		return true;
	    } else {
		return false;
	    }
	} else {
	    if (start.charAt(i) == end.charAt(i)) {
		return check(start, end, i + 1);
	    } else {
		if (end.charAt(i) == 'X') {
		    if (start.charAt(i) == 'L') {
			return false;
		    } else {
			// next available R
			for (int j = i + 1; j < start.length(); j++) {
			    if (start.charAt(j) == 'L') {
				return false;
			    } else if (start.charAt(j) == 'X') {
				String newStart = swap(start, i, j);
				return check(newStart, end, i + 1);
			    }
			}
			return false;

		    }
		} else if (end.charAt(i) == 'L') {
		    if (start.charAt(i) == 'R') {
			return false;
		    } else {
			// next available L
			for (int j = i + 1; j < start.length(); j++) {
			    if (start.charAt(j) == 'R') {
				return false;
			    } else if (start.charAt(j) == 'L') {
				String newStart = swap(start, i, j);
				return check(newStart, end, i + 1);
			    }
			}
			return false;
		    }
		} else {
		    return false;
		}
	    }
	}

    }

    private String swap(String start, int i, int j) {
	char temp = start.charAt(i);
	String newString = start.substring(0, i) + start.charAt(j);
	if(i+1<j) {
	    newString +=  start.substring(i + 1, j);
	}
	newString += temp;
	if (j + 1 < start.length()) {
	    newString += start.substring(j + 1);
	}
	return newString;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.canTransform("XLXRRXXRXX", "LXXXXXXRRR");
    }
}
