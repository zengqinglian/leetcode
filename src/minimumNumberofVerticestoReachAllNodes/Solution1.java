package minimumNumberofVerticestoReachAllNodes;

import java.util.ArrayList;
import java.util.List;
/*
Runtime: 17 ms, faster than 42.09% of Java online submissions for Minimum Number of Vertices to Reach All Nodes.
Memory Usage: 89.7 MB, less than 52.61% of Java online submissions for Minimum Number of Vertices to Reach All Nodes.
 */
public class Solution1 {
  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    boolean[] resultSet = new boolean[n];
    boolean[] visited = new boolean[n];
    for(List<Integer> edge : edges) {
      if(!visited[edge.get(0)]) {
        resultSet[edge.get(0)]=true;
        if(visited[edge.get(1)]) {
          if(resultSet[edge.get(1)]){
            resultSet[edge.get(1)] = false;
          }
        }
        visited[edge.get(0)]=true;
        visited[edge.get(1)]=true;
      }else{
        if(visited[edge.get(1)] && resultSet[edge.get(1)]) {
          resultSet[edge.get(1)]=false;
        }
        visited[edge.get(1)]=true;
      }
    }
    List<Integer> res = new ArrayList<>();
    for(int i=0; i<resultSet.length; i++) {
      if(resultSet[i]){
        res.add(i);
      }
    }
    return res;
  }
}
