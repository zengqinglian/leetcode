package sumofTwoIntegers;

public class Solution
{
    // be careful of the Integer min and max case.
    public int getSum( int a, int b ) {
        if( b > 0 ) {
            for( int i = 1; i <= b; i++ ) {
                a++;
            }
        } else if( b < 0 ) {
            for( int i = b; i <= -1; i++ ) {
                a--;
            }
        }

        return a;
    }
}
