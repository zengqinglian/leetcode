package findtheMinimumNumberofFibonacciNumbersWhoseSumIsK;

import java.util.TreeSet;
/*
Runtime: 2 ms, faster than 63.44% of Java online submissions for Find the Minimum Number of Fibonacci Numbers Whose Sum Is K.
Memory Usage: 36.3 MB, less than 58.60% of Java online submissions for Find the Minimum Number of Fibonacci Numbers Whose Sum Is K.
 */
public class Solution1 {
    static  TreeSet<Integer> f = new TreeSet<>();
    static {
        f.add(1);
        f.add(2);
        int a = 1;
        int sum = a + f.last();
        while(sum<=1_000_000_000){
            a = f.last();
            f.add(sum);
            sum = a + f.last();
        }
    }
    public int findMinFibonacciNumbers(int k) {
        if(k==1 || k==2 || k==3){
            return 1;
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
}
