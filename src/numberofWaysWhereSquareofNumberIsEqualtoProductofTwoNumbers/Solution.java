package numberofWaysWhereSquareofNumberIsEqualtoProductofTwoNumbers;

import java.util.HashMap;
import java.util.Map;
/*
Runtime: 60 ms, faster than 62.37% of Java online submissions for Number of Ways Where Square of Number Is Equal to Product of Two Numbers.
Memory Usage: 44.3 MB, less than 55.91% of Java online submissions for Number of Ways Where Square of Number Is Equal to Product of Two Numbers.
 */
public class Solution {
  public int numTriplets(int[] nums1, int[] nums2) {
    Map<Long, Integer> mapNumber1 = new HashMap<>();
    int res = 0;
    for(int i=0; i<nums1.length; i++) {
      long square = (long)nums1[i] * (long)nums1[i];
      Integer cnt = mapNumber1.get(square);
      if(cnt == null) {
        mapNumber1.put(square,1);
      }else {
        mapNumber1.put(square, cnt + 1);
      }
    }
    Map<Long, Integer> mapNumber2 = new HashMap<>();
    Map<Long, Integer> matchNumber2 = new HashMap<>();
    for(int j=0; j<nums2.length; j++){
      for(long target : mapNumber1.keySet()) {
        if(target % (long)nums2[j] == 0) {
          Integer matched = matchNumber2.get(target/(long)nums2[j]);
          if(matched != null) {
            res+= (mapNumber1.get(target) * matched);
          }
        }
      }
      Integer matchCnt = matchNumber2.get((long)nums2[j]);
      if(matchCnt == null) {
        matchNumber2.put((long)nums2[j],1);
      }else{
        matchNumber2.put((long)nums2[j],matchCnt+1);
      }

      long square = (long)nums2[j] * (long)nums2[j];
      Integer cnt = mapNumber2.get(square);
      if(cnt == null) {
        mapNumber2.put(square,1);
      }else {
        mapNumber2.put(square, cnt + 1);
      }
    }
    Map<Long, Integer> matchNumber1 = new HashMap<>();
    for(int j=0; j<nums1.length; j++) {
      for(long target : mapNumber2.keySet()) {
        if(target % nums1[j] == 0) {
          Integer matched = matchNumber1.get(target/(long)nums1[j]);
          if(matched != null) {
            res+= (mapNumber2.get(target) * matched);
          }
        }
      }
      Integer cnt = matchNumber1.get((long)nums1[j]);
      if(cnt == null) {
        matchNumber1.put((long)nums1[j],1);
      }else{
        matchNumber1.put((long)nums1[j],cnt+1);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums1 = {1,1,1};
    int[] nums2 = {1,1,1};
    s.numTriplets(nums1, nums2);
  }
}
