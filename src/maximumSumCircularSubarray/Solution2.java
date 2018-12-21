package maximumSumCircularSubarray;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution2 {
    /*
     * Approach 2: Prefix Sums + Monoqueue Intuition
     * 
     * First, we can frame the problem as a problem on a fixed array.
     * 
     * We can consider any subarray of the circular array with buffer A, to be a
     * subarray of the fixed array A+A.
     * 
     * For example, if A = [0,1,2,3,4,5] represents a circular array, then the
     * subarray [4,5,0,1] is also a subarray of fixed array
     * [0,1,2,3,4,5,0,1,2,3,4,5]. Let B = A+A be this fixed array.
     * 
     * Now say N = A\text{.length}N=A.length, and consider the prefix sums
     * 
     * P_k = B[0] + B[1] + \cdots + B[k-1] P k ​ =B[0]+B[1]+⋯+B[k−1]
     * 
     * Then, we want the largest P_j - P_iP j ​ −P i ​ where j - i \leq Nj−i≤N.
     * 
     * Now, consider the j-th candidate answer: the best possible P_j - P_iP j ​ −P
     * i ​ for a fixed jj. We want the ii so that P_iP i ​ is smallest, with j - N
     * \leq i < jj−N≤i<j. Let's call this the optimal i for the j-th candidate
     * answer. We can use a monoqueue to manage this.
     * 
     * Algorithm
     * 
     * Iterate forwards through jj, computing the jj-th candidate answer at each
     * step. We'll maintain a queue of potentially optimal ii's.
     * 
     * The main idea is that if i_1 < i_2i 1 ​ <i 2 ​ and P_{i_1} \geq P_{i_2}P i 1
     * ​
     * 
     * ​ ≥P i 2 ​
     * 
     * ​ , then we don't need to remember i_1i 1 ​ anymore.
     * 
     * Please see the inline comments for more algorithmic details about managing
     * the queue.
     */
    public int maxSubarraySumCircular(int[] A) {
	int N = A.length;

	// Compute P[j] = B[0] + B[1] + ... + B[j-1]
	// for fixed array B = A+A
	int[] P = new int[2 * N + 1];
	for (int i = 0; i < 2 * N; ++i)
	    P[i + 1] = P[i] + A[i % N];

	// Want largest P[j] - P[i] with 1 <= j-i <= N
	// For each j, want smallest P[i] with i >= j-N
	int ans = A[0];
	// deque: i's, increasing by P[i]
	Deque<Integer> deque = new ArrayDeque<>();
	deque.offer(0);

	for (int j = 1; j <= 2 * N; ++j) {
	    // If the smallest i is too small, remove it.
	    if (deque.peekFirst() < j - N)
		deque.pollFirst();

	    // The optimal i is deque[0], for cand. answer P[j] - P[i].
	    ans = Math.max(ans, P[j] - P[deque.peekFirst()]);

	    // Remove any i1's with P[i2] <= P[i1].
	    while (!deque.isEmpty() && P[j] <= P[deque.peekLast()])
		deque.pollLast();

	    deque.offerLast(j);
	}

	return ans;
    }

    public static void main(String[] args) {
	Solution2 s = new Solution2();
	int[] A = { 8, 1, 1, 7 };
	s.maxSubarraySumCircular(A);

    }
}
