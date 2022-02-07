package minimumTimetoMakeRopeColorful;
/*
Runtime: 13 ms, faster than 46.02% of Java online submissions for Minimum Time to Make Rope Colorful.
Memory Usage: 97.1 MB, less than 57.69% of Java online submissions for Minimum Time to Make Rope Colorful.
 */
public class Solution {
  public int minCost(String colors, int[] neededTime) {
    if(colors.length() == 1) {
      return 0;
    }
    int startIndex = 0;
    int endIndex = startIndex+1;
    int totalTime = 0;
    int res = 0;
    int max = 0;
    while(startIndex < colors.length()) {
      char c = colors.charAt(startIndex);
      totalTime+=neededTime[startIndex];
      max = neededTime[startIndex];
      while(endIndex<colors.length()) {
        if(colors.charAt(endIndex) ==c) {
          totalTime += neededTime[endIndex];
          max = Math.max(max, neededTime[endIndex]);
          endIndex++;
        }else{
          break;
        }
      }
      if(endIndex - startIndex > 1) {
        res +=  (totalTime - max);
      }
      startIndex = endIndex;
      endIndex=startIndex+1;
      totalTime=0;
    }
    return res;
  }
}
