package rLEIterator;

import java.util.LinkedList;

public class RLEIterator {
    // 65ms solution, meet avg spee
    private LinkedList<Range> list = new LinkedList<>();
    private long index = -1L;

    public RLEIterator(int[] A) {
	long idx = 0;
	for (int i = 0; i < A.length; i = i + 2) {
	    idx = idx + A[i];
	    int val = A[i + 1];
	    long end = idx - 1;
	    Range r = new Range(end, val);
	    list.add(r);
	}
    }

    public int next(int n) {
	if (list.isEmpty()) {
	    return -1;
	}

	long curIndex = index + n;
	Range last = list.peekLast();
	if (last.endPoint < curIndex) {
	    index = curIndex;
	    return -1;
	}

	Range top = list.peekFirst();
	if (top.endPoint < curIndex) {
	    list.removeFirst();
	    return next(n);
	}

	if (top.endPoint == curIndex) {
	    list.removeFirst();
	}

	index = curIndex;

	return top.val;

    }

    private static class Range {
	private final long endPoint;
	private final int val;

	public Range(long endPoint, int val) {
	    this.endPoint = endPoint;
	    this.val = val;

	}

    }
}

/**
 * Your RLEIterator object will be instantiated and called as such: RLEIterator
 * obj = new RLEIterator(A); int param_1 = obj.next(n);
 */
