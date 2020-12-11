package findTheCity;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
  //45ms solution, beat 35%
  public int findTheCity(int n, int[][] edges, int distanceThreshold) {
    int[][] distanceMetrics = new int[n][n];
    for(int[] edge : edges){
      distanceMetrics[edge[0]][edge[1]] = edge[2];
      distanceMetrics[edge[1]][edge[0]] = edge[2];
    }

    int cnt = Integer.MAX_VALUE;
    int res = 0;
    for(int i=0; i<n; i++){
      Queue<Integer> q = new LinkedList<>();
      Queue<Integer> lenQ = new LinkedList<>();
      q.add(i);
      lenQ.add(0);
      int[] visited = new int[n];
      int mark=0;
      while(!q.isEmpty()){
        int size = q.size();
        for(int j=0; j<size; j++){
          int targetIndex = q.poll();
          int curLen = lenQ.poll();
          for(int x = 0; x<n; x++){
            if(x == i){
              continue;
            }else{
              if(distanceMetrics[targetIndex][x] > 0) {
                int newLen = curLen + distanceMetrics[targetIndex][x];
                if(newLen <= distanceThreshold && ( visited[x] == 0 || (visited[x] > newLen))){
                  q.add(x);
                  lenQ.add(newLen);
                  if( visited[x] == 0 ){
                    mark++;
                  }
                  visited[x] = newLen;
                }
              }
            }
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

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    //int[][] test ={{3,5,9558},{1,2,1079},{1,3,8040},{0,1,9258},{4,7,7558},{5,6,8196},{3,4,7284},{1,5,6327},{0,4,5966},{3,6,8575},{2,5,8604},{1,7,7782},{4,6,2857},{3,7,2336},{0,6,6},{5,7,2870},{4,5,5055},{0,7,2904},{1,6,2458},{0,5,3399},{6,7,2202},{0,2,3996},{0,3,7495},{1,4,2262},{2,6,1390}};
    int[][] test ={{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
    s.findTheCity(4,test,4);
  }
}
