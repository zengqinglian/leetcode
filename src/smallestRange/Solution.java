package smallestRange;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

public class Solution {
  // timeover limit solution
  public int[] smallestRange(List<List<Integer>> nums) {

    TreeMap<Integer, List<int[]>> map = new TreeMap<>(new Comparator<Integer>() {
      @Override
      public int compare(Integer o1, Integer o2) {
        return o1 - o2;
      }
    });

    int[] result = new int[2];

    for (int i = 0; i < nums.size(); i++) {
      int[] e = new int[2];
      e[0] = i;
      e[1] = 0;
      if (!map.containsKey(nums.get(i).get(0))) {
        List<int[]> list = new ArrayList<>();
        list.add(e);
        map.put(nums.get(i).get(0), list);
      } else {
        List<int[]> list = map.get(nums.get(i).get(0));
        list.add(e);
      }
    }

    int min = map.firstKey();
    int max = map.lastKey();

    result[0] = min;
    result[1] = max;

    while (true) {
      List<int[]> e = map.get(min);
      int[] targetI = e.get(0);

      if (nums.get(targetI[0]).size() - 1 == targetI[1]) {
        break;
      }

      if (e.size() == 1) {
        map.remove(min);

        int[] n = new int[2];
        n[0] = targetI[0];
        n[1] = targetI[1] + 1;

        if (!map.containsKey(nums.get(n[0]).get(n[1]))) {
          List<int[]> list = new ArrayList<>();
          list.add(n);
          map.put(nums.get(n[0]).get(n[1]), list);
        } else {
          List<int[]> list = map.get(nums.get(n[0]).get(n[1]));
          list.add(n);
        }

        min = map.firstKey();
        max = map.lastKey();
      }

      for (int i = 1; i < e.size(); i++) {
        int[] m = e.get(i);
        if (nums.get(m[0]).size() - 1 == m[1]) {
          if (result[1] - result[0] > max - min) {
            result[0] = min;
            result[1] = max;
            return result;
          }
        } else {
          if (nums.get(m[0]).get(m[1] + 1) < nums.get(targetI[0]).get(targetI[1] + 1)) {
            targetI = m;
          }
        }
      }

      e.remove(targetI);

      int[] n = new int[2];
      n[0] = targetI[0];
      n[1] = targetI[1] + 1;

      if (!map.containsKey(nums.get(n[0]).get(n[1]))) {
        List<int[]> list = new ArrayList<>();
        list.add(n);
        map.put(nums.get(n[0]).get(n[1]), list);
      } else {
        List<int[]> list = map.get(nums.get(n[0]).get(n[1]));
        list.add(n);
      }

      if (result[1] - result[0] > max - min) {
        result[0] = min;
        result[1] = max;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    // [[-89,1,69,89,90,98],[-43,-36,-24,-14,49,61,66,69],[73,94,94,96],[11,13,76,79,90],[-40,-20,1,9,12,12,14],[-91,-31,0,21,25,26,28,29,29,30
    // ],[23,88,89],[31,42,42,57],[-2,6,11,12,12,13,15],[-3,25,34,36,39
    // ],[-7,3,29,29,31,32,33],[-4,11,14,15,15,18,19],[-39,42,70,70,70,71,72,72,73],[-67,-34,6,26,28,28,28,28,29,30,31],[-30,12,15,19,19,20,22]]
    Integer[] i1 = {-89, 1, 69, 89, 90, 98};
    Integer[] i2 = {-43, -36, -24, -14, 49, 61, 66, 69};
    Integer[] i3 = {73, 94, 94, 96};
    Integer[] i4 = {11, 13, 76, 79, 90};
    Integer[] i5 = {-40, -20, 1, 9, 12, 12, 14};
    Integer[] i6 = {-91, -31, 0, 21, 25, 26, 28, 29, 29, 30};

    Integer[] i7 = {23, 88, 89};
    Integer[] i8 = {31, 42, 42, 57};
    Integer[] i9 = {-2, 6, 11, 12, 12, 13, 15};

    Integer[] i10 = {-3, 25, 34, 36, 39};
    Integer[] i11 = {-7, 3, 29, 29, 31, 32, 33};
    Integer[] i12 = {-4, 11, 14, 15, 15, 18, 19};

    Integer[] i13 = {-39, 42, 70, 70, 70, 71, 72, 72, 73};
    Integer[] i14 = {-67, -34, 6, 26, 28, 28, 28, 28, 29, 30, 31};
    Integer[] i15 = {-30, 12, 15, 19, 19, 20, 22};

    List<Integer> li1 = Arrays.asList(i1);
    List<Integer> li2 = Arrays.asList(i2);
    List<Integer> li3 = Arrays.asList(i3);

    List<Integer> li4 = Arrays.asList(i4);
    List<Integer> li5 = Arrays.asList(i5);
    List<Integer> li6 = Arrays.asList(i6);

    List<Integer> li7 = Arrays.asList(i7);
    List<Integer> li8 = Arrays.asList(i8);
    List<Integer> li9 = Arrays.asList(i9);

    List<Integer> li10 = Arrays.asList(i10);
    List<Integer> li11 = Arrays.asList(i11);
    List<Integer> li12 = Arrays.asList(i12);

    List<Integer> li13 = Arrays.asList(i13);
    List<Integer> li14 = Arrays.asList(i14);
    List<Integer> li15 = Arrays.asList(i15);
    List<List<Integer>> nums = new ArrayList<>();
    nums.add(li1);
    nums.add(li2);
    nums.add(li3);
    nums.add(li4);
    nums.add(li5);
    nums.add(li6);
    nums.add(li7);
    nums.add(li8);
    nums.add(li9);
    nums.add(li10);
    nums.add(li11);
    nums.add(li12);
    nums.add(li13);
    nums.add(li14);
    nums.add(li15);

    s.smallestRange(nums);
  }
}
