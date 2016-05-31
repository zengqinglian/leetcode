package dataStreamasDisjointIntervals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/**
 * Definition for an interval. public class Interval { int start; int end; Interval() { start = 0; end = 0; } Interval(int s, int e)
 * { start = s; end = e; } }
 */
public class SummaryRanges
{

    TreeSet<Integer> sortedSet;

    /** Initialize your data structure here. */
    public SummaryRanges() {
        sortedSet = new TreeSet<>( new Comparator<Integer>() {

            @Override
            public int compare( Integer o1, Integer o2 ) {

                return o1.intValue() - o2.intValue();
            }
        } );
    }

    public void addNum( int val ) {
        sortedSet.add( val );
    }

    public List<Interval> getIntervals() {
        List<Interval> list = new ArrayList<>();
        if( sortedSet.isEmpty() ) {
            return list;
        } else {
            Iterator<Integer> ita = sortedSet.iterator();
            Interval interval = null;
            int previous = -1;
            while( ita.hasNext() ) {
                int number = ita.next();
                if( interval == null ) {
                    interval = new Interval();
                    interval.start = number;
                    previous = number;
                } else {
                    if( number - previous == 1 ) {
                        previous = number;
                    } else {
                        interval.end = previous;
                        list.add( interval );
                        interval = new Interval();
                        interval.start = number;
                        previous = number;
                    }
                }

            }
            interval.end = previous;
            list.add( interval );
            return list;

        }
    }

    public static class Interval
    {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval( int s, int e ) {
            start = s;
            end = e;
        }
    }

    public static void main( String[] args ) {
        SummaryRanges sr = new SummaryRanges();
        sr.addNum( 1 );
        sr.getIntervals();
        sr.addNum( 3 );
        sr.getIntervals();
        sr.addNum( 7 );
        sr.getIntervals();
        sr.addNum( 2 );
        sr.getIntervals();
        sr.addNum( 6 );
        sr.getIntervals();
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such: SummaryRanges obj = new SummaryRanges(); obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */
