package sumofMutatedArrayClosesttoTarget;

import java.util.Arrays;

public class Solution {
    //4ms solution , beat 50%
    public int findBestValue(int[] arr, int target) {
        int sum = 0;
        for(int v : arr){
            sum+=v;
        }
        Arrays.sort(arr);
        if(sum <= target){
            return arr[arr.length-1];
        }

        int min_sum = arr[0] * arr.length;
        if(min_sum >=target){
            int avg = target / arr.length;
            if(Math.abs(avg * arr.length - target ) <= Math.abs((avg+1) * arr.length - target)){
                return avg;
            }else{
                return avg+1;
            }
        }

        int min_val = arr[0];
        int max_val = arr[arr.length-1];
        int[] sum_arr = new int[arr.length];
        sum_arr[0] = arr[0];
        for(int i=1;i<arr.length; i++){
            sum_arr[i] = sum_arr[i-1] + arr[i];
        }

        int min_diff = Integer.MAX_VALUE;
        int res = Integer.MAX_VALUE;
        while(min_val<max_val){
            int mid_val = (min_val + max_val) / 2;
            int index = Arrays.binarySearch(arr, mid_val);
            if(index<0){
                index = -index-1;
            }
            int newSum = (index-1<0 ? 0 :sum_arr[index-1]) + mid_val * (arr.length - index);
            if(Math.abs(newSum-target) < min_diff){
                min_diff = Math.abs(newSum-target);
                res = mid_val;
            }else if(Math.abs(newSum-target) == min_diff){
                if(res>mid_val){
                    res = mid_val;
                }
            }
            if(mid_val == min_val){
                break;
            }
            if(newSum < target) {
                min_val = mid_val;
            }else{
                max_val = mid_val;
            }
        }
        int index = Arrays.binarySearch(arr, max_val);
        int newSum = (index-1<0 ? 0 :sum_arr[index-1])  + max_val * (arr.length - index);
        if(Math.abs(newSum-target) < min_diff){
            res = max_val;
        }else if(Math.abs(newSum-target) == min_diff){
            if(res>max_val){
                res = max_val;
            }
        }
        return res;


    }

    public static void main(String[] args) {
        int[] arr = {1547,83230,57084,93444,70879};
        Solution s = new Solution();
        s.findBestValue(arr,71237);
    }
}
