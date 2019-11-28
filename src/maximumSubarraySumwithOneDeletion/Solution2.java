package maximumSubarraySumwithOneDeletion;

public class Solution2 {
    //someone's pass solution ----- Kadane's algorithm
    public int maximumSum(int[] arr) {
        int N=arr.length, sum_with_delete=arr[0], sum_without_delete=arr[0], result=Integer.MIN_VALUE;
        if(N==1){
            return arr[0];
        }

        for(int i=1;i<N;i++){
            int sum_without_delete_temp=Math.max(sum_without_delete+arr[i], arr[i]);
            sum_with_delete=Math.max(sum_without_delete, sum_with_delete+arr[i]);
            sum_without_delete=sum_without_delete_temp;

            result=Math.max(result, Math.max(sum_with_delete, sum_without_delete));
        }

        return result;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] arr = {8,-1,6,-7,-4,5,-4,7,-6};
        s.maximumSum(arr);
    }
}
