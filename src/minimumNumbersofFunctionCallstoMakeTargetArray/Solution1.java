package minimumNumbersofFunctionCallstoMakeTargetArray;

public class Solution1 {
  public int minOperations(int[] nums) {
    int res = 0;
    int maxDivNum = 0;
    for(int n: nums) {
      if(n==0) {
        continue;
      }
      int divCnt = 0;

      while(n>1) {
        if(n%2==1){
          res++;
        }
        divCnt++;
        n=n/2;
      }
      res++;
      maxDivNum = Math.max(maxDivNum, divCnt);
    }
    res+=maxDivNum;
    return res;
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    int[] nums = {1,50};
    s.minOperations(nums);
  }
}
