package maximumNumberofNonOverlappingSubarraysWithSumEqualsTarget;

import java.util.ArrayList;
import java.util.List;

/*
66 / 69 test cases passed.
Time limit over solution
 */
public class Solution1 {
  public int maxNonOverlapping(int[] nums, int target) {
    List<int[]> list = new ArrayList<>();
    for(int i=0; i<nums.length; i++) {
      int res = 0;
      for(int j=i; j<nums.length; j++) {
        res+=nums[j];
        if(res==target) {
          int[] node = {i,j,1};
          list.add(node);
          break;
        }
      }
    }
    if(list.isEmpty()) {
      return 0;
    }
    int[][] dp= new int[list.size()][3];
    for(int i=0; i< list.size(); i++) {
      int[] curNode = list.get(i);
      dp[i] = curNode;
      for(int j= i-1; j>=0; j--) {
        int[] preNode = list.get(j);
        if(preNode[2] + 1 > curNode[2] ){
          if(preNode[1] < curNode[0]) {
            dp[i][2] = preNode[2] + 1;
            break;
          }
        }
      }
    }
    return dp[list.size()-1][2];
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    int[] arr = {-1,0,2,2,3,-1,3,0,2,0,3,3,1,3,1,-1,1,3,1,2,2,-1,2,-1,3,2,3,-1,0,-1,-1,-1,-1,0,0,0,2,0,1,-1,0,2,1,3,0,2,3,1};
    s.maxNonOverlapping(arr,4);
  }
}

