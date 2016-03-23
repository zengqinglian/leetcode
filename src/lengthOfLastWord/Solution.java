package lengthOfLastWord;

public class Solution
{
    public int lengthOfLastWord( String s ) {
        if( s == null || s.isEmpty() ) {
            return 0;
        }

        String[] strArray = s.split( " " );
        if( strArray.length == 0 ) {
            return 0;
        }
        return strArray[strArray.length - 1].length();

    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        s.lengthOfLastWord( " " );
    }
}