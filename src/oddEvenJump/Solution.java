package oddEvenJump;

import java.util.TreeMap;

public class Solution {
    // 70ms solution , beat 90%
    public int oddEvenJumps(int[] A) {
	int[] odds = new int[A.length];
	int[] even = new int[A.length];

	odds[A.length - 1] = A.length - 1;
	even[A.length - 1] = A.length - 1;

	TreeMap<Integer, Integer> map = new TreeMap<>();
	
	map.put(A[A.length - 1], A.length - 1);

	for (int i = A.length - 2; i >= 0; i--) {
	    Integer valOdd = map.ceilingKey(A[i]);
	    Integer valEven = map.floorKey(A[i]);
	    
	    int idxOdds = (valOdd == null ? -1 : map.get(valOdd));
	    int idxEven = (valEven == null ? -1 : map.get(valEven));
	    
	    map.put(A[i], i);
	    
	    odds[i] = idxOdds;
	    even[i] = idxEven;
	}

	int sum = 1;
	boolean[] oddsCheck = new boolean[A.length];
	boolean[] evenCheck = new boolean[A.length];

	oddsCheck[A.length - 1] = true;
	evenCheck[A.length - 1] = true;

	for (int i = A.length - 2; i >= 0; i--) {

	    if (odds[i] != -1 && evenCheck[odds[i]]) {
		sum++;
		oddsCheck[i] = true;
	    } else if (odds[i] == A.length - 1) {
		sum++;
		oddsCheck[i] = true;
	    }

	    if (even[i] != -1 && oddsCheck[even[i]]) {
		evenCheck[i] = true;
	    }
	    else if (even[i] == A.length - 1) {
		evenCheck[i] = true;
	    }

	}
	return sum;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 2, 3, 1, 1, 4 };
	s.oddEvenJumps(A);
    }
}
