package designUndergroundSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
Runtime: 94 ms, faster than 52.01% of Java online submissions for Design Underground System.
Memory Usage: 57.9 MB, less than 20.54% of Java online submissions for Design Underground System.
 */
public class UndergroundSystem {
  Node[] nodes = new Node[1000001];
  Map<Key, Value> map = new HashMap<>();
  public UndergroundSystem() {

  }

  public void checkIn(int id, String stationName, int t) {
    if(nodes[id] == null) {
      nodes[id] = new Node();
    }
    nodes[id].stationName=stationName;
    nodes[id].time = t;
  }

  public void checkOut(int id, String stationName, int t) {
    Key key = new Key();
    key.startName = nodes[id].stationName;
    key.endName = stationName;
    Value value = map.get(key);
    if(value == null){
      value = new Value();
      value.cnt=1;
      value.totalTime=(t-nodes[id].time);
      map.put(key, value);
    }else{
      value.cnt++;
      value.totalTime+=(t-nodes[id].time);
    }
    nodes[id].stationName=null;
    nodes[id].time = -1;
  }

  public double getAverageTime(String startStation, String endStation) {
    Key key = new Key();
    key.startName = startStation;
    key.endName = endStation;
    double res = map.get(key).totalTime*1.0 / map.get(key).cnt;
    System.out.println(res);
    return res;
  }

  static class Node{
    String stationName;
    int time;
  }
  static class Key{
    String startName;
    String endName;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Key key = (Key) o;
      return Objects.equals(startName, key.startName) &&
          Objects.equals(endName, key.endName);
    }

    @Override
    public int hashCode() {
      return Objects.hash(startName, endName);
    }
  }
  static class Value{
    int totalTime;
    int cnt;
  }

  /**
   * Your UndergroundSystem object will be instantiated and called as such:
   * UndergroundSystem obj = new UndergroundSystem();
   * obj.checkIn(id,stationName,t);
   * obj.checkOut(id,stationName,t);
   * double param_3 = obj.getAverageTime(startStation,endStation);
   */
}
