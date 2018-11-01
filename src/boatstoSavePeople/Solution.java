package boatstoSavePeople;

import java.util.TreeMap;

public class Solution {
    // slow map solution - beat 4% 210 ms
    public int numRescueBoats(int[] people, int limit) {

	TreeMap<Integer, Integer> map = new TreeMap<>();
	int count = 0;
	for (int i : people) {
	    if(i==limit) {
		count++;
		continue;
	    }
	    if (map.containsKey(limit - i)) {
		int cnt = map.get(limit - i);
		if (cnt == 1) {
		    map.remove(limit - i);
		} else {
		    map.put(limit - i, cnt - 1);
		}
		count++;
	    } else {
		if(map.containsKey(i)) {
		    map.put(i, map.get(i) + 1);
		} else {
		    map.put(i, 1);
		}
	    }
	}

	while (!map.isEmpty()) {
	    int head = map.firstKey();
	    int tail = map.lastKey();
	    if (head == tail) {
		int cnt = map.get(head);
		if (head * 2 > limit) {
		    return count + cnt;
		} else {
		    int num = cnt / 2;
		    int mod = cnt % 2;
		    return count + num + mod;
		}
	    } else {
		if (tail + head > limit) {
		    count += map.get(tail);
		    map.remove(tail);
		} else {
		    int headcnt = map.get(head);
		    int tailcnt = map.get(tail);
		    if (tailcnt == headcnt) {
			count += tailcnt;
			map.remove(tail);
			map.remove(head);
		    } else if (tailcnt > headcnt) {
			map.remove(head);
			map.put(tail, tailcnt - headcnt);
			count += headcnt;
		    } else {
			map.remove(tail);
			map.put(head, headcnt - tailcnt);
			count += tailcnt;
		    }
		}
	    }
	}

	return count;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] people = { 3, 2, 3, 2, 2 };
	s.numRescueBoats(people, 6);
    }

}
