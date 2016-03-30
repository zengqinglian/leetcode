package verifyPreorderSerializationofaBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution
{
    public boolean isValidSerialization( String preorder ) {
        if( preorder == null ) {
            return false;
        }

        String[] nodes = preorder.split( "," );

        int total = nodes.length;

        if( total == 0 ) {
            return false;
        }

        if( total == 1 && nodes[0].equals( "#" ) ) {
            return false;
        }

        Queue<String> checkStack = new LinkedList<>();

        checkStack.add( nodes[0] );

        int index = 1;
        int counter = 0;

        while( !checkStack.isEmpty() ) {
            if( !checkStack.poll().equals( "#" ) ) {
                if( index < total ) {
                    checkStack.add( nodes[index] );
                    index++;
                } else {
                    return false;
                }

                if( index < total ) {
                    checkStack.add( nodes[index] );
                    index++;
                } else {
                    return false;
                }

                counter++;

            } else {
                counter++;
            }
        }

        if( counter == total ) {
            return true;
        } else {
            return false;
        }
    }
}