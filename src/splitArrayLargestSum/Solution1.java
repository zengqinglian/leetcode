package splitArrayLargestSum;

public class Solution1 {
    // DP solution - binary search is faster and better.

    /*
     * DP solution. This is obviously not as good as the binary search
     * solutions; but it did pass OJ.
     * 
     * dp[s,j] is the solution for splitting subarray n[j]...n[L-1] into s
     * parts.
     * 
     * dp[s+1,i] = min{ max(dp[s,j], n[i]+...+n[j-1]) }, i+1 <= j <= L-s
     * 
     * This solution does not take advantage of the fact that the numbers are
     * non-negative (except to break the inner loop early). That is a loss. (On
     * the other hand, it can be used for the problem containing arbitrary
     * numbers)
     */

    /*
     * Here is the DP idea: suppose n is the length of array, m is the number of
     * parts you need to cut Firstly we need some utility to calculate sum[i:j]
     * quickly, this is done by a prefix sum array. Once you create prefix[i] =
     * sum[0:i], we can get sum[i:j] = prefix[j]-prefix[i-1] in constant time.
     * Then, let's look at the case m=2. This is the case you want to cut the
     * array into two parts in the most balanced way. So you want to find the
     * number in prefix[] such that it is closest to sum[0:n-1]/2. This can be
     * done by binary search since prefix[] is ordered. In order for DP to work,
     * we not only need the result(min of max of the two parts) for the array
     * itself, we actually need this result for all the subarray nums[0:i]. It
     * takes O(nlogn) to find all the results for the n subarrays. We save it in
     * the array maxSum[]. That is, maxSum[i] is the most balanced way to cut
     * the subarray nums[0:i] into two parts. Now is the interesting part. How
     * do you find maxSum[] for m=3 given that for m=2? This time you need to
     * cut twice, there will be a left cut and a right cut. And it results in
     * three partitions: part1, part2 and part3. Let's think about the right
     * cut. It can be anywhere before nums[2] to nums[n-1]. So let's try all of
     * them. Once you know where the right cut is, you can immediately get the
     * sum of part3 by the prefix[] array. And you can get the most balanced way
     * to cut the part1+part2 from the maxSum[] array of m=2. To generalize,
     * maxSumOfMCut[i] = min_j<i(max(maxSumOfM-1Cut[j], prefix[n-1]-prefix[j])).
     * The final part, observe maxSumOfM-1Cut is also sorted. So we can do
     * binary search: choose any j as your m-th cut position, if
     * maxSumOfM-1Cut[j]<prefix[n-1]-prefix[j], this means the last partition is
     * too big, we need to shrink it. So we can discard all the cut position
     * before j. Similarly for the other way around.
     * 
     * Caveat: the description above is from left to right and use last cut
     * position as a decision variable. This implementation is from right to
     * left and uses the first cut position. That was the way I thought about it
     * when I coded it.
     */
    public int splitArray(int[] nums, int m) {
        int[] s = new int[nums.length];
        s[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            s[i] = nums[i] + s[i - 1];
        }

        for (int k = 2; k <= m; k++) {
            for (int i = nums.length - 1; i >= k - 1; i--) {
                int min = Integer.MAX_VALUE;
                int left = nums[i];
                for (int p = i - 1; p >= k - 2; p--) {
                    min = Math.min(min, Math.max(s[p], left));
                    left += nums[p];
                    if (left >= min) {
                        break;
                    }
                }
                s[i] = min;
            }
        }

        return s[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = { 7, 2, 5, 10, 8 };
        s.splitArray(nums, 3);
    }
}
