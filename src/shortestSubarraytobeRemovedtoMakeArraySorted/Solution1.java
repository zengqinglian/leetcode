package shortestSubarraytobeRemovedtoMakeArraySorted;
/*
Runtime: 2 ms, faster than 65.07% of Java online submissions for Shortest Subarray to be Removed to Make Array Sorted.
Memory Usage: 73.4 MB, less than 47.94% of Java online submissions for Shortest Subarray to be Removed to Make Array Sorted.
 */
public class Solution1 {
  public int findLengthOfShortestSubarray(int[] arr) {
    if (arr.length == 1) {
      return 0;
    }
    int headIndex = 0;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] >= arr[i - 1]) {
        headIndex = i;
      } else {
        break;
      }
    }

    int res = arr.length - headIndex - 1;
    if(res == 0) {
      return res;
    }
    int tailIdx = arr.length-2;
    if(arr[arr.length-1]>=arr[headIndex]){
      res--;
    }
    int cnt = res;
    while(arr[tailIdx+1]>=arr[tailIdx]){
      int headValue = headIndex<0? Integer.MIN_VALUE : arr[headIndex];
      if(arr[tailIdx]>=headValue) {
        cnt = tailIdx - headIndex -1;
        tailIdx--;
      }else{
        headIndex--;
      }
      res = Math.min(res, cnt);
    }
    return res;
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    int[] arr = {16,10,0,3,22,1,14,7,1,12,15};
    s.findLengthOfShortestSubarray(arr);
  }
}
