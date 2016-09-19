package integerReplacement;

public class Solution {
    public int integerReplacement(int n) {
        return getResult(n);
    }

    private int getResult(long n) {
        if (n == 1) {
            return 0;
        }

        if (n % 2 == 0) {
            return 1 + getResult(n / 2);
        } else {
            return 1 + Math.min(getResult(n + 1), getResult(n - 1));
        }
    }
}
