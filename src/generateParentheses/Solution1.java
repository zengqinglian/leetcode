package generateParentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution1
{

    public List<String> generateParenthesis( int n ) {
        TreeNode root = new TreeNode( '(' );
        List<String> retList = new ArrayList<>();
        if( n < 1 ) {
            return retList;
        } else if( n == 1 ) {
            retList.add( "()" );
            return retList;
        }

        List<TreeNode> currentChildren = new ArrayList<>();
        currentChildren.add( root );
        for( int i = 2; i <= 2 * n; i++ ) {
            List<TreeNode> cpCurrentChildren = new ArrayList<>( currentChildren );
            currentChildren.clear();
            for( TreeNode node : cpCurrentChildren ) {
                TreeNode left = new TreeNode( '(' );
                TreeNode right = new TreeNode( ')' );
                node.left = left;
                node.right = right;

                currentChildren.add( left );
                currentChildren.add( right );
            }
        }

        printTreePath( root, new ArrayList<Character>(), retList );
        return retList;
    }

    private void printTreePath( TreeNode node, List<Character> paths, List<String> returnList ) {
        if( node == null ) {
            return;
        }
        paths.add( node.val );

        if( node.left == null && node.right == null ) {
            addtoReturnList( paths, returnList );
            return;
        }
        printTreePath( node.left, new ArrayList<Character>( paths ), returnList );
        printTreePath( node.right, new ArrayList<Character>( paths ), returnList );
    }

    private void addtoReturnList( List<Character> paths, List<String> returnList ) {
        Stack<Character> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for( char c : paths ) {
            sb.append( c );
            if( c == '(' ) {
                stack.push( c );
            } else if( c == ')' ) {
                if( !stack.isEmpty() ) {
                    stack.pop();
                } else {
                    return;
                }
            }
        }
        if( stack.isEmpty() ) {
            returnList.add( sb.toString() );
        }
    }

    private static class TreeNode
    {
        char val;
        TreeNode left;
        TreeNode right;

        public TreeNode( char val ) {
            this.val = val;
        }
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        System.out.print( s.generateParenthesis( 3 ) );
    }
}
