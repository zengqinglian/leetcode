package fourDivisors;

import java.util.ArrayList;
import java.util.List;

/*
Runtime: 140 ms, faster than 17.69% of Java online submissions for Four Divisors.
Memory Usage: 67 MB, less than 5.44% of Java online submissions for Four Divisors.
 */
public class Solution {
  public int sumFourDivisors(int[] nums) {
    int max = 0;
    for(int n : nums){
      max = Math.max(max, n);
    }
    List<Integer>[] divNums = new List[max+1];
    for(int i=2; i<divNums.length/2; i++){
      if(divNums[i] == null){
        divNums[i] = new ArrayList<>();
      }
      int val = 2;
      int t = i * val;
      while(t <divNums.length ){
        if(divNums[t] !=null && divNums[t].size() >= 3){
          val++;
          t=i*val;
          continue;
        }
        if(divNums[t] == null){
          divNums[t] = new ArrayList();
        }
        divNums[t].add(val);
        val++;
        t=i*val;
      }
    }
    int total = 0;
    for(int n : nums){
      if(n==1){
        continue;
      }
      if(divNums[n]!=null && divNums[n].size()==2){
        total+=(1+n);
        for(int d: divNums[n]){
          total+=d;
        }

      }
    }
    return total;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] arr = {1,2,3,4,5};
    s.sumFourDivisors(arr);
  }
}
