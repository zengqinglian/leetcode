package uncrossedLines;

import java.util.LinkedList;
import java.util.TreeSet;

//Overtime limit solution 54/74
public class Solution {
    public int maxUncrossedLines(int[] A, int[] B) {
	TreeSet<Integer>[] indexA = new TreeSet[2001];
	TreeSet<Integer>[] indexB = new TreeSet[2001];

	for (int i = 0; i < A.length; i++) {
	    TreeSet<Integer> set = indexA[A[i]];
	    if (set == null) {
		set = new TreeSet<>();
		indexA[A[i]] = set;
	    }
	    set.add(i);
	}

	for (int i = 0; i < B.length; i++) {
	    TreeSet<Integer> set = indexB[B[i]];
	    if (set == null) {
		set = new TreeSet<>();
		indexB[B[i]] = set;
	    }
	    set.add(i);
	}
	int idxA = 0;
	int max = 0;
	LinkedList<int[]> list = new LinkedList<>();
	while (idxA < A.length) {
	    int val = A[idxA];
	    TreeSet<Integer> possibleB = indexB[val];
	    if(possibleB==null) {
		idxA++;
		continue;
	    }else {
		int initIndexB = possibleB.first();
		int initVal =1;
		int size = list.size();
		int[] p = { idxA, initIndexB, initVal };
		list.add(p);
		for (int i = 0; i < size; i++) {
		    int[] point = list.pollFirst();
		    max = Math.max(max, point[2]);
		    Integer newIdxB = possibleB.higher(point[1]);
		    if (newIdxB != null) {
			int[] newPoint = { idxA, newIdxB, point[2] + 1 };
			list.add(newPoint);
		    }
		    list.add(point);

		}

	    }
	    idxA++;
	}
	while (!list.isEmpty()) {
	    int[] p = list.pollFirst();
	    max = Math.max(max, p[2]);
	}
	return max;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 3, 1, 1, 3, 1, 3 };
	int[] B = { 3, 1, 1, 1, 1 };
	s.maxUncrossedLines(A, B);

    }
}
