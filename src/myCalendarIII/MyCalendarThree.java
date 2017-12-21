package myCalendarIII;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// 375 ms solution , beat 25%
public class MyCalendarThree {

  private TreeMap<Node, Integer> map;
  private int max = 1;

  public MyCalendarThree() {
    map = new TreeMap<>();
  }

  public int book(int start, int end) {
    if (map.isEmpty()) {
      Node newNode = new Node(start, end);
      map.put(newNode, 1);
      return 1;
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
        max = Math.max(max, currentBooking + 1);
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

    return max;

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

}

/**
 * Your MyCalendarThree object will be instantiated and called as such: MyCalendarThree obj = new
 * MyCalendarThree(); int param_1 = obj.book(start,end);
 */
