package couplesHoldingHands;

public class Solution1 {
    /*
     * Think about each couple as a vertex in the graph. So if there are N couples,
     * there are N vertices. Now if in position 2i and 2i +1 there are person from
     * couple u and couple v sitting there, that means that the permutations are
     * going to involve u and v. So we add an edge to connect u and v. The min
     * number of swaps = N - number of connected components. This follows directly
     * from the theory of permutations. Any permutation can be decomposed into a
     * composition of cyclic permutations. If the cyclic permutation involve k
     * elements, we need k -1 swaps. You can think about each swap as reducing the
     * size of the cyclic permutation by 1. So in the end, if the graph has k
     * connected components, we need N - k swaps to reduce it back to N disjoint
     * vertices.
     * 
     * Then there are many ways of doing this. We can use dfs for example to compute
     * the number of connected components. The number of edges isn O(N). So this is
     * an O(N) algorithm. We can also use union-find. I think a union-find is
     * usually quite efficient. The following is an implementation.
     */
    private class UF {
	private int[] parents;
	public int count;

	UF(int n) {
	    parents = new int[n];
	    for (int i = 0; i < n; i++) {
		parents[i] = i;
	    }
	    count = n;
	}

	private int find(int i) {
	    if (parents[i] == i) {
		return i;
	    }
	    parents[i] = find(parents[i]);
	    return parents[i];
	}

	public void union(int i, int j) {
	    int a = find(i);
	    int b = find(j);
	    if (a != b) {
		parents[a] = b;
		count--;
	    }
	}
    }

    public int minSwapsCouples(int[] row) {
	int N = row.length / 2;
	UF uf = new UF(N);
	for (int i = 0; i < N; i++) {
	    int a = row[2 * i];
	    int b = row[2 * i + 1];
	    uf.union(a / 2, b / 2);
	}
	return N - uf.count;
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	// int[] row = { 5, 4, 2, 6, 3, 1, 0, 7 };
	int[] row = { 0, 1, 2, 3 };
	s.minSwapsCouples(row);
    }

}
