package beautifulArray;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] beautifulArray(int N) {
	List<Integer> res = new ArrayList<>();
	res.add(1);
	while (res.size() < N) {
	    ArrayList<Integer> tmp = new ArrayList<>();
	    for (int i : res)
		if (i * 2 - 1 <= N)
		    tmp.add(i * 2 - 1);
	    for (int i : res)
		if (i * 2 <= N)
		    tmp.add(i * 2);
	    res = tmp;
	}
	return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.beautifulArray(9);
    }

}
