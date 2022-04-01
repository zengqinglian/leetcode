package theTimeWhentheNetworkBecomesIdle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Runtime: 127 ms, faster than 82.39% of Java online submissions for The Time When the Network Becomes Idle.
Memory Usage: 166 MB, less than 59.75% of Java online submissions for The Time When the Network Becomes Idle.
 */
public class Solution {
  public int networkBecomesIdle(int[][] edges, int[] patience) {
    int[] minPath = new int[patience.length];
    List<Integer>[] list = new List[patience.length];
    for(int[] edge : edges) {
      if(list[edge[0]]== null) {
        list[edge[0]] = new ArrayList<>();
      }
      list[edge[0]].add(edge[1]);

      if(list[edge[1]]== null) {
        list[edge[1]] = new ArrayList<>();
      }
      list[edge[1]].add(edge[0]);
    }
    Queue<Integer> q = new LinkedList<>();
    boolean[] visited = new boolean[patience.length];
    int distance = 1;
    q.add(0);
    while(!q.isEmpty()) {
      int len = q.size();
      for(int i=0; i<len; i++) {
        int idx = q.poll();
        for(int newIdx : list[idx]){
          if(!visited[newIdx]) {
            visited[newIdx] = true;
            minPath[newIdx] = distance;
            q.add(newIdx);
          }
        }
      }
      distance++;
    }
    int max = 0;
    for(int i=1; i<minPath.length; i++) {
      int returnMins = minPath[i] * 2;
      if(patience[i] < returnMins) {
        int div = returnMins / patience[i];
        if (returnMins % patience[i] == 0) {
          div--;
        }
        int lastResent = div * patience[i];
        max = Math.max(max, lastResent + returnMins + 1);
      }else{
        max = Math.max(max, returnMins+1);
      }
    }
    return max;
  }
}
