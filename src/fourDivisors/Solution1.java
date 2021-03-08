package fourDivisors;
/*
Runtime: 81 ms, faster than 29.25% of Java online submissions for Four Divisors.
Memory Usage: 39.3 MB, less than 44.90% of Java online submissions for Four Divisors.
 */
public class Solution1 {
  public int sumFourDivisors(int[] nums) {
    int max = 0;
    for(int n : nums){
      max = Math.max(max, n);
    }
    boolean[] coms  = new boolean[max+1];
    for(int i=2; i<=max/2;i++){
      if(!coms[i]){
        for(int j=2; j*i<=max; j++){
          coms[j*i]=true;
        }
      }
    }
    int total = 0;
    for(int n : nums){
      if(!coms[n]){
        continue;
      }
      for(int i=2; i<=Math.sqrt(n);i++){
        if(!coms[i]){
          if(n % i ==0){
            int d = n/i;
            if((d!= i && !coms[d]) || d== i*i){
              total+=(1+n+d+i);
            }
          }
        }
      }
    }
    return total;

  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    int[] arr = {1,2,3,4,5,6,7,8,9,10};
    s.sumFourDivisors(arr);
  }
}
