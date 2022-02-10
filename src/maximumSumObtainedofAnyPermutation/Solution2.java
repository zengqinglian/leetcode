package maximumSumObtainedofAnyPermutation;

import java.util.Arrays;
import java.util.PriorityQueue;
/* someone's accept solution.  */
/* learnt how to caculate overlapping from an array*/
public class Solution2 {
  int mod = (int) 1e9+7;
  public int maxSumRangeQuery(int[] nums, int[][] requests) {
    int n = nums.length;
    Arrays.sort(nums);
    int [] dif = new int[n+2];
    for (int [] nxt : requests) {
      dif[nxt[0]]++; dif[nxt[1]+1]--;
    }
    PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
      return b-a;
    });
    if (dif[0]!=0) {
      pq.add(dif[0]);
    }
    for (int i = 1; i<=n; i++) {
      dif[i]+=dif[i-1];
      if (dif[i]!=0) {
        pq.add(dif[i]);
      }
    }
    int ptr = n-1;
    long ans = 0;
    while (!pq.isEmpty()) {
      int v = pq.poll();
      ans = (ans % mod + ((long)v*nums[ptr]) % mod)%mod;
      ptr--;
    }
    return (int) ans;
  }

  public static void main(String[] args) {
    Solution2 s = new Solution2();
    int[] nums = {1,2,3,4,5};
    int[][] requests = {{1,3},{0,1}};
    s.maxSumRangeQuery(nums,requests);
  }
}
