package differentWaystoAddParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    // recursion
    public List<Integer> diffWaysToCompute( String input ) {
        List<Integer> list = new ArrayList<>();
        char[] c = input.toCharArray();
        boolean sign = true;
        for( int i = 0; i < c.length; i++ ) {
            if( c[i] == '-' || c[i] == '+' || c[i] == '*' || c[i] == '/' ) {
                List<Integer> l1 = diffWaysToCompute( input.substring( 0, i ) );
                List<Integer> l2 = diffWaysToCompute( input.substring( i + 1, c.length ) );
                for( int j = 0; j < l1.size(); j++ ) {
                    for( int k = 0; k < l2.size(); k++ ) {
                        switch( c[i] ) {
                            case '-':
                                list.add( l1.get( j ) - l2.get( k ) );
                                break;
                            case '+':
                                list.add( l1.get( j ) + l2.get( k ) );
                                break;
                            case '*':
                                list.add( l1.get( j ) * l2.get( k ) );
                                break;
                            case '/':
                                list.add( l1.get( j ) / l2.get( k ) );
                                break;
                        }
                    }
                }
                sign = false;
            }
        }
        if( sign ) {
            int sum = 0;
            for( char c1 : input.toCharArray() ) {
                sum = sum * 10 + c1 - '0';
            }
            list.add( sum );
        }
        return list;
    }
}
