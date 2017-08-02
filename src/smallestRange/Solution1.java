package smallestRange;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Solution1 {
  public int[] smallestRange(List<List<Integer>> nums) {
    PriorityQueue<Point> pq = new PriorityQueue<>((a, b) -> (a.x - b.x));
    int size = nums.size();
    int[] idxArr = new int[size];
    int max = 0;
    for (int i = 0; i < size; i++) {
        int num = nums.get(i).get(0);
        pq.add(new Point(num, i));
        max = Math.max(max, num);
    }
    int start = -1, end = -1, gap = Integer.MAX_VALUE;
    while (pq.size() == size) {
        Point first = pq.poll();
        int min = first.x, idx = first.y;
        if (max - min < gap) {
           gap = max - min;
           start = min;
           end = max;
        }
        if (++idxArr[idx] < nums.get(idx).size()) {
           first.x = nums.get(idx).get(idxArr[idx]);
           pq.add(first);
           max = Math.max(max, first.x);
        }
    }
    return new int[] { start, end };
 }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    // [[-89,1,69,89,90,98],[-43,-36,-24,-14,49,61,66,69],[73,94,94,96],[11,13,76,79,90],[-40,-20,1,9,12,12,14],[-91,-31,0,21,25,26,28,29,29,30
    // ],[23,88,89],[31,42,42,57],[-2,6,11,12,12,13,15],[-3,25,34,36,39
    // ],[-7,3,29,29,31,32,33],[-4,11,14,15,15,18,19],[-39,42,70,70,70,71,72,72,73],[-67,-34,6,26,28,28,28,28,29,30,31],[-30,12,15,19,19,20,22]]
    Integer[] i1 = {13, 69, 75, 76, 80};
    Integer[] i2 = {13, 14};
    Integer[] i3 = {1, 2, 3};

    List<Integer> li1 = Arrays.asList(i1);
    List<Integer> li2 = Arrays.asList(i2);
    List<Integer> li3 = Arrays.asList(i3);

    List<List<Integer>> nums = new ArrayList<>();
    nums.add(li1);
    nums.add(li2);
    nums.add(li3);

    s.smallestRange(nums);
  }
}
