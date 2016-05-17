package removeInvalidParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution3
{
    // DFS solution with optimizations:
    //
    // Before starting DFS, calculate the total numbers of opening and closing parentheses that need to be removed in the final
    // solution, then these two numbers could be used to speed up the DFS process.
    // Use while loop to avoid duplicate result in DFS, instead of using HashSet.
    // Use count variable to validate the parentheses dynamically.

    public List<String> removeInvalidParentheses( String s ) {
        List<String> res = new ArrayList<>();
        dfs( res, s, 0, new StringBuilder(), 0 );

        return res;
    }

    private void dfs( List<String> res, String s, int start, StringBuilder path, int open ) {
        if( open < 0 )
            return;
        if( !res.isEmpty() && path.length() + s.length() - start < res.get( 0 ).length() )
            return;
        if( start == s.length() ) {
            if( open == 0 && (res.size() == 0 || path.length() == res.get( 0 ).length()) )
                res.add( path.toString() );
            return;
        }

        path.append( s.charAt( start ) );
        if( s.charAt( start ) != '(' && s.charAt( start ) != ')' )
            dfs( res, s, start + 1, path, open );
        else {
            dfs( res, s, start + 1, path, open + (s.charAt( start ) == '(' ? 1 : -1) );
            while( start < s.length() - 1 && s.charAt( start ) == s.charAt( start + 1 ) )
                start++;
        }

        path.deleteCharAt( path.length() - 1 );
        dfs( res, s, start + 1, path, open );
    }
}
