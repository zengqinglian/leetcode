package minimizetheDifferenceBetweenTargetandChosenElements;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
Runtime: 733 ms, faster than 46.21% of Java online submissions for Minimize the Difference Between Target and Chosen Elements.
Memory Usage: 39.2 MB, less than 86.85% of Java online submissions for Minimize the Difference Between Target and Chosen Elements.
*/

public class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        Set<Integer> totalSoFar = null;
        int res = Integer.MAX_VALUE;
        for(int i=0; i<mat.length; i++){
            Set<Integer> sum = new HashSet<>();
            int minOverTarget = Integer.MAX_VALUE;
            for(int j=0; j<mat[i].length; j++){
                if(totalSoFar == null){
                    if(i==mat.length-1){
                        res=Math.min(res, Math.abs(mat[i][j]-target));
                    }else{
                        if(mat[i][j]>target){
                            minOverTarget = Math.min(minOverTarget, mat[i][j]);
                        }else {
                            sum.add(mat[i][j]);
                        }
                    }
                }else{
                    for(int v : totalSoFar){
                        int newVal = v+mat[i][j];
                        if(i==mat.length-1){
                            res=Math.min(res, Math.abs(newVal-target));
                            if(res==0){
                                return 0;
                            }
                        }else {
                            if(newVal > target){
                                minOverTarget = Math.min(minOverTarget, newVal);
                            }else {
                                sum.add(newVal);
                            }
                        }
                    }
                }
            }
            totalSoFar = sum;
            if(minOverTarget!=Integer.MAX_VALUE){
                totalSoFar.add(minOverTarget);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] mat = {{65},{45},{45},{69},{55},{60},{29},{25},{16},{5},{62},{16},{29},{19},{34},{2},{24},{32},{66},{62},{60},{46},{42},{37},{51},{4},{41},{4},{66},{20},{9},{4},{66},{6},{56},{10},{51},{44},{7},{8},{5},{44},{28},{7},{10},{7},{24},{62},{19},{14},{45},{68},{9},{14},{51},{28},{8},{57},{59},{6},{54},{8},{19},{16},{63},{45},{33},{15},{33},{67}};
        s.minimizeTheDifference(mat,800);
    }
}
