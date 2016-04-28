package hIndex;

public class Solution1
{
    // O(n) solution from someone
    public int hIndex( int[] citations ) {
        int n = citations.length;
        if( n < 1 )
            return 0;
        int[] cnt = new int[n + 1];

        for( int i : citations )
            cnt[Math.min( i, n )]++;

        for( int i = n, sum = 0; i >= 0; i-- ) {
            sum += cnt[i];
            if( sum >= i )
                return i;
        }
        return 0;
    }

    public static void main( String[] args ) {
        int[] citations = { 3, 0, 8, 1, 5 };
        Solution1 s = new Solution1();
        s.hIndex( citations );
    }
}
