package shortestSubarraytobeRemovedtoMakeArraySorted;

public class Solution {
/*
Runtime: 974 ms, faster than 5.14% of Java online submissions for Shortest Subarray to be Removed to Make Array Sorted.
Memory Usage: 59.1 MB, less than 53.08% of Java online submissions for Shortest Subarray to be Removed to Make Array Sorted.
 */
  public int findLengthOfShortestSubarray(int[] arr) {
    if(arr.length == 1) {
      return 0;
    }
    int headIndex = 0;
    int tailIndex = arr.length-1;
    for (int i = 1; i < arr.length; i++) {
      if(arr[i]>=arr[i-1]){
        headIndex = i;
      }else {
        break;
      }
    }
    for (int i = arr.length-2; i >=0; i--) {
      if(arr[i+1]>=arr[i]){
        tailIndex = i;
      }else {
        break;
      }
    }
    int res = arr.length - Math.max(headIndex+1, arr.length - tailIndex);
    if(res == 0) {
      return res;
    }
    for(int i=0; i<=headIndex; i++) {
      for(int j=tailIndex; j<arr.length; j++) {
        if(arr[i] <= arr[j]) {
           res = Math.min(res,j-i -1);
        }
      }
    }

    return res;
  }
  public static void main(String[] args) {
    Solution s = new Solution();
    int[] arr = {1,2,3,1,4};
    s.findLengthOfShortestSubarray(arr);
  }
}
