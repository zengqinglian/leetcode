package differentWaystoAddParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution1
{
    // 3ms Cocke–Younger–Kasami algorithm (DP), java
    // https://www.youtube.com/watch?v=b98Uyj7JHIU
    List<List<List<Integer>>> table = new ArrayList<List<List<Integer>>>();
    List<Character> op = new ArrayList<Character>();

    public List<Integer> diffWaysToCompute( String input ) {
        int pre = 0;
        for( int i = 0; i <= input.length(); i++ ) {
            if( i == input.length() || isOperation( input.charAt( i ) ) ) {
                if( i < input.length() ) {
                    op.add( input.charAt( i ) );
                }
                int num = Integer.parseInt( input.substring( pre, i ) );
                List<List<Integer>> row = null;
                if( pre == 0 ) {
                    row = new ArrayList<List<Integer>>();
                } else {
                    row = new ArrayList<List<Integer>>( table.get( table.size() - 1 ) );
                    // we only need its size of previous row, and we don't use the values.
                }
                List<Integer> cell = new ArrayList<Integer>();
                cell.add( num );
                row.add( cell );
                table.add( row );
                pre = i + 1;
            }
        }
        int tableSize = table.size();
        for( int col = 1; col < tableSize; col++ ) {
            for( int row = 0; row < tableSize - col; row++ ) {
                fillTheCell( row, row + col );
            }
        }
        return table.get( 0 ).get( tableSize - 1 );
    }

    public void fillTheCell( int row, int col ) {
        List<Integer> cell = new ArrayList<Integer>();
        for( int i = row; i < col; i++ ) {
            for( int num1 : table.get( row ).get( i ) ) {
                for( int num2 : table.get( i + 1 ).get( col ) ) {
                    cell.add( eval( num1, num2, op.get( i ) ) );
                }
            }
        }
        table.get( row ).add( cell );
    }

    private int eval( int num1, int num2, char op ) {
        if( op == '+' ) {
            return num1 + num2;
        } else if( op == '-' ) {
            return num1 - num2;
        }
        return num1 * num2;
    }

    private boolean isOperation( char op ) {
        return op == '+' || op == '-' || op == '*';
    }
}
