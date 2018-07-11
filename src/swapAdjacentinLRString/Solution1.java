package swapAdjacentinLRString;

public class Solution1 {
    // 7ms solution beat 90%
    public boolean canTransform(String start, String end) {
	if (start.length() != end.length()) {
	    return false;
	}

	int i = 0;
	char[] startArr = start.toCharArray();
	char[] endArr = end.toCharArray();
	while (i < start.length()) {
	    if (endArr[i] != startArr[i]) {
		if (endArr[i] == 'X') {
		    if (startArr[i] == 'L') {
			return false;
		    } else {
			// next available R
			boolean found = false;
			for (int j = i + 1; j < start.length(); j++) {
			    if (startArr[j] == 'L') {
				return false;
			    } else if (startArr[j] == 'X') {
				swap(startArr, i, j);
				found = true;
				break;
			    }
			}
			if (!found) {
			    return false;
			}
		    }

		} else if (endArr[i] == 'L') {
		    if (startArr[i] == 'R') {
			return false;
		    } else {
			// next available L
			boolean found = false;
			for (int j = i + 1; j < start.length(); j++) {
			    if (startArr[j] == 'R') {
				return false;
			    } else if (startArr[j] == 'L') {
				swap(startArr, i, j);
				found = true;
				break;
			    }
			}
			if (!found) {
			    return false;
			}
		    }
		} else {
		    return false;
		}
	    }
	    i++;
	}

	return true;
    }

    private void swap(char[] startArr, int i, int j) {
	char temp = startArr[i];
	startArr[i] = startArr[j];
	startArr[j] = temp;
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	s.canTransform("XLXRRXXRXX", "LXXXXXXRRR");
    }
}
