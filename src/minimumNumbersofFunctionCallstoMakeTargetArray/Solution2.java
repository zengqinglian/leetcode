package minimumNumbersofFunctionCallstoMakeTargetArray;
/*
Runtime: 25 ms, faster than 81.74% of Java online submissions for Minimum Numbers of Function Calls to Make Target Array.
Memory Usage: 56.6 MB, less than 5.22% of Java online submissions for Minimum Numbers of Function Calls to Make Target Array.
 */
public class Solution2 {
  public int minOperations(int[] nums) {
    int res = 0;
    int maxDivNum = 0;
    for(int n: nums) {
      if(n==0) {
        continue;
      }
      if(n==1){
        res++;
        continue;
      }
      int divCnt = 0;
      int mask = 1;
      while(mask<=n) {
        int v = (n & mask);
        if(v>0){
          res++;
        }
        divCnt++;
        mask = (mask<<1);
      }
      maxDivNum = Math.max(maxDivNum, divCnt-1);
    }
    res+=maxDivNum;
    return res;
  }

  public static void main(String[] args) {
    Solution2 s = new Solution2();
    int[] nums = {1,5};
    s.minOperations(nums);
  }
}
