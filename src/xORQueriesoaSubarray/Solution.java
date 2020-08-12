package xORQueriesoaSubarray;

public class Solution {
    //1ms solution. meet avg.
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        for(int i= 1 ; i<arr.length; i++){
            arr[i] = arr[i-1] ^ arr[i];
        }
        for(int i=0; i<queries.length; i++){
            int s = queries[i][0];
            int e = queries[i][1];
            if(s==0) {
                res[i] = arr[e];
            }else{
                res[i] = arr[e] ^ arr[s-1];
            }
        }
        return res;
    }
}
