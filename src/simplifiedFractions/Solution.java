package simplifiedFractions;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /*
    Runtime: 15 ms, faster than 100.00% of Java online submissions for Simplified Fractions.
Memory Usage: 39.7 MB, less than 78.21% of Java online submissions for Simplified Fractions.
     */
    public List<String> simplifiedFractions(int n) {
        List<String> res = new ArrayList<>();
        if(n==1){
            return res;
        }
        int[][] marks = new int[n][n+1];

        for(int i=1; i<n; i++){
            for(int j=i+1; j<n+1; j++){
                if(marks[i][j] == 0) {
                    marks[i][j] = 1;
                    res.add(i + "/" +j );
                    marksOther(i, j, n, marks);
                }
            }
        }
        return res;
    }

    private void marksOther(int i, int j, int n, int[][] marks) {
        int times = 2;
        while(i*times<n && j*times<=n){
            marks[i*times][j*times]=1;
            times++;
        }
    }
}
