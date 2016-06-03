package peekingIterator;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer>
{
    private Iterator<Integer> iterator;
    private Integer peek;

    public PeekingIterator( Iterator<Integer> iterator ) {
        // initialize any member here.
        this.iterator = iterator;
        if( iterator.hasNext() ) {
            peek = iterator.next();
        } else {
            peek = null;
        }
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer currentPeek = new Integer( peek );

        if( iterator.hasNext() ) {
            peek = iterator.next();
        } else {
            peek = null;
        }
        return currentPeek;
    }

    @Override
    public boolean hasNext() {
        return peek == null ? false : true;
    }

    @Override
    public void remove() {

    }
}
