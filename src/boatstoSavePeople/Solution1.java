package boatstoSavePeople;

import java.util.Arrays;

public class Solution1 {
    // sort first solution, 28ms. meet avg speed.
    public int numRescueBoats(int[] people, int limit) {
	Arrays.sort(people);
	int count = 0;
	int s = 0;
	int e = people.length - 1;
	while (s < e) {
	    int head = people[s];
	    int tail = people[e];
	    if (tail == limit) {
		count++;
		e--;
	    } else if (tail + head > limit) {
		count++;
		e--;
	    } else {
		s++;
		e--;
		count++;
	    }
	}
	if (s == e) {
	    count++;
	}
	return count;
    }
}
