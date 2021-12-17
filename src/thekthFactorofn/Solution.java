package thekthFactorofn;
/*
Runtime: 1 ms, faster than 61.14% of Java online submissions for The kth Factor of n.
Memory Usage: 35.7 MB, less than 77.15% of Java online submissions for The kth Factor of n.
 */
public class Solution {
    public int kthFactor(int n, int k) {
        if(k==1) {
            return 1;
        }
        boolean[] arr = new boolean[n+1];
        arr[1] = true;
        arr[n] = true;
        for(int i=2; i<=n/2; i++) {
            if(n%i==0){
                arr[i] = true;
                arr[n/i] = true;
            }
        }
        int index = 1;
        while(k>0){
            if(index > n){
                return -1;
            }
            if(arr[index++]) {
                k--;
            }
        }
        return index-1;
    }
}
