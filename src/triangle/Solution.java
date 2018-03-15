package triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  // 8ms solution - beat 75%
  public int minimumTotal(List<List<Integer>> triangle) {
    if (triangle.isEmpty()) {
      return 0;
    }
    int max = triangle.get(triangle.size() - 1).size();

    if (max == 0) {
      return 0;
    }

    int total = (1 + max) * max / 2;

    int[] result = new int[total];
    result[0] = triangle.get(0).get(0);
    int lastIndex = 0;
    int index = 1;
    int minVal = Integer.MAX_VALUE;
    if (total == 1) {
      return Math.min(result[0], minVal);
    }
    for (int i = 1; i < triangle.size(); i++) {
      List<Integer> li = triangle.get(i);
      if (li.isEmpty()) {
        continue;
      }
      result[index] = result[lastIndex] + li.get(0);
      if (i == triangle.size() - 1) {
        minVal = Math.min(result[index], minVal);
      }
      index++;
      result[index] = result[lastIndex] + li.get(1);
      if (i == triangle.size() - 1) {
        minVal = Math.min(result[index], minVal);
      }
      lastIndex++;
      for (int j = 1; j < li.size() - 1; j++) {
        result[index] = Math.min(result[index], result[lastIndex] + li.get(j));
        if (i == triangle.size() - 1) {
          minVal = Math.min(result[index], minVal);
        }
        index++;
        result[index] = result[lastIndex] + li.get(j + 1);
        if (i == triangle.size() - 1) {
          minVal = Math.min(result[index], minVal);
        }
        lastIndex++;
      }
      index++;

    }
    return minVal;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    List<Integer> li1 = new ArrayList<>();
    li1.add(2);

    List<Integer> li2 = new ArrayList<>();
    li2.add(3);
    li2.add(4);

    List<Integer> li3 = new ArrayList<>();
    li3.add(6);
    li3.add(5);
    li3.add(7);

    List<Integer> li4 = new ArrayList<>();
    li4.add(4);
    li4.add(1);
    li4.add(8);
    li4.add(3);

    List<List<Integer>> triangle = new ArrayList<>();
    triangle.add(li1);
    triangle.add(li2);
    triangle.add(li3);
    triangle.add(li4);

    s.minimumTotal(triangle);
  }
}
