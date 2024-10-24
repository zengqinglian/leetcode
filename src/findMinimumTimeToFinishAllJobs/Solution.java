package findMinimumTimeToFinishAllJobs;

import java.util.Arrays;
/*
132ms
Beats
40.21%
Analyze Complexity
Memory
44.70 MB
Beats
12.81%
 */
public class Solution {
    int res = Integer.MAX_VALUE;
    public int minimumTimeRequired(int[] jobs, int k) {
        int[] jobBuckets = new int[k];
        helper (jobs, 0, jobBuckets);
        return res;
    }

    private void helper(int[] jobs, int i, int[] jobBuckets) {
        if (i == jobs.length-1) {
            for (int j = 0; j< jobBuckets.length; j++) {
                jobBuckets[j] += jobs[i];
                if (jobBuckets[j]>= res) {
                    jobBuckets[j] -= jobs[i];
                    continue;
                }
                res = Math.min(res, findMax(jobBuckets));
                jobBuckets[j] -= jobs[i];
                if (jobBuckets[j]== 0) {
                    break;
                }
            }
        }else{
            for (int j = 0; j< jobBuckets.length; j++) {
                jobBuckets[j] += jobs[i];
                if (jobBuckets[j]>= res) {
                    jobBuckets[j] -= jobs[i];
                    continue;
                }
                helper(jobs, i+1, jobBuckets);
                jobBuckets[j] -= jobs[i];
                if (jobBuckets[j] == 0) {
                    break;
                }
            }
        }
    }

    private int findMax(int[] jobBuckets) {
        return Arrays.stream(jobBuckets).max().orElse(Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minimumTimeRequired(new int[]{20010,20006,20014,20004,20008,20006,20005,20012,19999,20014,20003,20012}, 8);
    }
}
