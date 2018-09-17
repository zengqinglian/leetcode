package shiftingLetters;

public class Solution {
    // 10ms solution, meet avg speed. 50%
    public String shiftingLetters(String S, int[] shifts) {
	long total = 0;
	char[] result = new char[shifts.length];

	for (int i = shifts.length - 1; i >= 0; i--) {
	    char c = S.charAt(i);
	    total += shifts[i];
	    long move = (total + (c - 'a')) % 26;
	    result[i] = (char) ((move % 26) + 'a');
	}

	return String.valueOf(result);
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] shifts = { 3, 5, 9 };
	s.shiftingLetters("abc", shifts);
    }

}
