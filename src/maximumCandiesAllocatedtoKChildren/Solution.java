package maximumCandiesAllocatedtoKChildren
/*
Runtime: 17 ms, faster than 99.36% of Java online submissions for Maximum Candies Allocated to K Children.
Memory Usage: 57.7 MB, less than 97.97% of Java online submissions for Maximum Candies Allocated to K Children.
 */
 public class Solution{
   public int maximumCandies(int[] candies, long k) {
    long total =0;
    int maxValue = 0;
    for(int c : candies) {
      total+=(long)c;
      maxValue = Math.max(maxValue, c);
    }
    if (total < k) {
      return 0;
    }

    int avg = (int)(total / k);
    int max = avg<maxValue? avg:maxValue;
    int min = 1;

    if(check(candies,max, k)) {
      return max;
    }

    int res = 1;
    while(min < max) {
      int mid = (min+max) / 2;
      if (check(candies, mid, k)) {
        min = mid+1;
        res=mid;
      }else{
        max = mid-1;
      }
    }

    if(check(candies,max, k)) {
      return max;
    }

    return res;
   }
   private boolean check(int[] candies, int max, long k) {
    long cnt = 0;
    for(int v : candies) {
      cnt+= (long)(v / max);
    }
    return cnt>=k;
  }
 }
