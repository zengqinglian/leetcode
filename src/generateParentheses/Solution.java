package generateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution
{

    public List<String> generateParenthesis( int n ) {
        List<String> list = new ArrayList<String>();
        generateOneByOne( "", list, n, n );
        return list;
    }

    public void generateOneByOne( String sublist, List<String> list, int left, int right ) {
        if( left > right ) {
            return;
        }
        if( left > 0 ) {
            generateOneByOne( sublist + "(", list, left - 1, right );
        }
        if( right > 0 ) {
            generateOneByOne( sublist + ")", list, left, right - 1 );
        }
        if( left == 0 && right == 0 ) {
            list.add( sublist );
            return;
        }
    }
}
