package mergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    // sort first solution - 95ms beat 20%
    public List<Interval> merge(List<Interval> intervals) {
	Collections.sort(intervals, (a, b) -> {
	    return Integer.compare(a.start, b.start);
	});

	List<Interval> result = new ArrayList<>();
	
	for (Interval in : intervals) {
	    if (result.isEmpty()) {
		result.add(in);
	    } else {
		Interval last = result.get(result.size() - 1);
		if (in.start > last.end) {
		    result.add(in);
		} else {
		    last.end = Math.max(last.end, in.end);
		}
	    }

	}
	
	return result;

    }

    public static class Interval {
	int start;
	int end;

	Interval() {
	    start = 0;
	    end = 0;
	}

	Interval(int s, int e) {
	    start = s;
	    end = e;
	}
    }
}
