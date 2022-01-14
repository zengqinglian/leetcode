package findtheWinnerofanArrayGame;
/*
Runtime: 1 ms, faster than 76.97% of Java online submissions for Find the Winner of an Array Game.
Memory Usage: 50.7 MB, less than 69.08% of Java online submissions for Find the Winner of an Array Game.
 */
public class Solution {
    public int getWinner(int[] arr, int k) {
        if(k>=arr.length) {
            int max = -1;
            for(int v : arr) {
                max = Math.max(v, max);
            }
            return max;
        }
        int i = 0;
        int j = 1;
        int max = -1;
        int winningNum = -1;
        int cnt = 0;
        while(i<arr.length && j<arr.length) {
            if(arr[i] < arr[j]) {
                if(winningNum == arr[j]){
                    cnt++;
                }else{
                    winningNum = arr[j];
                    cnt = 1;
                }
                if(cnt == k) {
                    return arr[j];
                }
                max = Math.max(max, arr[j]);
                i = Math.max(i,j) + 1;
            }else {
                if(winningNum == arr[i]){
                    cnt++;
                }else{
                    winningNum = arr[i];
                    cnt = 1;
                }
                if(cnt == k) {
                    return arr[i];
                }
                max = Math.max(max, arr[i]);
                j = Math.max(i,j) + 1;
                if(cnt == k) {
                    return arr[i];
                }
            }
        }
        return max;
    }
}
