package flattenNestedListIterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer>
{
    private Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator( List<NestedInteger> nestedList ) {
        int size = nestedList.size();
        for( int i = size - 1; i >= 0; i-- ) {
            stack.push( nestedList.get( i ) );
        }
    }

    public Integer next() {

        NestedInteger current = stack.pop();
        //
        // while( current != null && !current.isInteger() ) {
        // List<NestedInteger> list = current.getList();
        // int size = list.size();
        // for( int i = size - 1; i >= 0; i-- ) {
        // stack.push( list.get( i ) );
        // }
        // if( stack.isEmpty() ) {
        // break;
        // }
        // current = stack.pop();
        // }

        return current.getInteger();
    }

    public boolean hasNext() {

        if( stack.isEmpty() ) {
            return false;
        }

        NestedInteger next = null;
        while( !stack.isEmpty() ) {
            next = stack.peek();
            if( next.isInteger() ) {
                return true;
            } else {
                stack.pop();
                List<NestedInteger> list = next.getList();
                int size = list.size();
                for( int i = size - 1; i >= 0; i-- ) {
                    stack.push( list.get( i ) );
                }
            }
        }

        return false;
    }

    @Override
    public void remove() {
        // TODO Auto-generated method stub

    }
}
