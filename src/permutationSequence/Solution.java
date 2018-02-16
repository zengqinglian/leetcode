package permutationSequence;

import java.util.LinkedList;

public class Solution {
    // 17ms solution, -- meet avg speed.
    public String getPermutation(int n, int k) {
	LinkedList<Integer> list = new LinkedList<>();
	for (int i = 1; i <= n; i++) {
	    list.add(i);
	}
	StringBuilder sb = new StringBuilder();

	getNumber(list, k, sb);

	return sb.toString();
    }

    private void getNumber(LinkedList<Integer> list, int k, StringBuilder sb) {
	int size = list.size();
	if (size == 1) {
	    sb.append(list.removeFirst());
	    return;
	}
	int max = getFactorial(size - 1);
	
	int div = k / max;
	int remain = k % max;

	if (remain == 0) {
	    sb.append(list.remove(div - 1));
	} else {
	    sb.append(list.remove(div));
	}

	if (remain == 0) {
	    while (list.size() > 0) {
		sb.append(list.removeLast());
	    }
	    return;
	} else {
	    getNumber(list, remain, sb);
	}

    }

    private int getFactorial(int n) {
	if (n == 0) {
	    return 0;
	}

	if (n == 1) {
	    return 1;
	}

	return n * getFactorial(n - 1);

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.getPermutation(4, 10);

    }

}
