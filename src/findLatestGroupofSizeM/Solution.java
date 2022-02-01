package findLatestGroupofSizeM;

import java.util.Arrays;
/*
110 / 114
Time limit over
 */
public class Solution {
  public int findLatestStep(int[] arr, int m) {
    int[] state = new int[arr.length];
    int answer = -1;
    int cnt = 0;
    for(int i=1; i<=arr.length; i++) {
      int idx = arr[i-1] -1 ;
      int length = 1;
      int rightIdx = idx;
      int leftIdx = idx;
      if(idx-1>=0 && state[idx-1] >0) {
        length+=state[idx-1];
        leftIdx = idx-state[idx-1];
        if(state[idx-1] == m) {
          cnt--;
        }
      }
      if(idx+1<state.length && state[idx+1] < state.length) {
        length+=state[idx+1];
        rightIdx = idx+state[idx+1];
        if(state[idx+1] == m) {
          cnt--;
        }
      }
      if(length==m) {
        cnt++;
      }
      state[idx] = length;
      Arrays.fill(state, leftIdx, rightIdx+1, length);
      if(cnt>0) {
        answer = Math.max(answer, i);
      }

    }
    return answer;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] arr = {3,5,1,2,4};
    s.findLatestStep(arr,1);
  }
}
