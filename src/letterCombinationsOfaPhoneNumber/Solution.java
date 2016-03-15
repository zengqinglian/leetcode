package letterCombinationsOfaPhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution
{
    public List<String> letterCombinations( String digits ) {
        List<String> returnList = new ArrayList<>();
        if( digits == null || digits.isEmpty() ) {
            return returnList;
        }
        Map<String, String[]> numberLetterMap = new HashMap<>();
        numberLetterMap.put( "0", new String[] { " " } );
        numberLetterMap.put( "2", new String[] { "a", "b", "c" } );
        numberLetterMap.put( "3", new String[] { "d", "e", "f" } );
        numberLetterMap.put( "4", new String[] { "g", "h", "i" } );
        numberLetterMap.put( "5", new String[] { "j", "k", "l" } );
        numberLetterMap.put( "6", new String[] { "m", "n", "o" } );
        numberLetterMap.put( "7", new String[] { "p", "q", "r", "s" } );
        numberLetterMap.put( "8", new String[] { "t", "u", "v" } );
        numberLetterMap.put( "9", new String[] { "w", "x", "y", "z" } );

        Node root = new Node( '$' );
        List<Node> currentChildren = new ArrayList<>();
        currentChildren.add( root );
        for( char c : digits.toCharArray() ) {
            List<Node> newChildren = new ArrayList<>();
            for( Node node : currentChildren ) {
                for( String s : numberLetterMap.get( String.valueOf( c ) ) ) {
                    newChildren.add( node.addNode( new Node( s.charAt( 0 ) ) ) );
                }
            }
            currentChildren.clear();
            currentChildren.addAll( newChildren );

        }
        printAllPathsToLeaf( root, new ArrayList<Character>(), returnList );
        return returnList;

    }

    private void printAllPathsToLeaf( Node node, List<Character> paths, List<String> returnList ) {
        if( node == null )
            return;

        if( node.c != '$' )
            paths.add( node.c );

        if( node.children.isEmpty() ) {
            addToReturnList( paths, returnList );
        }

        for( Node child : node.children ) {
            printAllPathsToLeaf( child, new ArrayList<>( paths ), returnList );
        }
    }

    private void addToReturnList( List<Character> paths, List<String> returnList ) {
        StringBuffer sb = new StringBuffer();
        for( char c : paths ) {
            sb.append( c );
        }
        returnList.add( sb.toString() );
    }

    private class Node
    {
        private char c;
        private List<Node> children = new ArrayList<>();

        public Node( char c ) {
            this.c = c;
        }

        public Node addNode( Node node ) {
            children.add( node );
            return node;
        }
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        System.out.print( s.letterCombinations( "23" ) );
    }
}
