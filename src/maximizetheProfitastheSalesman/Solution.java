package maximizetheProfitastheSalesman;

import java.util.*;

/*
Runtime
143 ms
Beats
39.78%
Memory
80.5 MB
Beats
91.14%
 */
public class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        if (offers.size() ==1) {
            return offers.get(0).get(2);
        }
        Collections.sort(offers, Comparator.comparingInt(a -> a.get(1)));

        int[] dp = new int[offers.size()];
        dp[0] = offers.get(0).get(2);
        for(int i=1; i<offers.size(); i++) {
            dp[i] =  Math.max(dp[i], offers.get(i).get(2));
            dp[i] =  Math.max(dp[i], dp[i-1]);
            int insertPoint = binarySearch(offers, offers.get(i).get(0), 0, i-1);
            if (insertPoint >=0) {
                dp[i] = Math.max(dp[i], dp[insertPoint] + offers.get(i).get(2));
            }
        }
        return dp[dp.length-1];
    }

    private int binarySearch(List<List<Integer>> offers, int key, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            if (offers.get(endIndex).get(1) < key ) {
                return endIndex;
            }else{
                return -1;
            }
        }
        if (startIndex +1 == endIndex) {
            if (offers.get(endIndex).get(1) < key ) {
                return endIndex;
            }else if (offers.get(startIndex).get(1) < key ) {
                return startIndex;
            }else{
                return -1;
            }
        }
        int mid = ( endIndex + startIndex ) /2;
        if (offers.get(mid).get(1) < key)  {
            return binarySearch(offers, key, mid, endIndex);
        }else {
            return binarySearch(offers, key, startIndex, mid);
        }
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        Integer[][] offs = {{1,3,10},{1,3,3},{0,0,1},{0,0,7}};
        List<List<Integer>> offers = new ArrayList<>();
        for (Integer[] off : offs) {
            offers.add(Arrays.asList(off));
        }
        s.maximizeTheProfit(4, offers);
    }

}
