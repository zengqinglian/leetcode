package maximumSubarraySumwithOneDeletion;

public class Solution3 {
    //dp solution, find out the max of left and right of one element. 5ms, beat 40%
    public int maximumSum(int[] arr) {
        int[] dpL = new int[arr.length];
        int[] dpR = new int[arr.length];
        dpL[0] = arr[0];
        dpR[arr.length-1] = arr[arr.length-1];
        for(int i=1; i<arr.length; i++){
            dpL[i] = Math.max(arr[i], dpL[i-1]+arr[i]);
            dpR[arr.length-i-1] =  Math.max(arr[arr.length-1-i], dpR[arr.length-i]+arr[arr.length-i-1]);
        }
        int res = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            int sum = Math.max(dpL[i],dpR[i]);
            res = Math.max(res, sum);
            boolean check = false;
            sum=0;
            if(i-1>=0){
                sum+=dpL[i-1];
                check=true;
            }
            if(i+1<arr.length){
                sum += dpR[i+1];
                check=true;
            }
            if(check)
                res = Math.max(sum, res);


        }

        return res;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        int[] arr = {-50};
        s.maximumSum(arr);
    }
}
