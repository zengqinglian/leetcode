package addBinary;

public class Solution
{
    public String addBinary( String a, String b ) {
        if( a.equals( "0" ) ) {
            return b;
        }

        if( b.equals( "0" ) ) {
            return a;
        }

        int lengthA = a.length();
        int lengthB = b.length();
        int addon = 0;
        int length = Math.max( lengthA, lengthB );

        StringBuilder sb = new StringBuilder();

        int index = 0;

        while( index <= length - 1 ) {
            int da = 0;
            int db = 0;
            if( lengthA - 1 - index >= 0 ) {
                da = a.charAt( lengthA - 1 - index ) - '0';
            }
            if( lengthB - 1 - index >= 0 ) {
                db = b.charAt( lengthB - 1 - index ) - '0';
            }

            if( da + db + addon >= 2 ) {
                sb.insert( 0, da + db + addon - 2 );
                addon = 1;
            } else {
                sb.insert( 0, da + db + addon );
                addon = 0;
            }

            index++;
        }

        if( addon == 1 ) {
            sb.insert( 0, addon );
        }

        return sb.toString();

    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        s.addBinary( "1010", "1011" );
    }
}
