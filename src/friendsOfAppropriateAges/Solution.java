package friendsOfAppropriateAges;

public class Solution {
    // 10ms solution meet avg speed. 50%
    public int numFriendRequests(int[] ages) {
	int[] group = new int[121];
	for (int age : ages) {
	    group[age] += 1;
	}
	
	int result = 0;
	for (int i = 0; i < 121; i++) {
	    for (int j = i; j < 121; j++) {
		if (group[i] > 0 && group[j] > 0) {
		    if (i == j) {
			if (checkAge(i, j)) {
			    result += (group[i] * (group[j] - 1));
			}
		    } else {
			if (checkAge(j, i)) {
			    result += (group[j] * (group[i]));
			}
		    }
		}
	    }
	}
	return result;
    }

    private boolean checkAge(Integer A, Integer B) {
	if ((B > 100 && A < 100) || 2 * B - A <= 14) {
	    return false;
	}
	return true;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] ages = { 20, 30, 100, 110, 120 };
	s.numFriendRequests(ages);
    }

}
