package findLatestGroupofSizeM;

import java.util.Comparator;
import java.util.TreeSet;
/*
Runtime: 167 ms, faster than 46.61% of Java online submissions for Find Latest Group of Size M.
Memory Usage: 56.5 MB, less than 66.95% of Java online submissions for Find Latest Group of Size M.
 */
public class Solution1 {
  public int findLatestStep(int[] arr, int m) {
    TreeSet<int[]> treeSet = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
    int[] p = {1, arr.length};
    if(arr.length==m) {
      return m;
    }
    treeSet.add(p);
    for(int i= arr.length; i>=1; i--) {
      int idx = arr[i-1];
      int[] point = {arr[i-1], 0};
      int[] higer = treeSet.floor(point);
      int[] lower = treeSet.ceiling(point);
      if( higer  != null && higer[0] <= arr[i-1] && arr[i-1] <= higer[1] ) {
        if(higer[0] == higer[1]) {
          treeSet.remove(higer);
        }else {
          if(idx == higer[0]) {
            higer[0]++;
            if(higer[1]-higer[0] +1 ==m) {
              return i-1;
            }
          }else if(idx == higer[1]) {
            higer[1]--;
            if(higer[1]-higer[0] +1 ==m) {
              return i-1;
            }
          }else {
            treeSet.remove(higer);
            int[] half_1 = {higer[0], idx-1};
            int[] half_2 = {idx+1, higer[1]};
            if(half_1[1]-half_1[0]+1 ==m ||  half_2[1]-half_2[0]+1 ==m ) {
              return i-1;
            }else{
              treeSet.add(half_1);
              treeSet.add(half_2);
            }
          }
        }
      }else if(lower!=null){
        if(lower[0] == lower[1]) {
          treeSet.remove(lower);
        }else {
          if(idx == lower[0]) {
            lower[0]++;
            if(lower[1]-lower[0] +1 ==m) {
              return i-1;
            }
          }else if(idx == lower[1]) {
            lower[1]--;
            if(lower[1]-lower[0] +1 ==m) {
              return i-1;
            }
          }else {
            treeSet.remove(lower);
            int[] half_1 = {lower[0], idx-1};
            int[] half_2 = {idx+1, lower[1]};
            if(half_1[1]-half_1[0]+1 ==m  ||  half_2[1]-half_2[0]+1 ==m ) {
              return i-1;
            }else{
              treeSet.add(half_1);
              treeSet.add(half_2);
            }
          }
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    int[] arr = {4,3,2,1};
    s.findLatestStep(arr,2);
  }
}
