package threeSumWithMultiplicity;

import java.util.TreeMap;

public class Solution {
    // Solution beat 30%
    public int threeSumMulti(int[] A, int target) {
	TreeMap<Integer, Integer> map = new TreeMap<>();
	for (int v : A) {
	    Integer num = map.get(v);
	    if (num == null) {
		num = 1;
	    }else {
		num++;
	    }
	    map.put(v, num);
	}

	long number = 0;
	int res = 0;
	for (int k1 : map.keySet()) {
	    int n1 = map.get(k1);
	    if (n1 >= 3 && k1 * 3 == target) {
		number = n1 * (n1 - 1) * (n1 - 2) / 6;
		number %= 1000_000_007;
		res += number;
		res %= 1000_000_007;
	    }
	    for (int k2 : map.tailMap(k1).keySet()) {

		if (k2 > k1) {
		int n2 = map.get(k2);
		if (n2 >= 2 && k1 + 2 * k2 == target) {
			number = n1 * n2 * (n2 - 1) / 2;
		    res += number;
		    res %= 1000_000_007;
		}
		if (n1 >= 2 && k1 * 2 + k2 == target) {
			number = n2 * n1 * (n1 - 1) / 2;
		    res += number;
		    res %= 1000_000_007;
		}
		for (int k3 : map.tailMap(k2).keySet()) {
			if (k3 > k2) {
		    int n3 = map.get(k3);
		    if (k1 + k2 + k3 == target) {
			number = n1 * n2 * n3;
			res += number;
			res %= 1000_000_007;
		    }
		}
		}
		}
	    }
	}
	return res;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 0, 0, 0 };
	s.threeSumMulti(A, 0);
    }
}
