package bitwiseORsofSubarrays;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // over time limit solution failed on 80/83
    public int subarrayBitwiseORs(int[] A) {
	Set<Integer> set = new HashSet<>();
	int result = 0;
	for (int i = 0; i < A.length; i++) {
	    if (set.add(A[i])) {
		result++;
	    }
	    int temp = A[i];
	    for (int j = i + 1; j < A.length; j++) {
		int newTemp = temp | A[j];
		if (newTemp != temp) {
		    temp = newTemp;
		    if (set.add(temp)) {
			result++;
		    }
		}
	    }
	}
	return result;
    }

}
