package openTheLock;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    // BFS solution beat 50%
    public int openLock(String[] d, String t) {
	Set<String> set = new HashSet<>(Arrays.asList(d));
	Queue<String> q = new LinkedList<>();

	String cur = "0000", next = null;
	if (!set.contains(cur)) {
	    q.offer(cur);
	    set.add(cur);
	}

	int size = 0, step = 0;
	while (!q.isEmpty()) {
	    size = q.size();
	    for (int i = 0; i < size; i++) {
		cur = q.poll();
		for (int j = 0; j < 4; j++) {
		    char c = cur.charAt(j);
		    int n = c - '0';
		    int[] pool = { (n + 1) % 10, (n - 1 + 10) % 10 };

		    for (int o : pool) {
			next = cur.substring(0, j) + o + cur.substring(j + 1, 4);
			if (next.equals(t))
			    return step + 1;
			if (!set.contains(next)) {
			    q.offer(next);
			    set.add(next);
			}
		    }
		}
	    }
	    step++;
	}
	return -1;
    }
    public static void main(String[] args) {
	String[] deadends = { "0201", "0101", "0102", "1212", "2002" };
	Solution s = new Solution();
	s.openLock(deadends, "0202");
    }
}
