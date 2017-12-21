package myCalendarIII;

import java.util.TreeMap;

public class MyCalendarThree1 {

  TreeMap<Integer, Integer> delta;

  public MyCalendarThree1() {
    delta = new TreeMap<>();
  }

  public int book(int start, int end) {
    delta.put(start, delta.getOrDefault(start, 0) + 1);
    delta.put(end, delta.getOrDefault(end, 0) - 1);

    int active = 0, ans = 0;
    for (int d : delta.values()) {
      active += d;
      if (active > ans)
        ans = active;
    }
    return ans;
  }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such: MyCalendarThree obj = new
 * MyCalendarThree(); int param_1 = obj.book(start,end);
 */
