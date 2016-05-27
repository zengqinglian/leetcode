package distinctSubsequences;

public class Solution1
{
    // someone's dp solution. easier
    public int numDistinct( String s, String t ) {
        if( t.length() == 0 )
            return 1;
        if( s.length() == 0 )
            return 0;
        int[] res = new int[t.length() + 1];
        res[0] = 1;

        for( int i = 0; i < s.length(); i++ )
            for( int j = t.length() - 1; j >= 0; j-- )
                res[j + 1] = (s.charAt( i ) == t.charAt( j ) ? res[j] : 0) + res[j + 1];

        return res[t.length()];
    }
}
