package findtheMinimumNumberofFibonacciNumbersWhoseSumIsK;

import java.util.TreeSet;

/*
Runtime: 4 ms, faster than 25.00% of Java online submissions for Find the Minimum Number of Fibonacci Numbers Whose Sum Is K.
Memory Usage: 38.6 MB, less than 6.18% of Java online submissions for Find the Minimum Number of Fibonacci Numbers Whose Sum Is K.
 */
public class Solution {
    public int findMinFibonacciNumbers(int k) {
        if(k==1 || k==2 || k==3){
            return 1;
        }
        TreeSet<Integer> f = new TreeSet<>();
        f.add(1);
        f.add(2);
        int a = 1;
        int sum = a + f.last();
        while(sum<=k){
            a = f.last();
            f.add(sum);
            sum = a + f.last();
        }
        int cnt = 0;
        while(k>1){
            k=k-f.floor(k);
            cnt++;
        }
        if(k==1){
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findMinFibonacciNumbers(19);
    }
}
