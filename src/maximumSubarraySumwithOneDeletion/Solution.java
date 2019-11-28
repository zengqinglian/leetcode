package maximumSubarraySumwithOneDeletion;

public class Solution {
    //Overtime limit solution failed on 31/32
    public int maximumSum(int[] arr) {
        int res = Integer.MIN_VALUE;
        for(int i=0; i<arr.length-1; i++){
            if(arr[i]>=0) {
                int sum = arr[i];
                int min = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    sum += arr[j];
                    min = Math.min(arr[j], min);
                    res = Math.max(res, sum - min);
                    res = Math.max(res, sum);

                }
            }else{
                res = Math.max(res, arr[i]);
            }
        }

        res = Math.max(res, arr[arr.length-1]);

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,-2,0,3};
        s.maximumSum(arr);
    }
}
