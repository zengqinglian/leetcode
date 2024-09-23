package findTheMinimumPossibleSumOfaBeautifulArray;

import java.util.HashSet;
import java.util.Set;
//Time Limit Exceeded
//574 / 577 testcases passed
public class Solution {
    public int minimumPossibleSum(int n, int target) {
        Set<Integer> disallowed = new HashSet<Integer>();
        int totalNum = 0;
        int sum = 0;
        int current = 1;
        while (totalNum < n) {
            if (disallowed.contains(current)) {
                current++;
                continue;
            }
            sum += current;
            sum %= 1000_000_007;
            totalNum++;
            if (target - current >0) {
                disallowed.add(target - current);
            }
            current++;
        }
        return sum;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minimumPossibleSum(39636, 49035);
    }
}
