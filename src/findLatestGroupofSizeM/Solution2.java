package findLatestGroupofSizeM;

import java.util.Comparator;
import java.util.TreeSet;
/*
Runtime: 145 ms, faster than 49.15% of Java online submissions for Find Latest Group of Size M.
Memory Usage: 61.8 MB, less than 61.86% of Java online submissions for Find Latest Group of Size M.
 */
public class Solution2 {
  public int findLatestStep(int[] arr, int m) {
    if(arr.length==m) {
      return m;
    }
    int answer = -1;
    int cnt = 0;
    TreeSet<int[]> treeSet = new TreeSet<>(Comparator.comparingInt(a -> a[0]));
    for(int i=1;i<=arr.length; i++) {
      if(treeSet.isEmpty()) {
        int[] p = {arr[i-1], arr[i-1]};
        treeSet.add(p);
        if(m==1) {
          cnt++;
        }
      }else{
        int[] search = {arr[i-1], 0};
        int[] higer = treeSet.higher(search);
        int[] lower = treeSet.lower(search);
        if(higer!= null && lower!=null &&
            higer[0] -1 == arr[i-1] && lower[1]+1 == arr[i-1]) {
          if(higer[1] - higer[0]+1 ==m) {
            cnt--;
          }
          treeSet.remove(higer);
          if(lower[1] - lower[0]+1 ==m) {
            cnt--;
          }
          lower[1] = higer[1];
          if(lower[1] - lower[0]+1 ==m) {
            cnt++;
          }
        }else if(higer!= null && higer[0] -1 == arr[i-1]) {
          if(higer[1] - higer[0]+1 ==m) {
            cnt--;
          }
          higer[0] = arr[i-1];
          if(higer[1] - higer[0]+1 ==m) {
            cnt++;
          }
        }else if (lower!= null && lower[1]+1 == arr[i-1]){
          if(lower[1] - lower[0]+1 ==m) {
            cnt--;
          }
          lower[1] = arr[i-1];
          if(lower[1] - lower[0]+1 ==m) {
            cnt++;
          }
        }else{
          int[] newP = {arr[i-1], arr[i-1]};
          treeSet.add(newP);
          if(m==1) {
            cnt++;
          }
        }
      }
      if(cnt>0){
        answer=Math.max(answer,i);
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    Solution2 s = new Solution2();
    int[] arr = {3,5,1,2,4};
    s.findLatestStep(arr, 1);
  }
}
