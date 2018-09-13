package pushDominoes;

public class Solution1 {
    // use array instead of bufferbuilder, improve to 15ms , meet avg speed.
    public String pushDominoes(String dominoes) {
	char[] ret = new char[dominoes.length()];
	int dealed = -1;
	int L = -1;
	for (int m = 0; m < dominoes.length(); m++) {
	    char c = dominoes.charAt(m);
	    if (c == 'L') {
		if (L < 0) {
		    for (int n = dealed + 1; n <= m; n++) {
			ret[n] = 'L';
		    }
		    L = -1;
		    dealed = m;
		} else {
		    int len = 0;
		    if (m - L == 1) {
			ret[dealed + 1] = 'R';
			ret[m] = 'L';
			L = -1;
			dealed = m;
		    } else {
			while (L + len < m - len) {
			    ret[L + len] = 'R';
			    ret[m - len] = 'L';
			    len++;
			}
			if (L + len == m - len) {
			    ret[L + len] = '.';

			}
			L = -1;
			dealed = m;
		    }
		}
	    } else if (c == 'R') {
		if (L < 0) {
		    L = m;
		    if (dealed + 1 < m) {
			while (dealed + 1 < m) {
			    ret[dealed + 1] = dominoes.charAt(dealed + 1);
			    dealed++;
			}
		    }
		    dealed = m - 1;
		} else {
		    L = m;
		    if (dealed + 1 < m) {
			while (dealed + 1 < m) {
			    ret[dealed + 1] = 'R';
			    dealed++;
			}
		    }
		    dealed = m - 1;
		}
	    } else {
		continue;
	    }
	}
	if (L < 0) {
	    for (int i = dealed + 1; i < dominoes.length(); i++) {
		ret[i] = dominoes.charAt(dealed + 1);
	    }
	} else {
	    for (int i = dealed + 1; i < dominoes.length(); i++) {
		ret[i] = 'R';
	    }
	}
	return new String(ret);
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	s.pushDominoes(".L.R...LR..L..");
    }

}
