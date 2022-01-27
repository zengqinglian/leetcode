package minimumNumberofVerticestoReachAllNodes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
Runtime: 41 ms, faster than 15.33% of Java online submissions for Minimum Number of Vertices to Reach All Nodes.
Memory Usage: 121.8 MB, less than 49.37% of Java online submissions for Minimum Number of Vertices to Reach All Nodes.
 */
public class Solution {
  public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
    Set<Integer> resultSet = new HashSet<>();
    boolean[] visited = new boolean[n];
    for(List<Integer> edge : edges) {
      if(!visited[edge.get(0)]) {
        resultSet.add(edge.get(0));
        if(visited[edge.get(1)]) {
          if(resultSet.contains(edge.get(1))){
            resultSet.remove(edge.get(1));
          }
        }
        visited[edge.get(0)]=true;
        visited[edge.get(1)]=true;
      }else{
        if(visited[edge.get(1)] && resultSet.contains(edge.get(1))) {
          resultSet.remove(edge.get(1));
        }
        visited[edge.get(1)]=true;
      }
    }
    return new ArrayList<>(resultSet);
  }
}
