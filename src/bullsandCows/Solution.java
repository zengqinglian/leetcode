package bullsandCows;

public class Solution
{
    public String getHint( String secret, String guess ) {
        int[] s = new int[10];
        int[] g = new int[10];

        int length = secret.length();
        int index = 0;
        int bulls = 0;
        while( index < length ) {
            char schar = secret.charAt( index );
            char gchar = guess.charAt( index );

            if( schar == gchar ) {
                bulls++;
            } else {
                int i = schar - '0';
                s[i] = s[i] + 1;
                int j = gchar - '0';
                g[j] = g[j] + 1;
            }

            index++;
        }
        int cows = 0;
        for( int i = 0; i < 10; i++ ) {
            cows = cows + Math.min( s[i], g[i] );
        }
        return bulls + "A" + cows + "B";

    }
}