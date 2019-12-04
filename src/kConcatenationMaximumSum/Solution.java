package kConcatenationMaximumSum;

public class Solution {
    //4m solution , beat 90%
    int MOD = 1000_000_000 +7;
    public int kConcatenationMaxSum(int[] arr, int k) {
        long res = 0;
        long max_sum = arr[0];
        long sum = arr[0];
        res = Math.max(res, max_sum);
        for(int i=1; i<arr.length; i++){
            sum+=arr[i];
            max_sum = Math.max(max_sum + arr[i], arr[i]);
            res = Math.max(res, max_sum);
        }
        if(k==1){
            return (int)(res%MOD);
        }

        for(int i=0; i<arr.length; i++){
            max_sum = Math.max(max_sum + arr[i], arr[i]);
            res = Math.max(res, max_sum);
        }

        if(sum>0){
            res = sum * (k-2) + res;
        }

        return (int)(res%MOD);

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,2};
        s.kConcatenationMaxSum(arr, 3);
    }
}
