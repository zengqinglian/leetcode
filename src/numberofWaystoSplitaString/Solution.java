package numberofWaystoSplitaString;
/*
Runtime: 6 ms, faster than 97.79% of Java online submissions for Number of Ways to Split a String.
Memory Usage: 43 MB, less than 55.15% of Java online submissions for Number of Ways to Split a String.
 */
public class Solution {
  public int numWays(String s) {
    long[] cnt1 = new long[s.length()+1];
    int total1 = 0;
    for(int i=0; i<s.length(); i++) {
      char c = s.charAt(i);
      if(c == '1') {
        total1++;
        cnt1[total1]++;
      }else{
        cnt1[total1]++;
      }
    }
    if(total1  ==0) {
      return (int)((((long)s.length()-1) * ((long)s.length()-2) / 2) % 1_000_000_007);
    }
    if(total1%3 !=0) {
      return 0;
    }
    int num_1 = total1 / 3;
    long res = (((cnt1[num_1] % 1_000_000_007) * (cnt1[num_1*2]*1_000_000_007)) % 1_000_000_007);
    return (int)res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.numWays("110101011");
  }
}
