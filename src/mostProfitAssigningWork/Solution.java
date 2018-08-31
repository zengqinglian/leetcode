package mostProfitAssigningWork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 49ms solutiohn , beat 70%
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {

	Map<Integer, Integer> profitMap = new HashMap<>();
	for (int i = 0; i < difficulty.length; i++) {
	    if (profitMap.containsKey(difficulty[i])) {
		profitMap.put(difficulty[i], Math.max(profit[i], profitMap.get(difficulty[i])));
	    }else {
		profitMap.put(difficulty[i], profit[i]);
	    }
	}
	
	Arrays.sort(difficulty);

	int max = 0;
	for (int i : difficulty) {
	    int val = profitMap.get(i);
	    if (val > max) {
		max = val;
	    } else {
		profitMap.put(i, max);
	    }
	}

	int sum = 0;
	for(int w : worker) {
	    if (profitMap.containsKey(w)) {
		sum += profitMap.get(w);
	    } else {
		if (w > difficulty[0]) {
		    int closestKey = binarySearch(difficulty, w, 0, difficulty.length);
		    sum += profitMap.get(closestKey);
		}
	    }

	}
	return sum;
    }

    private int binarySearch(int[] difficulty, int w, int start, int end) {

	if (end - start + 1 == 2) {
	    return difficulty[start];
	}

	int mid = (end - start + 1) / 2 + start;
	if (difficulty[mid] < w) {
	    return binarySearch(difficulty, w, mid, end);
	} else {
	    return binarySearch(difficulty, w, start, mid);
	}

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] difficulty = { 68, 35, 52, 47, 86 };
	int[] profit = { 67, 17, 1, 81, 3 };
	int[] worker = { 92, 10, 85, 84, 82 };
	s.maxProfitAssignment(difficulty, profit, worker);
    }

}
