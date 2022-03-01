package numberofOrdersintheBacklog;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

/*
Runtime: 89 ms, faster than 23.77% of Java online submissions for Number of Orders in the Backlog.
Memory Usage: 99.9 MB, less than 24.87% of Java online submissions for Number of Orders in the Backlog.
 */
public class Solution {
  public int getNumberOfBacklogOrders(int[][] orders) {
    TreeMap<Integer, int[]> buyOrder = new TreeMap<>((a,b)->Integer.compare(b,a));
    TreeMap<Integer, int[]> sellOrder = new TreeMap<>();

    for(int[] order : orders) {
      if(order[2] == 1) {
        if(buyOrder.isEmpty()){
          if(sellOrder.containsKey(order[0])){
            sellOrder.get(order[0])[1] += order[1];
          }else {
            sellOrder.put(order[0], order);
          }
        }else {
          Set<Integer> removedKeys = new HashSet<>();
          for(int key : buyOrder.keySet()) {
            int[] buySideOrder = buyOrder.get(key);
            if (buySideOrder[0] >= order[0]) {
              if (buySideOrder[1] < order[1]) {
                order[1] -= buySideOrder[1];
                removedKeys.add(buySideOrder[0]);
              } else if (buySideOrder[1] > order[1]) {
                buySideOrder[1] -= order[1];
                order[1]=0;
                break;
              } else {
                buyOrder.remove(buySideOrder[0]);
                order[1]=0;
                break;
              }
            }else{
              break;
            }
          }
          if(order[1]>0) {
            if(sellOrder.containsKey(order[0])){
              sellOrder.get(order[0])[1] += order[1];
            }else {
              sellOrder.put(order[0], order);
            }
          }
          buyOrder.keySet().removeAll(removedKeys);
        }
      } else {
        if(sellOrder.isEmpty()){
          if(buyOrder.containsKey(order[0])){
            buyOrder.get(order[0])[1] += order[1];
          }else {
            buyOrder.put(order[0], order);
          }
        }else {
          Set<Integer> removedKeys = new HashSet<>();
          for(int key : sellOrder.keySet()) {
            int[] sellSideOrder = sellOrder.get(key);
            if (sellSideOrder[0] <= order[0]) {
              if (sellSideOrder[1] < order[1]) {
                order[1] -= sellSideOrder[1];
                removedKeys.add(sellSideOrder[0]);
              } else if (sellSideOrder[1] > order[1]) {
                sellSideOrder[1] -= order[1];
                order[1]=0;
                break;
              } else {
                sellOrder.remove(sellSideOrder[0]);
                order[1]=0;
                break;
              }
            }else{
              break;
            }
          }
          if(order[1]>0) {
            if(buyOrder.containsKey(order[0])){
              buyOrder.get(order[0])[1] += order[1];
            }else {
              buyOrder.put(order[0], order);
            }
          }
          sellOrder.keySet().removeAll(removedKeys);
        }
      }
    }
    int res = 0;
    for(int[] v : buyOrder.values()) {
      res+=v[1];
      res%=1_000_000_007;
    }
    for(int[] v : sellOrder.values()) {
      res+=v[1];
      res%=1_000_000_007;
    }
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] orders = {{23,8,0},{28,29,1},{11,30,1},{30,25,0},{26,9,0},{3,21,0},{28,19,1},{19,30,0},{20,9,1},{17,6,0}};
    s.getNumberOfBacklogOrders(orders);
  }
}
