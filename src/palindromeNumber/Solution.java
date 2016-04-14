package palindromeNumber;

public class Solution
{
    public boolean isPalindrome( int x ) {
        if( x < 0 ) {
            return false;
        }
        if( x / 10 == 0 ) {
            return true;
        }

        if( x % 10 == 0 ) {
            return false;
        }

        int total = 0;
        int number = x;
        while( number / 10 > 0 ) {
            total = (total + number % 10) * 10;
            number = number / 10;
        }

        return total + number == x;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        s.isPalindrome( 1000021 );
    }
}
