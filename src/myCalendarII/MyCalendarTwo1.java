package myCalendarII;

import java.util.ArrayList;
import java.util.List;

// improvement 285ms solution beat 70%
public class MyCalendarTwo1 {

  private List<int[]> calendar;
  private List<int[]> overlaps;

  MyCalendarTwo1() {
    calendar = new ArrayList<>();
    overlaps = new ArrayList<>();
  }

  public boolean book(int start, int end) {
    for (int[] iv : overlaps) {
      if (iv[0] < end && start < iv[1])
        return false;
    }
    for (int[] iv : calendar) {
      if (iv[0] < end && start < iv[1])
        overlaps.add(new int[] {Math.max(start, iv[0]), Math.min(end, iv[1])});
    }
    calendar.add(new int[] {start, end});
    return true;
  }
}
