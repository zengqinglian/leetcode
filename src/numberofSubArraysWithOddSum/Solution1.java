package numberofSubArraysWithOddSum;
/*
Runtime: 12 ms, faster than 45.72% of Java online submissions for Number of Sub-arrays With Odd Sum.
Memory Usage: 114.1 MB, less than 16.22% of Java online submissions for Number of Sub-arrays With Odd Sum.
 */
public class Solution1 {
    public int numOfSubarrays(int[] arr) {
        int sumOddsCnt = 0;
        int sumEvenCnt = 0;
        int sum = 0;
        for(int v : arr) {
            sum+=v;
            if(sum%2==0){
                sumEvenCnt++;
                sumEvenCnt %= 1_000_000_007;
            }else{
                sumOddsCnt++;
                sumOddsCnt %= 1_000_000_007;
            }
        }
        int res = ((sumOddsCnt + (int)((sumEvenCnt * 1L) * (sumOddsCnt * 1L) % 1_000_000_007L) % 1_000_000_007));
        return res;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] arr = {1,2,3,4,5};
        s.numOfSubarrays(arr);
    }

}
