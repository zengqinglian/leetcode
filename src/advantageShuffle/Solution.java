package advantageShuffle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    // 126ms solution meet avg speed
    public int[] advantageCount(int[] A, int[] B) {
	Arrays.sort(A);

	LinkedList<Integer> li = new LinkedList<>();
	for (int i : A) {
	    li.add(i);
	}

	PriorityQueue<Integer> pq = new PriorityQueue<>();
	for (int i : B) {
	    pq.add(i);
	}

	LinkedList<Integer> liB = new LinkedList<>();
	while (!pq.isEmpty()) {
	    liB.add(pq.poll());
	}

	Map<Integer, List<Integer>> map = new HashMap<>();
	int cnt = A.length;
	while (cnt > 0) {
	    int b = liB.peekFirst();
	    int a = li.removeFirst();
	    if (a > b) {
		List<Integer> list = map.get(b);
		if (list == null) {
		    list = new ArrayList<>();
		    map.put(b, list);
		}
		list.add(a);
		liB.removeFirst();
	    } else {
		b = liB.removeLast();
		List<Integer> list = map.get(b);
		if (list == null) {
		    list = new ArrayList<>();
		    map.put(b, list);
		}
		list.add(a);
	    }
	    cnt--;
	}

	for (int i = 0; i < B.length; i++) {
	    List<Integer> l = map.get(B[i]);
	    A[i] = l.remove(l.size() - 1);
	}

	return A;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 2, 0, 4, 1, 2 };
	int[] B = { 1, 3, 0, 0, 2 };
	s.advantageCount(A, B);
    }
}
