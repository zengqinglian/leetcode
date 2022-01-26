package maximumNumberofNonOverlappingSubarraysWithSumEqualsTarget;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

34 / 69 test cases passed.
TimeLimit Over Solution
 */
public class Solution {
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
    Queue<int[]> q = new LinkedList<>();
    for(int[] node : list) {
      if(q.isEmpty()){
        q.add(node);
      }else{
        int size = q.size();
        for(int i=0;i<size; i++) {
          int[] curNode = q.poll();
          if(curNode[1] < node[0]) {
            curNode[0] = node[0];
            curNode[1] = node[1];
            curNode[2]++;
            q.add(curNode);
          }else if (curNode[0]<node[0] && curNode[1]>=node[1]) {
            curNode[0] = node[0];
            curNode[1] = node[1];
            q.add(curNode);
          }else{
            q.add(curNode);
            q.add(node);
          }
        }
      }
    }

    int res = 0;
    while(!q.isEmpty()) {
      res= Math.max(res, q.poll()[2]);
    }
    return res;


  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] arr = {-1,0,2,2,3,-1,3,0,2,0,3,3,1,3,1,-1,1,3,1,2,2,-1,2,-1,3,2,3,-1,0,-1,-1,-1,-1,0,0,0,2,0,1,-1,0,2,1,3,0,2,3,1};
    s.maxNonOverlapping(arr,4);
  }
}

