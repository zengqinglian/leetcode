package findKClosestElements;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  // solution beat over 80%
  // find mid element first
  public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {

    if (k == 0) {
      return new ArrayList<>();
    }
    if (k == arr.size()) {
      return arr;
    }
    if (x <= arr.get(0)) {
      return arr.subList(0, k);
    }

    if (x >= arr.get(arr.size() - 1)) {
      return arr.subList(arr.size() - k, arr.size());
    }

    int i = 0;
    int j = arr.size() - 1;

    int target = -1;
    while (j - i > 1) {
      int mid = (j - i) / 2;
      if (arr.get(mid) > x) {
        j = i + mid;
      } else if (arr.get(mid) < x) {
        i = i + mid;
      } else {
        target = mid;
        break;
      }
    }

    if (target == -1) {
      if (Math.abs(arr.get(i) - x) <= Math.abs(arr.get(j) - x)) {
        target = i;
      } else {
        target = j;
      }
    }


    int s = target - k / 2;
    int e = s + k - 1;
    if (e > arr.size() - 1) {
      e = arr.size() - 1;
      s = arr.size() - k;
    }
    if (s < 0) {
      s = 0;
      e = k - 1;
    }

    while (s > 0) {
      if (e + 1 < arr.size() && Math.abs(arr.get(s) - x) > Math.abs(arr.get(e) - x)) {
        if (Math.abs(arr.get(e + 1) - x) < Math.abs(arr.get(s) - x)) {
          s++;
          e++;
        } else {
          break;
        }
      } else {
        if (s - 1 >= 0 && Math.abs(arr.get(s - 1) - x) <= Math.abs(arr.get(e) - x)) {
          s--;
          e--;
        } else {
          break;
        }
      }
    }

    return arr.subList(s, s + k);
  }

  public static void main(String[] args) {
    /*
     * [0,0,0,1,3,5,6,7,8,8] 2 2
     */

    /*
     * [0,1,1,1,2,3,6,7,8,9] 9 4
     */
    Solution s = new Solution();
    List<Integer> li = new ArrayList<>();
    li.add(0);
    li.add(1);
    li.add(1);
    li.add(1);
    li.add(2);
    li.add(3);
    li.add(6);
    li.add(7);
    li.add(8);
    li.add(9);
    s.findClosestElements(li, 9, 4);

  }

}
