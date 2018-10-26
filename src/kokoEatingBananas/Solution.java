package kokoEatingBananas;

import java.util.Arrays;

public class Solution {
    // 23s solution, beat 50%. Sort and binary search
    public int minEatingSpeed(int[] piles, int H) {
	
	Arrays.sort(piles);
	
	if(H == piles.length) {
	    return piles[piles.length-1];
	}
	
	int total = 0;

	for (int i : piles) {
	    total += i;
	}

	int min = 0;
	if (total % H == 0) {
	    min = total / H;
	} else {
	    min = total / H + 1;
	}
	
	int max = piles[piles.length - 1];

	return findMinSpeed(min, max, piles, H);

    }

    private int findMinSpeed(int min, int max, int[] piles, int H) {
	if (max - min == 1) {
	    if (checkHours(min, piles) <= H) {
		return min;
	    } else {
		return max;
	    }
	} else {
	    int mid = (max + min) / 2;
	    int hour = checkHours(mid, piles);
	    if (hour <= H) {
		return findMinSpeed(min, mid - 1, piles, H);
	    } else {
		return findMinSpeed(mid + 1, max, piles, H);
	    }
	}
    }

    private int checkHours(int min, int[] piles) {
	int startIndex = Arrays.binarySearch(piles, min);
	if (startIndex < 0) {
	    startIndex = -startIndex - 1;
	} else {
	    startIndex = startIndex + 1;
	}
	int total = startIndex;
	for (int i = startIndex; i < piles.length; i++) {
	    if (piles[i] % min == 0) {
		total += piles[i] / min;
	    } else {
		total += (piles[i] / min + 1);
	    }
	}
	return total;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] piles = { 3, 6, 7, 11 };
	s.minEatingSpeed(piles, 6);
    }
}
