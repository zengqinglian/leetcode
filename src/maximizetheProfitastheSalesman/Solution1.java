package maximizetheProfitastheSalesman;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/*
Time Limit Exceeded
425 / 435 testcases passed
 */
public class Solution1 {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        if (offers.size() ==1) {
            return offers.get(0).get(2);
        }
        Collections.sort(offers, Comparator.comparingInt(a -> a.get(1)));

        int[] dp = new int[offers.size()];
        dp[0] = offers.get(0).get(2);
        for(int i=1; i<offers.size(); i++) {
            dp[i] =  Math.max(dp[i], offers.get(i).get(2));
            for (int j=i-1; j>=0; j--) {
                if (overlap(offers.get(j), offers.get(i))) {
                    dp[i] =  Math.max(dp[i], dp[j]);
                }else{
                    dp[i] = Math.max(dp[i], dp[j] + offers.get(i).get(2));
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }

    private boolean overlap(List<Integer> p1, List<Integer> p2) {
        if (p1.get(1) >= p2.get(0) ) {
            return true;
        }
        return false;
    }
}
