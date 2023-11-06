package peakIndexinaMountainArray;
/*
Runtime
0 ms
Beats
100%
Memory
57.3 MB
Beats
10.85%
 */
public class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        if (arr.length ==3) {
            return 1;
        }
        int s =0;
        int e = arr.length-1;
        return helper(arr, s,e);
    }
    private int helper (int[] arr, int s, int e) {
        if (e -s ==1){
            if (arr[e] > arr[s]) {
                return e;
            }else{
                return s;
            }
        }
        int mid = (s+e)/2;
        if (arr[mid]>arr[mid+1]) {
            return helper(arr, s, mid);
        }else{
            return helper(arr, mid,e);
        }
    }
}
