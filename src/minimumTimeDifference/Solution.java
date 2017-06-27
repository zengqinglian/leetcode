package minimumTimeDifference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
  // Sorting the time , then calculate the min
  public int findMinDifference(List<String> timePoints) {
    Collections.sort(timePoints, new Comparator<String>() {

      @Override
      public int compare(String o1, String o2) {
        String[] time1 = o1.split(":");
        String[] time2 = o2.split(":");
        int h1 = Integer.parseInt(time1[0]);
        int m1 = Integer.parseInt(time1[1]);

        int h2 = Integer.parseInt(time2[0]);
        int m2 = Integer.parseInt(time2[1]);

        if (h1 > h2) {
          return 1;
        } else if (h1 < h2) {
          return -1;
        } else {
          if (m1 > m2) {
            return 1;
          } else if (m1 < m2) {
            return -1;
          } else {
            return 0;
          }
        }
      }
    });

    int min = Integer.MAX_VALUE;

    for (int i = 1; i < timePoints.size(); i++) {
      int diff = getTimeDiff(timePoints.get(i - 1), timePoints.get(i));
      if (diff == 0) {
        return 0;
      } else {
        min = Math.min(min, diff);
      }
    }

    int diff = getTimeDiff(timePoints.get(0), timePoints.get(timePoints.size() - 1));

    return Math.min(min, diff);
  }

  private int getTimeDiff(String t1, String t2) {
    String[] time1 = t1.split(":");
    String[] time2 = t2.split(":");
    int h1 = Integer.parseInt(time1[0]);
    int m1 = Integer.parseInt(time1[1]);

    int h2 = Integer.parseInt(time2[0]);
    int m2 = Integer.parseInt(time2[1]);

    int diff = (h2 * 60 + m2) - (h1 * 60 + m1);
    return Math.min(diff, 24 * 60 - diff);
  }

  public static void main(String[] args) {
    List<String> timePoints = new ArrayList<>();
    // timePoints ["23:59","00:00", "01:01", "17:20"]
    timePoints.add("23:59");
    timePoints.add("00:00");
    timePoints.add("01:01");
    timePoints.add("17:20");
    Solution s = new Solution();
    s.findMinDifference(timePoints);
  }
}
