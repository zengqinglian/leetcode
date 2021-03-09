package countNumberofTeams;

/*
Runtime: 12 ms, faster than 77.49% of Java online submissions for Count Number of Teams.
Memory Usage: 39 MB, less than 21.18% of Java online submissions for Count Number of Teams.
 */
public class Solution {
  public int numTeams(int[] rating) {
    int[] countIncrease = new int[rating.length];
    int[] countDecrease = new int[rating.length];
    countIncrease[0] = 0;
    countDecrease[0] = 0;
    int total = 0;
    for(int i=1; i<rating.length; i++){
      int cntIncrease = 0;
      int cntDecrease = 0;
      for(int j=0; j<i; j++){
        if(rating[j]<rating[i]){
          cntIncrease++;
          total += (countIncrease[j]);
        }else{
          cntDecrease++;
          total += (countDecrease[j]);
        }
      }
      countIncrease[i] = cntIncrease;
      countDecrease[i] = cntDecrease;
    }
    return total;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] rating = {3,6,4,5,2,1};
    s.numTeams(rating);
  }
}
