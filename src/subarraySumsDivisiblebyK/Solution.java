package subarraySumsDivisiblebyK;

public class Solution {
    // over time limit solution failed on 68/73
    public int subarraysDivByK(int[] A, int K) {
	int cnt = 0;
	int[] res = new int[1];
	res[0] = A[0];
	if (A[0] % K == 0) {
	    cnt++;
	}
	for (int i = 1; i < A.length; i++) {
	    int[] newres = new int[res.length + 1];
	    int index = 0;
	    for (int val : res) {
		int newVal = val + A[i];
		if (newVal % K == 0) {
		    cnt++;
		}
		newres[index] = newVal;
		index++;
	    }
	    if (A[i] % K == 0) {
		cnt++;
	    }
	    newres[index] = A[i];
	    res = newres;
	}
	return cnt;
    }
}
