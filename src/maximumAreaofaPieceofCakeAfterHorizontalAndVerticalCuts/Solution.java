package maximumAreaofaPieceofCakeAfterHorizontalAndVerticalCuts;

import java.util.Arrays;

public class Solution {
  /*
  Runtime: 13 ms, faster than 88.58% of Java online submissions for Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts.
Memory Usage: 48.7 MB, less than 77.54% of Java online submissions for Maximum Area of a Piece of Cake After Horizontal and Vertical Cuts.
   */
  public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
    Arrays.sort(horizontalCuts);
    Arrays.sort(verticalCuts);
    int mod = 1_000_000_007;
    int max_h = 0;
    for(int i=0; i<horizontalCuts.length; i++){
      if(i==0){
        max_h = Math.max(horizontalCuts[i], max_h);
      }else{
        max_h = Math.max(horizontalCuts[i]-horizontalCuts[i-1], max_h);
      }
      if(i==horizontalCuts.length-1){
        max_h = Math.max(h-horizontalCuts[i], max_h);
      }
    }

    int max_v = 0;
    for(int i=0; i<verticalCuts.length; i++){
      if(i==0){
        max_v = Math.max(verticalCuts[i], max_v);
      }else{
        max_v = Math.max(verticalCuts[i]-verticalCuts[i-1], max_v);
      }
      if(i==verticalCuts.length-1){
        max_v = Math.max(w-verticalCuts[i], max_v);
      }
    }

    long res =  1L * max_h * max_v ;
    return (int)(res % mod);
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] h = {2};
    int[] v ={2};
    s.maxArea(1000000000,1000000000,h,v);
  }
}
