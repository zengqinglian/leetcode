package maximumProductofWordLengths;

public class Solution1
// use bit map is faster than use an array.
{
    public int maxProduct( String[] words ) {
        int[] wordBitMap = new int[words.length];
        for( int i = 0; i < words.length; i++ )
            for( char c : words[i].toCharArray() )
                wordBitMap[i] |= (1 << (c - 'a'));
        int max = 0;
        for( int i = 0; i < words.length; i++ )
            for( int j = i + 1; j < words.length; j++ )
                if( (wordBitMap[i] & wordBitMap[j]) == 0 )
                    max = Math.max( max, words[i].length() * words[j].length() );
        return max;
    }
}
