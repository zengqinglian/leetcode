package designFrontMiddleBackQueue;
/*
Runtime: 11 ms, faster than 64.71% of Java online submissions for Design Front Middle Back Queue.
Memory Usage: 49.4 MB, less than 57.84% of Java online submissions for Design Front Middle Back Queue.
 */
public class FrontMiddleBackQueue {
  Node head;
  Node tail;
  int total;
  Node mid;
  public FrontMiddleBackQueue() {

  }

  public void pushFront(int val) {
    if(total == 0) {
      head = new Node(val);
      tail = head;
      mid = head;
      total++;
    }else {
      Node newHead = new Node(val);
      newHead.next = head;
      head.pre=newHead;
      head = newHead;
      total++;
      if(total % 2 == 0) {
        mid = mid.pre;
      }
    }
  }

  public void pushMiddle(int val) {
    if(total == 0 ) {
      head = new Node(val);
      tail = head;
      mid = head;
      total++;
    }else{
      Node newMid = new Node(val);
      if(total % 2 ==0){
        newMid.pre = mid;
        newMid.next = mid.next;
        mid.next.pre = newMid;
        mid.next = newMid;
        mid = newMid;
      }else{
        newMid.pre = mid.pre;
        newMid.next = mid;
        if(mid.pre ==null) {
          head = newMid;
          mid.pre = newMid;
        }else {
          mid.pre.next = newMid;
          mid.pre = newMid;
        }
        mid = newMid;
      }
      total++;
    }
  }

  public void pushBack(int val) {
    if(total == 0 ) {
      head = new Node(val);
      tail = head;
      mid = head;
      total++;
    }else{
      Node newTail = new Node(val);
      newTail.pre=tail;
      tail.next = newTail;
      tail = newTail;
      total++;
      if(total%2==1) {
        mid = mid.next;
      }
    }
  }

  public int popFront() {
    if(total == 0) {
      return -1;
    }
    total--;
    Node oldHead = head;
    if(total == 0) {
      head = null;
      mid = null;
      tail = null;
    }else{
      head = head.next;
      head.pre = null;
      if(total%2 ==1) {
        mid = mid.next;
      }
    }
    return oldHead.v;
  }

  public int popMiddle() {
    if(total == 0) {
      return -1;
    }
    total--;
    Node oldMid = mid;
    if(total==0){
      head = null;
      mid = null;
      tail = null;
    }else{
      if(oldMid.pre!=null) {
        oldMid.pre.next = oldMid.next;
        oldMid.next.pre = oldMid.pre;
      }else{
        head = oldMid.next;
        head.pre = null;
      }
      if(total%2==1){
        mid = oldMid.next;
      }else{
        mid = oldMid.pre;
      }
    }

    return oldMid.v;
  }

  public int popBack() {
    if(total == 0) {
      return -1;
    }
    total--;
    Node oldTail = tail;
    if(total==0){
      head = null;
      mid = null;
      tail = null;
    }else{
      oldTail.pre.next = null;
      tail = oldTail.pre;
      if(total%2 ==0) {
        mid = mid.pre;
      }
    }
    return oldTail.v;
  }

  private static class Node {
    int v;
    Node pre;
    Node next;
    Node(int v) {
      this.v = v;
    }
  }

  public static void main(String[] args) {
    FrontMiddleBackQueue frontMiddleBackQueue = new FrontMiddleBackQueue();
    /*
   ["FrontMiddleBackQueue","pushMiddle","pushMiddle","popMiddle","popFront","popMiddle",
   "popMiddle","pushMiddle","popMiddle","pushMiddle","pushMiddle","popMiddle","pushMiddle","pushFront",
   "pushMiddle","popMiddle","pushMiddle","pushMiddle","popMiddle","pushFront","pushMiddle","pushMiddle",
   "popMiddle","popBack","popBack","popBack","popMiddle","popMiddle","pushMiddle",
   "popBack","popMiddle","popMiddle","pushMiddle","pushMiddle","pushMiddle","popMiddle"]
     */
    //System.out.println(frontMiddleBackQueue.popMiddle());
    frontMiddleBackQueue.pushMiddle(1);
    frontMiddleBackQueue.pushMiddle(2);
    System.out.println(frontMiddleBackQueue.popMiddle());
    frontMiddleBackQueue.pushMiddle(3);
    frontMiddleBackQueue.pushFront(4);
    frontMiddleBackQueue.pushMiddle(5);
    System.out.println(frontMiddleBackQueue.popBack());
    System.out.println(frontMiddleBackQueue.popBack());
    System.out.println(frontMiddleBackQueue.popBack());
  }
}
