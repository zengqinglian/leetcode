package maximumLengthofSubarrayWithPositiveProduct;

import java.util.LinkedList;
/*
Runtime: 5 ms, faster than 53.86% of Java online submissions for Maximum Length of Subarray With Positive Product.
Memory Usage: 61.5 MB, less than 56.77% of Java online submissions for Maximum Length of Subarray With Positive Product.
 */
public class Solution {
  public int getMaxLen(int[] nums) {
    LinkedList<Integer> dq = new LinkedList<>();
    int positiveCnt = 0;
    int previousZeroIdx = -1;
    int maxLen = 0;
    for(int i=0; i<nums.length; i++) {
      if(nums[i] == 0) {
        if(!dq.isEmpty()){
          if(dq.size() %2 ==0) {
            maxLen=Math.max(maxLen, positiveCnt +dq.size());
          }else{
            int first = dq.peekFirst();
            int len = i - (first+1);
            int last = dq.peekLast();
            len = Math.max(len, last - (previousZeroIdx+1));
            maxLen = Math.max(maxLen, len);
          }
        }else{
          maxLen=Math.max(maxLen, positiveCnt);
        }
        dq.clear();
        previousZeroIdx = i;
        positiveCnt = 0;
      }else if (nums[i]<0){
        dq.addLast(i);
      }else{
        positiveCnt++;
      }
    }
    if(!dq.isEmpty()) {
      if(dq.size() %2 ==0) {
        maxLen=Math.max(maxLen, positiveCnt + dq.size());
      }else{
        int first = dq.peekFirst();
        int len = nums.length - (first+1);
        int last = dq.peekLast();
        len = Math.max(len, last - (previousZeroIdx+1));
        maxLen = Math.max(maxLen, len);
      }
    }else{
      maxLen=Math.max(maxLen, positiveCnt);
    }
    return maxLen;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] arr = {-1,2};
    s.getMaxLen(arr);
  }
}
