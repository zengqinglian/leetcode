package pushDominoes;

public class Solution {
    // 30ms solution beat 20%
    public String pushDominoes(String dominoes) {
	StringBuilder sb = new StringBuilder();
	int dealed = -1;
	int L = -1;
	for (int m = 0; m < dominoes.length(); m++) {
	    char c = dominoes.charAt(m);
	    if (c == 'L') {
		if (L < 0) {
		    for (int n = dealed + 1; n <= m; n++) {
			sb.append('L');
		    }
		    L = -1;
		    dealed = m;
		} else {
		    int len = 0;
		    if(m-L ==1) {
			sb.append('R');
			sb.append('L');
			L=-1;
			dealed=m;
		    }else {
			StringBuilder sbR = new StringBuilder();
			while (L + len < m - len) {
			    sb.append("R");
			    sbR.append("L");
			    len++;
			}
			if (L + len == m - len) {
			    sb.append('.');

			}
			sb.append(sbR.toString());
			L = -1;
			dealed = m;
		    }
		}
	    } else if (c == 'R') {
		if (L < 0) {
		    L = m;
		    if (dealed + 1 < m) {
			while (dealed + 1 < m) {
			    sb.append(dominoes.charAt(dealed + 1));
			    dealed++;
			}
		    }
		    dealed = m - 1;
		} else {
		    L = m;
		    if (dealed + 1 < m) {
			while (dealed + 1 < m) {
			    sb.append('R');
			    dealed++;
			}
		    }
		    dealed = m - 1;
		}
	    }else {
		continue;
	    }
	}
	if (L < 0) {
	for (int i = dealed + 1; i < dominoes.length(); i++) {
	    sb.append(dominoes.charAt(i));
	}
	} else {
	    for (int i = dealed + 1; i < dominoes.length(); i++) {
		sb.append('R');
	    }
	}
	return sb.toString();
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.pushDominoes(".L.R...LR..L..");
    }
}
