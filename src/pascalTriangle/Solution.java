package pascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<List<Integer>> generate( int numRows ) {
        List<List<Integer>> result = new ArrayList<>();
        if( numRows == 0 ) {
            return result;
        } else {
            int currentRow = 1;
            while( currentRow <= numRows ) {
                if( currentRow == 1 ) {
                    List<Integer> li = new ArrayList<>();
                    li.add( 1 );
                    result.add( li );
                } else {
                    int index = result.size() - 1;
                    List<Integer> last = result.get( index );
                    List<Integer> newRow = new ArrayList<>();
                    newRow.add( last.get( 0 ) );
                    if( last.size() > 1 ) {
                        for( int i = 0; i <= last.size() - 2; i++ ) {
                            newRow.add( last.get( i ) + last.get( i + 1 ) );
                        }
                    }
                    newRow.add( last.get( last.size() - 1 ) );

                    result.add( newRow );
                }
                currentRow++;
            }
        }

        return result;

    }

}
