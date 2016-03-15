package decodeWays;

public class Solution
{
    public int numDecodings( String s ) {
        if( s == null || s.length() == 0 ) {
            return 0;
        }
        int length = s.length();
        int[] result = new int[length];

        if( s.charAt( 0 ) == '0' ) {
            return 0;
        } else {
            result[0] = 1;
        }

        if( s.length() == 1 ) {
            return result[0];
        }

        int firstTwo = Integer.parseInt( s.substring( 0, 2 ) );

        if( s.charAt( 1 ) == '0' ) {
            if( firstTwo == 20 || firstTwo == 10 ) {
                result[1] = 1;
            } else {
                return 0;
            }
        } else {
            if( firstTwo <= 26 && firstTwo >= 10 ) {
                result[1] = 2;
            } else {
                result[1] = 1;
            }
        }

        for( int i = 2; i < length; i++ ) {
            int current = Integer.parseInt( String.valueOf( s.charAt( i ) ) );
            int last = Integer.parseInt( String.valueOf( s.charAt( i - 1 ) ) );
            if( current == 0 ) {
                if( last == 1 || last == 2 ) {
                    result[i] = result[i - 2];
                } else {
                    return 0;
                }
            } else {
                if( Integer.parseInt( s.substring( i - 1, i + 1 ) ) <= 26 && Integer.parseInt( s.substring( i - 1, i + 1 ) ) >= 10 ) {
                    result[i] = result[i - 1] + result[i - 2];
                } else {
                    result[i] = result[i - 1];
                }
            }

        }

        return result[length - 1];

    }
}