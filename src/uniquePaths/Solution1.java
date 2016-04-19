package uniquePaths;

public class Solution1
{
    // Suppose for a 3x4 matrix, the total steps you need to take is 3+4-2 = 5, so the question turns out to be: in these 5 steps, 2
    // are towards right and 3 steps are towards down. Thus it is a combination question: which 2 steps are to the right and which 3
    // steps are going down? So C52 = 5! / (2! x 3 !) = (5x4)/(2x1) = 10
    public int uniquePaths( int m, int n ) {
        int total = m + n - 2;
        int target = m < n ? m - 1 : n - 1;
        int base = m < n ? n - 1 : m - 1;
        double t1 = 1, t2 = 1;
        for( int i = 1; i <= target; i++ )
            t1 *= i;
        for( int i = total; i > base; i-- )
            t2 *= i;
        return (int) (t2 / t1);
    }
}
