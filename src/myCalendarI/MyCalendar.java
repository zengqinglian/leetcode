package myCalendarI;

// 155 ms solution beat 80%
public class MyCalendar {
  private Node root = null;

  public MyCalendar() {

  }

  public boolean book(int start, int end) {
    if (root == null) {
      Node node = new Node(start, end);
      root = node;
      return true;
    } else {
      Node cur = root;
      while (true) {
        if (end <= cur.valStart) {
          if (cur.left == null) {
            cur.left = new Node(start, end);
            return true;
          } else {
            cur = cur.left;
          }
        } else if (start >= cur.valEnd) {
          if (cur.right == null) {
            cur.right = new Node(start, end);
            return true;
          } else {
            cur = cur.right;
          }
        } else {
          return false;
        }
      }
    }
  }

  /**
   * Your MyCalendar object will be instantiated and called as such: MyCalendar obj = new
   * MyCalendar(); boolean param_1 = obj.book(start,end);
   */

  private static class Node {
    private int valStart;
    private int valEnd;
    private Node left;
    private Node right;


    private Node(int valStart, int valEnd) {
      this.valStart = valStart;
      this.valEnd = valEnd;
    }
  }
}
