package longestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;

public class Solution
{
    public int lengthOfLongestSubstring( String s ) {
        HashMap<Character, Integer> map = new HashMap<>();
        if( s == null || s.length() == 0 )
            return 0;
        if( s.length() == 1 )
            return 1;

        int index = 0;
        int longestSoFar = 0;
        int startIndex = -1;
        for( char c : s.toCharArray() ) {
            Integer previousIndex = map.put( c, index );
            if( previousIndex != null ) {
                startIndex = Math.max( startIndex, previousIndex );
            }
            longestSoFar = Math.max( longestSoFar, index - startIndex );

            index++;
        }
        return longestSoFar;
    }
}
