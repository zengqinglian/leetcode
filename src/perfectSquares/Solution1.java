package perfectSquares;

public class Solution1 {
    // Someone's math solution.
    // ref: here is the Lagrange's Four Square theorem - Limit the result to <=
    // 4:
    // https://en.wikipedia.org/wiki/Lagrange%27s_four-square_theorem
    //
    // And this article, in which you can also find the way to present a number
    // as a sum of four squares:
    // http://www.alpertron.com.ar/4SQUARES.HTM
    public int numSquares(int n) {
        while ((n & 3) == 0) // n%4 == 0
            n >>= 2;
        if ((n & 7) == 7)
            return 4; // n % 8 == 7
        if (isSquare(n))
            return 1;
        int sqrt_n = (int) Math.sqrt(n);
        for (int i = 1; i <= sqrt_n; i++) {
            if (isSquare(n - i * i))
                return 2;
        }
        return 3;
    }

    private boolean isSquare(int n) {
        int temp = (int) Math.sqrt(n);
        return temp * temp == n;
    }
}
