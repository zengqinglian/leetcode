package findTwoNonOverlappingSubArraysEachWithTargetSum;
/*
Runtime: 16 ms, faster than 56.10% of Java online submissions for Find Two Non-overlapping Sub-arrays Each With Target Sum.
Memory Usage: 91.9 MB, less than 16.10% of Java online submissions for Find Two Non-overlapping Sub-arrays Each With Target Sum.
 */
public class Solution2 {
    public int minSumOfLengths(int[] arr, int target) {
        if(arr.length==1){
            return -1;
        }
        int[] fromHead = new int[arr.length];
        int[] fromTail = new int[arr.length];

        int x = 0;
        int sum = arr[0];
        int y = 1;
        fromHead[0] = arr.length+1;
        while(y<arr.length) {
            if(sum == target) {
                fromHead[y] = Math.min(fromHead[y-1], y-x);
                sum-=arr[x++];
                sum+=arr[y++];
            }else if(sum>target) {
                sum-=arr[x++];
            }else{
                fromHead[y] = fromHead[y-1];
                sum+=arr[y++];
            }
        }

        x = arr.length-1;
        sum = arr[x];
        y = x-1;
        fromTail[x] = arr.length+1;
        while(y>=0) {
            if(sum == target) {
                fromTail[y] = Math.min(fromTail[y+1], x-y);
                sum-=arr[x--];
                sum+=arr[y--];
            }else if(sum>target) {
                sum-=arr[x--];
            }else{
                fromTail[y] = fromTail[y+1];
                sum+=arr[y--];
            }
        }
        int res = arr.length+1;
        for(int i=1; i<arr.length; i++){
            res = Math.min(res, fromHead[i]+fromTail[i-1]);
        }
        if(res >arr.length)
            return -1;
        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] arr = {1,1,1,2,2,2,4,4};
        s.minSumOfLengths(arr, 6);
    }
}
