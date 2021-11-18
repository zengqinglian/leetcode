package thekStrongestValuesinanArray;

import java.util.Arrays;
/*
Runtime: 31 ms, faster than 66.67% of Java online submissions for The k Strongest Values in an Array.
Memory Usage: 52.5 MB, less than 81.48% of Java online submissions for The k Strongest Values in an Array.
 */
public class Solution {
    public int[] getStrongest(int[] arr, int k) {
        int[] res = new int[k];
        Arrays.sort(arr);
        int m = ( arr.length -1 ) / 2;
        int s=0;
        int e=arr.length-1;
        for(int i=0;i<k; i++ ) {
            if(s == m) {
                res[i] = arr[e--];
            } else if (e == m) {
                res[i] = arr[s++];
            }else {
                if (Math.abs(arr[s] - arr[m]) > Math.abs(arr[e] - arr[m])) {
                    res[i] = arr[s++];
                }else if (Math.abs(arr[s] - arr[m]) < Math.abs(arr[e] - arr[m])) {
                    res[i] = arr[e--];
                }else{
                    if(arr[s]>arr[e]) {
                        res[i] = arr[s++];
                    }else{
                        res[i] = arr[e--];
                    }
                }
            }
        }
        return res;
    }
}
