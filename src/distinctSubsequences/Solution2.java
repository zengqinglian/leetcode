package distinctSubsequences;

public class Solution2
{
    // someone's beat 100% solution. great thinking
    public int numDistinct( String s, String t ) {
        // arr works as a hash table total 256 ascii code
        int[][] arr = new int[256][t.length() + 1];
        int[] cnt = new int[t.length() + 1];
        cnt[0] = 1;
        char c;
        for( int i = 0; i < t.length(); i++ ) {
            // arr[c] is a list of all the positions character c appears
            // arr[c][0] records how many times character c appears
            c = t.charAt( i );
            arr[c][arr[c][0] + 1] = i + 1;
            arr[c][0]++;
        }
        // DP
        for( char a : s.toCharArray() ) {
            if( arr[a][0] != 0 ) {
                for( int i = arr[a][0]; i > 0; i-- ) {
                    cnt[arr[a][i]] += cnt[arr[a][i] - 1];
                }
            }
        }
        return cnt[t.length()];
    }
}
