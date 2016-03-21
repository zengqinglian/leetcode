package countingBits;

public class Solution
{
    public int[] countBits( int num ) {
        int[] ret = new int[num + 1];
        int currentNum = 0;
        int power = 1;
        int dpIndex = 0;
        while( currentNum <= num ) {
            if( currentNum == 0 ) {
                ret[0] = 0;
            }
            if( currentNum == 1 ) {
                ret[1] = 1;
            }
            if( currentNum > 1 ) {
                if( currentNum == Math.pow( 2, power ) ) {
                    dpIndex = 0;
                }
                if( currentNum == Math.pow( 2, power + 1 ) - 1 ) {
                    power++;
                }
                ret[currentNum] = ret[dpIndex] + 1;
                dpIndex++;
            }
            currentNum++;
        }

        return ret;
    }
}
