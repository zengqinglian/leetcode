package numberofSubarraysofSizeKandAverageGreaterthanorEqualtoThreshold;

public class Solution {
  //2ms solution, meet avg 50%
  public int numOfSubarrays(int[] arr, int k, int threshold) {
    int total =k * threshold;
    int sum = 0;
    int cnt=0;
    for(int i=0; i< k; i++){
      sum += arr[i];
    }
    if(sum>=total){
      cnt++;
    }
    for(int i=k; i<arr.length; i++){
      sum += arr[i];
      sum-=arr[i-k];
      if(sum>=total){
        cnt++;
      }
    }
    return cnt;
  }
}
