package bitwiseORsofSubarrays;

import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    public int subarrayBitwiseORs(int[] A) {
	Set<Integer> ans = new HashSet<>();
	Set<Integer> cur = new HashSet<>();
	cur.add(0);
	for (int x : A) {
	    Set<Integer> cur2 = new HashSet<>();
	    for (int y : cur)
		cur2.add(x | y);
	    cur2.add(x);
	    cur = cur2;
	    ans.addAll(cur);
	}

	return ans.size();
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	int[] A = { 1, 2, 4 };
	s.subarrayBitwiseORs(A);
    }
}
