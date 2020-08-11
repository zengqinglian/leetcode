package jumpGameIII;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //3ms solution, beat 7%
    public boolean canReach(int[] arr, int start) {
        if(arr[start]==0){
            return true;
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] marker = new boolean[arr.length];
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                q.add(i);
                marker[i] = true;
            }
        }

        while(!q.isEmpty()){
            int p = q.poll();
            for(int i=0; i<arr.length; i++){
                if(marker[i]){
                    continue;
                }
                int indexRight = i + arr[i];
                int indexLeft = i-arr[i];
                if(indexLeft>=0 && indexLeft == p){
                    q.add(i);
                    marker[i]=true;
                    if(i == start){
                        return true;
                    }
                }

                if(indexRight<arr.length && indexRight == p){
                    q.add(i);
                    marker[i]=true;
                    if(i == start){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {4,2,3,0,3,1,2};
        s.canReach(arr, 5);
    }
}
