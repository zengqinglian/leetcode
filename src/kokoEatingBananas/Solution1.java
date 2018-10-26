package kokoEatingBananas;

import java.util.Arrays;

public class Solution1 {
    // Java binary search improved.
    public int minEatingSpeed(int[] piles, int H) {
	Arrays.sort(piles);
	int lo = 0, hi = piles[piles.length - 1];
	while (lo < hi) {
	    int mid = (lo + hi) / 2, cnt = 0;
	    for (int p : piles)
		cnt += Math.ceil((double) p / mid);
	    if (cnt > H)
		lo = mid + 1;
	    else
		hi = mid;
	}
	return lo;
    }
}
