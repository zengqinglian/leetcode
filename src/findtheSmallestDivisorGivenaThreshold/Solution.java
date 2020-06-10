package findtheSmallestDivisorGivenaThreshold;

public class Solution {
    //25ms solution, beat 33%
    public int smallestDivisor(int[] nums, int threshold) {
        int i = 1;
        int j = 1000000;
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

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {962551,933661,905225,923035,990560};
        s.smallestDivisor(nums, 10);
    }
}
