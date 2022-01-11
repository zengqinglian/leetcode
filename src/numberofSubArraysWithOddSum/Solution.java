package numberofSubArraysWithOddSum;

import java.util.ArrayList;
import java.util.List;
/*
Time limit over
141 / 151 test cases passed.
 */
public class Solution {
    public int numOfSubarrays(int[] arr) {
        List<Integer> oddsIndex = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {
            if(arr[i]%2==1){
                oddsIndex.add(i);
            }
        }
        if(oddsIndex.isEmpty()) {
            return 0;
        }
        int res = 0;
        for(int i=0; i<oddsIndex.size(); i++ ) {
            int headEvenCnt;
            if(i-1<0) {
                headEvenCnt = oddsIndex.get(i);
            }else{
                headEvenCnt = oddsIndex.get(i)-oddsIndex.get(i-1)-1;
            }
            for(int j=i; j<oddsIndex.size(); j=j+2) {
                int tailEvenCnt;
                if(j+1>oddsIndex.size()-1) {
                    tailEvenCnt = arr.length - oddsIndex.get(j)-1;
                }else{
                    tailEvenCnt = oddsIndex.get(j+1) - oddsIndex.get(j)-1;
                }
                int temp = ((headEvenCnt+1) * (tailEvenCnt + 1)) % 1_000_000_007;
                res += temp;
                res%=1_000_000_007;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,2,3,4,5};
        s.numOfSubarrays(arr);
    }
}
