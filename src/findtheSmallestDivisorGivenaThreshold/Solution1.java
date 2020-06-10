package findtheSmallestDivisorGivenaThreshold;

public class Solution1 {
    //12ms solution , meet avg
    public int smallestDivisor(int[] nums, int threshold) {
        int i = 1;
        int j = 1;
        for(int n : nums){
            j=Math.max(j, n);
        }

        int mid = (i + j) / 2;
        while(i+1<j){
            mid = (i + j) / 2;
            int res = checkResult(nums, mid);
            if(res == threshold){
                j = mid;
            }else if(res > threshold){
                i = mid;
            }else{
                j = mid;
            }
        }
        int resI = checkResult(nums,i);
        if(resI<=threshold){
            return i;
        }else{
            return j;
        }
    }

    private int checkResult(int[] nums, int mid) {
        int sum = 0;
        for(int n : nums){
            if(n%mid==0){
                sum+=(n/mid);
            }else{
                sum+=(n/mid + 1);
            }
        }
        return sum;
    }

}
