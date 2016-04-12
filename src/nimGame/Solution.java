package nimGame;

public class Solution
{
    public boolean canWinNim( int n ) {
        if( n <= 3 ) {
            return true;
        }
        if( n % 4 == 0 ) {
            return false;
        } else {
            return true;
        }

    }
}
