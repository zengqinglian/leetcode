package minimizetheDifferenceBetweenTargetandChosenElements;

/*
Runtime: 230 ms, faster than 87.69% of Java online submissions for Minimize the Difference Between Target and Chosen Elements.
Memory Usage: 39.3 MB, less than 78.67% of Java online submissions for Minimize the Difference Between Target and Chosen Elements.
 */
public class Solution1 {
    public int minimizeTheDifference(int[][] mat, int target) {
        boolean[] totalSumArr = null;
        int OverTarget = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;

        for(int i=0; i<mat.length; i++){
            boolean[] sum = new boolean[801];
            int minOverTarget = Integer.MAX_VALUE;
            for(int j=0; j<mat[i].length; j++){
                if(totalSumArr == null){
                    if(i==mat.length-1){
                        res=Math.min(res, Math.abs(mat[i][j]-target));
                    }else{
                        if(mat[i][j]>target){
                            minOverTarget = Math.min(minOverTarget, mat[i][j]);
                        }else {
                            sum[mat[i][j]] = true;
                        }
                    }
                }else{
                    for(int v=1; v<=800; v++){
                        if(totalSumArr[v]) {
                            int newVal = v + mat[i][j];
                            if(i==mat.length-1){
                                res=Math.min(res, Math.abs(newVal-target));
                                if(res==0){
                                    return 0;
                                }
                            }else {
                                if(newVal > target){
                                    minOverTarget = Math.min(minOverTarget, newVal);
                                }else {
                                    sum[newVal]=true;
                                }
                            }
                        }
                    }
                    if(OverTarget!= Integer.MAX_VALUE) {
                        minOverTarget = Math.min(minOverTarget, OverTarget + mat[i][j]);
                        if(i==mat.length-1){
                            res=Math.min(res, Math.abs(OverTarget+mat[i][j]-target));
                        }
                    }
                }
            }
            totalSumArr = sum;
            if(minOverTarget!=Integer.MAX_VALUE){
                OverTarget = minOverTarget;
            }

        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        s.minimizeTheDifference(mat, 13);
    }
}
