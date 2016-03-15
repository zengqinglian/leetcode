package longestPalindromicSubstring;

public class Solution
{
    public String longestPalindrome( String s ) {
        String longest = "";
        for( int i = 0; i < s.length(); i++ ) {
            String currentPalindrome = findPalindromeFromCenter( s, i, i );
            if( longest.length() < currentPalindrome.length() ) {
                longest = currentPalindrome;
            }
            if( i + 1 < s.length() ) {
                currentPalindrome = findPalindromeFromCenter( s, i, i + 1 );
                if( longest.length() < currentPalindrome.length() ) {
                    longest = currentPalindrome;
                }
            }
        }

        return longest;
    }

    private String findPalindromeFromCenter( String s, int centerLeftIndex, int centerRightIndex ) {
        String returnString = "";
        if( centerLeftIndex == centerRightIndex && (centerLeftIndex == 0 || centerRightIndex == s.length() - 1) ) {
            returnString = s.substring( centerLeftIndex, centerLeftIndex );
        } else {
            int leftPointer = centerLeftIndex;
            int rightPointer = centerRightIndex;
            while( leftPointer >= 0 && rightPointer < s.length() ) {
                if( s.charAt( leftPointer ) == s.charAt( rightPointer ) ) {
                    returnString = s.substring( leftPointer, rightPointer + 1 );
                } else {
                    break;
                }
                leftPointer--;
                rightPointer++;
            }
        }
        return returnString;

    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        System.out.print( "test=" + s.longestPalindrome( "ababasdfgsdafasrewasdfasfasfasfffffffffffffffffffffffffffffffffffff" ) );
    }
}
