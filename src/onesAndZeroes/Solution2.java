package onesAndZeroes;

public class Solution2 {
    // 23 ms solution ,beat 50%
    public int findMaxForm(String[] strs, int m, int n) {
	int[][] counting = new int[m + 1][n + 1];
	int max = 0;
	for(String str : strs) {
	    int cntZero=0,cntOne=0;
	    boolean good = true;
	    for (char c : str.toCharArray()) {
		if (c == '0') {
		    cntZero++;
		} else {
		    cntOne++;
		}
		if (cntZero > m || cntOne > n) {
		    good = false;
		    break;
		}
	    }
	    
	    if(good) {
		// List<int[]> added = new LinkedList<>();
		for (int i = m; i >= 0; i--) {
		    for (int j = n; j >= 0; j--) {
			int val = counting[i][j];
			if (val == 0) {
			    continue;
			}
			int newI = i + cntZero;
			int newJ = j + cntOne;
			if (newI <= m && newJ <= n) {
			    int[] p = { newI, newJ, val + 1 };
			    // added.add(p);
			    counting[newI][newJ] = Math.max(val + 1, counting[newI][newJ]);
			    max = Math.max(max, counting[newI][newJ]);
			} else {
			    max = Math.max(max, val);
			}
		    }
		}
		// for (int[] p : added) {
		// counting[p[0]][p[1]] = Math.max(p[2], counting[p[0]][p[1]]);
		// max = Math.max(max, counting[p[0]][p[1]]);
		// }
		counting[cntZero][cntOne] = Math.max(1, counting[cntZero][cntOne]);
		max = Math.max(max, counting[cntZero][cntOne]);
	    }
	}
	return max;
    }

    public static void main(String[] args) {
	Solution2 s = new Solution2();
	String[] strs = { "10", "0", "1" };
	s.findMaxForm(strs, 1, 1);
    }
}
