package countandSay;

public class Solution
{
    public String countAndSay( int n ) {
        StringBuilder sb = new StringBuilder();
        char lastChar = 'c';
        int counter = 0;
        int number = n;
        while( number > 0 ) {
            int currentDigit = number % 10;
            char currentChar = (char) (currentDigit + '0');
            if( lastChar == 'c' ) {
                counter++;
            } else if( lastChar == currentChar ) {
                counter++;
            } else {
                sb.insert( 0, String.valueOf( currentChar ) );
                sb.insert( 0, counter );
                counter = 0;
                lastChar = currentChar;
            }

            number = number / 10;
            if( number == 0 ) {
                sb.insert( 0, String.valueOf( currentChar ) );

                sb.insert( 0, counter );
            }
        }

        return sb.toString();
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        s.countAndSay( 1 );
    }
}