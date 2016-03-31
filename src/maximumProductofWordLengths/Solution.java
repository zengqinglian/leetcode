package maximumProductofWordLengths;

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    public int maxProduct( String[] words ) {
        Map<String, int[]> checkList = new HashMap<>();
        int result = 0;
        for( String word : words ) {

            char[] chars = word.toCharArray();

            if( !checkList.isEmpty() ) {

                for( String s : checkList.keySet() ) {
                    int length = s.length();
                    boolean noCommonLetter = true;
                    int[] i = checkList.get( s );
                    for( char c : chars ) {
                        if( i[c - 'a'] == 1 ) {
                            noCommonLetter = false;
                            break;
                        }
                    }
                    if( noCommonLetter ) {
                        result = Math.max( length * chars.length, result );
                    }
                }
            }
            if( checkList.containsKey( word ) ) {
                continue;
            }

            int[] i = new int[26];
            for( char c : chars ) {
                i[c - 'a'] = 1;
            }
            checkList.put( word, i );

        }

        return result;
    }
}
