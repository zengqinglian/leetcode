package plusOne;

public class Solution
{
    public int[] plusOne( int[] digits ) {

        int length = digits.length;
        int addon = 0;
        digits[length - 1] = digits[length - 1] + 1;
        if( digits[length - 1] >= 10 ) {
            digits[length - 1] = digits[length - 1] - 10;
            addon = 1;
        }

        for( int i = length - 2; i >= 0; i-- ) {
            digits[i] = digits[i] + addon;
            if( digits[i] >= 10 ) {
                digits[i] = digits[i] - 10;
                addon = 1;
            } else {
                addon = 0;
            }
        }

        if( addon == 1 ) {
            int[] newDigits = new int[length + 1];
            newDigits[0] = 1;
            for( int i = 0; i < length; i++ ) {
                newDigits[i + 1] = digits[i];

            }
            return newDigits;
        } else {
            return digits;
        }
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] digits = { 1, 0 };
        s.plusOne( digits );
    }
}
