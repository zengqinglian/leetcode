package minimumNumbersofFunctionCallstoMakeTargetArray;

/*
Runtime: 81 ms, faster than 22.61% of Java online submissions for Minimum Numbers of Function Calls to Make Target Array.
Memory Usage: 56 MB, less than 5.22% of Java online submissions for Minimum Numbers of Function Calls to Make Target Array.
 */
public class Solution {
  public int minOperations(int[] nums) {
    boolean allZero = false;
    int res = 0;
    while(!allZero) {
      allZero = true;
      boolean hasDiv = false;
      for(int i=0; i<nums.length; i++) {
        if(nums[i] > 1) {
          allZero=false;
          if(nums[i]%2==1) {
            res++;
            nums[i]=(nums[i]-1)/2;
          }else{
            nums[i]/=2;
          }
          hasDiv=true;
        }else if(nums[i] ==1) {
          res++;
          nums[i] = 0;
        }
      }
      if(hasDiv){
        res++;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] arr = {1,2,3,4,5};
    s.minOperations(arr);
  }
}
