package minimumNumberofBucketsRequiredtoCollectRainwaterfromHouses;
/*
Runtime: 13 ms, faster than 41.87% of Java online submissions for Minimum Number of Buckets Required to Collect Rainwater from Houses.
Memory Usage: 50.4 MB, less than 49.59% of Java online submissions for Minimum Number of Buckets Required to Collect Rainwater from Houses.
 */
public class Solution {
  public int minimumBuckets(String street) {
    int cnt = 0;
    boolean[] result = new boolean[street.length()];
    for(int i=0; i<street.length(); i++) {
      if('H'==street.charAt(i) && !result[i]) {
        //Invalid case.  HHH,  (head)HH,  HH(tail)
        if(((i-1>=0 && 'H' == street.charAt(i-1)) || i-1<0)
            && (i+1<street.length() && 'H'==street.charAt(i+1) || i+1>=street.length())){
          return -1;
        }else {
          result[i] = true;
          cnt++;
          if(i+1<street.length() && '.'==street.charAt(i+1)
              && i+2<street.length() && 'H'==street.charAt(i+2)) {
            result[i+2] = true;
          }
        }
      }
    }
    return cnt;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.minimumBuckets(".H.H.H.H.H");
  }
}
