package myCalendarII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

class MyCalendarTwo {
  // 360ms solution, beat 30%
  private TreeMap<Node, Integer> map;

  public MyCalendarTwo() {
    map = new TreeMap<>();
  }

  public boolean book(int start, int end) {
    if (map.isEmpty()) {
      Node newNode = new Node(start, end);
      map.put(newNode, 1);
      return true;
    }
    Map<Node, Integer> newEntry = new HashMap<>();
    Set<Node> removeEntry = new HashSet<>();
    boolean needToAdd = false;
    for (Node node : map.keySet()) {
      needToAdd = false;
      if (end <= node.left || start >= node.right) {
        if (end <= node.left) {
          Node newNode = new Node(start, end);
          newEntry.put(newNode, 1);
          break;
        } else {
          needToAdd = true;
          continue;
        }
      } else {
        int currentBooking = map.get(node);
        if (currentBooking <= 1) {
          removeEntry.add(node);
          if (start < node.left) {
            Node newNode = new Node(start, node.left);
            newEntry.put(newNode, 1);
            if (end < node.right) {
              Node updateNode = new Node(node.left, end);
              newEntry.put(updateNode, currentBooking + 1);
              Node updateNode1 = new Node(end, node.right);
              newEntry.put(updateNode1, currentBooking);
              break;
            } else if (end > node.right) {
              Node updateNode = new Node(node.left, node.right);
              newEntry.put(updateNode, currentBooking + 1);
              start = node.right;
              needToAdd = true;
              continue;
            } else {
              Node updateNode = new Node(node.left, end);
              newEntry.put(updateNode, currentBooking + 1);
              break;
            }
          } else if (start > node.left) {
            Node newNode = new Node(node.left, start);
            newEntry.put(newNode, currentBooking);
            if (end < node.right) {
              Node updateNode = new Node(start, end);
              newEntry.put(updateNode, currentBooking + 1);
              Node updateNode1 = new Node(end, node.right);
              newEntry.put(updateNode1, currentBooking);
              break;
            } else if (end > node.right) {
              Node updateNode = new Node(start, node.right);
              newEntry.put(updateNode, currentBooking + 1);
              start = node.right;
              needToAdd = true;
              continue;
            } else {
              Node updateNode = new Node(start, end);
              newEntry.put(updateNode, currentBooking + 1);
              break;
            }
          } else {
            if (end < node.right) {
              Node updateNode = new Node(start, end);
              newEntry.put(updateNode, currentBooking + 1);
              Node updateNode1 = new Node(end, node.right);
              newEntry.put(updateNode1, currentBooking);
              break;
            } else if (end > node.right) {
              Node updateNode = new Node(start, node.right);
              newEntry.put(updateNode, currentBooking + 1);
              start = node.right;
              needToAdd = true;
              continue;
            } else {
              Node updateNode = new Node(start, end);
              newEntry.put(updateNode, currentBooking + 1);
              break;
            }
          }
        } else {
          return false;
        }
      }
    }

    if (needToAdd) {
      Node newNode = new Node(start, end);
      newEntry.put(newNode, 1);
    }

    for (Node node : removeEntry) {
      map.remove(node);

    }

    map.putAll(newEntry);

    return true;

  }

  private static class Node implements Comparable<Node> {
    private int left;
    private int right;

    public Node(int left, int right) {
      this.left = left;
      this.right = right;
    }

    @Override
    public String toString() {
      return "Node [left=" + left + ", right=" + right + "]";
    }

    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + left;
      result = prime * result + right;
      return result;
    }

    @Override
    public boolean equals(Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Node other = (Node) obj;
      if (left != other.left)
        return false;
      if (right != other.right)
        return false;
      return true;
    }

    @Override
    public int compareTo(Node o) {
      if (this.left < o.left) {
        return -1;
      } else if (this.left > o.left) {
        return 1;
      } else {
        if (o.right < o.right) {
          return -1;
        } else if (o.right > o.right) {
          return 1;

        } else {
          return 0;
        }
      }
    }



  }

  public static void main(String[] args) {
    MyCalendarTwo c = new MyCalendarTwo();
    // [[],[22,29],[12,17],[20,27],[27,36],[24,31],
    // [23,28], [47,50],[23,30],[24,29],[19,25],
    // [19,27],[3,9],[34,41],[22,27],[3,9],
    // [29,38],[34,40],[49,50],[42,48],[43,50],[39,44],
    // [30,38],[42,50],[31,39],[9,16],[10,18],[31,39],[30,39],[48,50],[36,42]]
    System.out.println(c.book(22, 29));
    System.out.println(c.book(12, 17));
    System.out.println(c.book(20, 27));
    System.out.println(c.book(27, 36));
    System.out.println(c.book(24, 31) + "\n");

    System.out.println(c.book(23, 28));
    System.out.println(c.book(47, 50));
    System.out.println(c.book(23, 30));
    System.out.println(c.book(24, 29));
    System.out.println(c.book(19, 25) + "\n");

    System.out.println(c.book(19, 27));
    System.out.println(c.book(3, 9));
    System.out.println(c.book(34, 41));
    System.out.println(c.book(22, 27));
    System.out.println(c.book(3, 9) + "\n");

    System.out.println(c.book(29, 38));

    // [null,true,true,true,true,false,
    // false,true,false,false,false,
    // false,true,true,false,true,
    // false,false,true,true,false,true,false,false,false,true,false,false,false,false,false]
  }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such: MyCalendarTwo obj = new
 * MyCalendarTwo(); boolean param_1 = obj.book(start,end);
 */

