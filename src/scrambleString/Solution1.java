package scrambleString;

//someone's DP solution
public class Solution1 {
    public boolean isScramble(String s1, String s2) {
	if (s1.length() != s2.length()) {
	    return false;
	}
	char[] c1 = s1.toCharArray();
	char[] c2 = s2.toCharArray();
	int n = s1.length();
	boolean[][][] f = new boolean[n][n][n + 1];
	for (int i = 0; i < n; ++i) {
	    for (int j = 0; j < n; ++j) {
		f[i][j][1] = c1[i] == c2[j];
	    }
        }
	for (int l = 2; l <= n; ++l) {
	    for (int i = 0; i <= n - l; ++i) {
		for (int j = 0; j <= n - l; ++j) {
		    f[i][j][l] = false;
		    for (int k = 1; k < l; ++k) {
			if (f[i][j][k] && f[i + k][j + k][l - k] || f[i][j + l - k][k] && f[i + k][j][l - k]) {
			    f[i][j][l] = true;
			    break;
			}
                    }
                }
            }
        }
	return f[0][0][n];
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	s.isScramble("aacaacccacbcbcbcbb", "bcacabbbaaabcccccc");
    }
}
