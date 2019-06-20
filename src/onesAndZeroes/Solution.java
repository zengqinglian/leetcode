package onesAndZeroes;

import java.util.ArrayList;
import java.util.List;

//over time limit solution, failed on test case 59/63
public class Solution {
    int max = 0;
    public int findMaxForm(String[] strs, int m, int n) {
	List<int[]> count = new ArrayList<>();
	int cnt = 0;
	for (String str : strs) {
	    if (str.length() == 1) {
		if (str.equals("0")) {
		    if (m > 0) {
			m--;
			cnt++;
		    }
		    continue;
		} else {
		    if (n > 0) {
			n--;
			cnt++;
		    }
		    continue;
		}
	    }
	    int zeros = 0, ones = 0;
	    boolean good = true;
	    for (char c : str.toCharArray()) {
		if (c == '0') {
		    zeros++;
		} else {
		    ones++;
		}
		if (zeros > m || ones > n) {
		    good = false;
		    break;
		}
	    }
	    if (good) {
	    int[] p = {zeros, ones};

	    count.add(p);
	    }
	}	
	getMax(count, 0, m, n, cnt);

	return max;
    }
    
    private void getMax (List<int[]> count, int index, int m, int n, int cnt) {
	int gap = max - cnt > 0 ? max - cnt : 0;
	if (index == count.size() - gap) {
	    max = Math.max(max, cnt);
	    return;
	}
	for (int i = index; i < count.size() - gap; i++) {
	    int[] value = count.get(i);
	    if (m - value[0] < 0 || n - value[1] < 0) {
		max = Math.max(max, cnt);
	    } else {
		getMax(count, i + 1, m - value[0], n - value[1], cnt + 1);
	    }
	}
    }

    public static void main(String[] args) {
	Solution s= new Solution();
	String[] strs = { "10", "0001", "111001", "1", "0", "1100", "01" };
	s.findMaxForm(strs, 6, 4);
    }
}
