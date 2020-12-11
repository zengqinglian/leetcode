package findTheCity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

//Someone's solution use Dijkstra . beat 30% 50ms
public class Solution2 {
  class Vertex {

    int to;
    int dist;
    Vertex(int to, int dist){

      this.to = to;
      this.dist = dist;
    }
  }
  HashMap<Integer,ArrayList<Vertex>> graph = new HashMap<>();
  public int findTheCity(int n, int[][] edges, int power) {

    for(int [] edge : edges){
      int a = edge[0];
      int b = edge[1];
      int dist = edge[2];

      graph.putIfAbsent(a,new ArrayList<>());
      graph.putIfAbsent(b,new ArrayList<>());

      //Undirected graph
      graph.get(a).add(new Vertex(b,dist));
      graph.get(b).add(new Vertex(a,dist));
    }


    //call Dijkstra for
    int vertex = 0;
    int numberOfCities = Integer.MAX_VALUE;
    for(int i=0;i<n;i++){
      int size = performDijkstra(i,power,n);
      System.out.println("For city = "+i+" Number of neighbours = "+size);
      if(numberOfCities>=size){
        vertex = i;
        numberOfCities = Math.min(size,numberOfCities);
      }
    }

    return vertex;
  }

  private int performDijkstra(int start, int power, int n){
    //Dijkstra
    PriorityQueue<Vertex> pq = new PriorityQueue<Vertex>((a,b) -> (a.dist - b.dist));
    pq.add(new Vertex(start,0));

    HashMap<Integer,Integer>visited = new HashMap<>();


    int [] distance = new int[n];
    Arrays.fill(distance,Integer.MAX_VALUE);
    distance [start] = 0;

    while(!pq.isEmpty()){

      Vertex vt = pq.poll();
      if(visited.containsKey(vt.to) && vt.dist > visited.get(vt.to))continue; //we already have shortest path
      //else visit
      visited.put(vt.to,vt.dist);

      for(Vertex nbr : graph.getOrDefault(vt.to,new ArrayList<>())){

        int dist = vt.dist+nbr.dist;
        if(dist>power)continue; //not enough power to visit

        //If not visited from before or have visited but not with a shortest path
        if(!visited.containsKey(nbr.to) || (visited.get(nbr.to)>dist)){
          visited.put(nbr.to,dist);
          pq.add(new Vertex(nbr.to,dist));

        }
      }
    }

    return visited.size()-1;

  }
}
