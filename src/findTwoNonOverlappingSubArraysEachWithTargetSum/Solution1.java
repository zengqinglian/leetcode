package findTwoNonOverlappingSubArraysEachWithTargetSum;

import java.util.ArrayList;
import java.util.List;

/*
55 / 60 test cases passed.
Status: Time Limit Exceeded
 */
public class Solution1 {
    public int minSumOfLengths(int[] arr, int target) {
        int i=0;
        int j=0;
        int res = 0;
        List<int[]> q = new ArrayList<>();
        while(i<arr.length && j<arr.length){
            if(res<target) {
                res+=arr[j];
                j++;
            }else if (res==target) {
                int len = j-i;
                int[] node = {len, i, j-1};
                q.add(node);
                res-=arr[i];
                i++;
            }else{
                res-=arr[i];
                i++;
            }
        }
        while(res>=target && i<arr.length){
            if(res == target) {
                int len = j - i;
                int[] node = {len, i, j - 1};
                q.add(node);
            }
            res-=arr[i];
            i++;
        }
        if(q.size()<2){
            return -1;
        }
        int total = arr.length+1;
        for(int x=0; x<q.size();x++) {
            for(int y=x+1; y<q.size(); y++){
                if(q.get(x)[2] < q.get(y)[1] || q.get(x)[1] > q.get(y)[2]) {
                    total = Math.min(total,q.get(x)[0] + q.get(y)[0]);
                }
            }
        }
        if(total > arr.length){
            return -1;
        }
        return total;

    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] arr = {7,3,4,7};
        s.minSumOfLengths(arr, 7);
    }
}
