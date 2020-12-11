package findTheCity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
  //45ms solution, beat 35%
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    List<Node>[] nodesList = new List[n];
    for(int[] edge: edges){
      Node node1 = new Node();
      node1.target = edge[1];
      node1.length = edge[2];
      if(nodesList[edge[0]] == null){
        nodesList[edge[0]] = new ArrayList<>();
      }
      nodesList[edge[0]].add(node1);

      Node node2 = new Node();
      node2.target = edge[0];
      node2.length = edge[2];
      if(nodesList[edge[1]] == null) {
        nodesList[edge[1]] = new ArrayList<>();
      }
      nodesList[edge[1]].add(node2);
    }

    int cnt = Integer.MAX_VALUE;
    int res = 0;
    for(int i=0; i<n; i++){
      Queue<Node> q = new LinkedList<>();
      Node root = new Node();
      root.length = 0;
      root.target = i;
      root.curLen = 0;
      q.add(root);
      int[] visited = new int[n];
      Arrays.fill(visited, Integer.MAX_VALUE);
      visited[i] = 0;
      int mark = 0;

      while(!q.isEmpty()){
        int size = q.size();
        for(int j=0; j<size; j++){
          Node node = q.poll();
          int curLen = node.curLen;
          if(nodesList[node.target]!=null){
            for(Node newTarget : nodesList[node.target]){
              int newLen = curLen + newTarget.length;
              if(visited[newTarget.target]<=newLen){
                continue;
              }else {
                if (newLen <= distanceThreshold) {
                  Node newNode = new Node();
                  newNode.target = newTarget.target;
                  newNode.length =newTarget.length;
                  newNode.curLen = newLen;
                  q.add(newNode);
                  if( visited[newTarget.target] == Integer.MAX_VALUE ){
                    mark++;
                    if(mark > cnt){
                      q.clear();
                      break;
                    }
                  }
                  visited[newTarget.target] = newLen;
                }
              }
            }
          }
          if(mark > cnt){
            break;
          }
        }
      }
      if(mark<=cnt){
        cnt=mark;
        res = i;
      }
    }
    return res;
  }
  private static class Node {
    private int target;
    private int length;
    private int curLen;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    //int[][] test ={{3,5,9558},{1,2,1079},{1,3,8040},{0,1,9258},{4,7,7558},{5,6,8196},{3,4,7284},{1,5,6327},{0,4,5966},{3,6,8575},{2,5,8604},{1,7,7782},{4,6,2857},{3,7,2336},{0,6,6},{5,7,2870},{4,5,5055},{0,7,2904},{1,6,2458},{0,5,3399},{6,7,2202},{0,2,3996},{0,3,7495},{1,4,2262},{2,6,1390}};
    int[][] test ={{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
    s.findTheCity(4,test,4);
  }

}
