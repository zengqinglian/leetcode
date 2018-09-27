package scoreofParentheses;

public class Solution1 {

    public int scoreOfParentheses(String S) {
	int ans = 0, bal = 0;
	for (int i = 0; i < S.length(); ++i) {
	    if (S.charAt(i) == '(') {
		bal++;
	    } else {
		bal--;
		if (S.charAt(i - 1) == '(')
		    ans += 1 << bal;
	    }
	}

	return ans;
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	s.scoreOfParentheses("(()(()()))()");
    }

}
