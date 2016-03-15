package threeSum;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<List<Integer>> threeSum( int[] nums ) {
        List<Integer> minusNumber = new ArrayList<>();
        List<Integer> plusNumber = new ArrayList<>();
        boolean zeroNumber = false;

        for( int i : nums ) {
            if( i > 0 ) {
                plusNumber.add( i );
            } else if( i < 0 ) {
                minusNumber.add( i );
            } else {
                zeroNumber = true;
            }
        }

        List<List<Integer>> retList = new ArrayList<>();
        for( int i : plusNumber ) {
            for( int j : minusNumber ) {
                if( i + j > 0 ) {
                    // find from minus list
                    List<Integer> restList = new ArrayList<>( minusNumber );
                    restList.remove( new Integer( j ) );
                    for( int p : restList ) {
                        if( i + j + p == 0 ) {
                            List<Integer> list = null;
                            if( p < j ) {
                                list = addToList( p, j, i );

                            } else {
                                list = addToList( j, p, i );
                            }
                            if( !retList.contains( list ) ) {
                                retList.add( list );
                            }
                            break;
                        }
                    }
                } else if( i + j < 0 ) {
                    List<Integer> restList = new ArrayList<>( plusNumber );
                    restList.remove( new Integer( i ) );
                    for( int p : restList ) {
                        if( i + j + p == 0 ) {
                            List<Integer> list = null;
                            if( p > i ) {
                                list = addToList( j, i, p );

                            } else {
                                list = addToList( j, p, i );
                            }
                            if( !retList.contains( list ) ) {
                                retList.add( list );
                            }
                            break;
                        }
                    }
                } else if( zeroNumber ) {
                    List<Integer> list = addToList( j, 0, i );
                    if( !retList.contains( list ) )
                        retList.add( addToList( j, 0, i ) );
                }
            }
        }
        return retList;

    }

    private List<Integer> addToList( int p1, int p2, int p3 ) {
        List<Integer> list = new ArrayList<>();
        list.add( p1 );
        list.add( p2 );
        list.add( p3 );
        return list;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] nums = { -2, 10, -14, 11, 5, -4, 2, 0, -10, -10, 5, 7, -11, 10, -2, -5, 2, 12, -5, 14, -11, -15, -5, 12, 0, 13, 8, 7,
                10, 6, -9, -15, 1, 14, 11, -9, -13, -10, 6, -8, -5, -11, 6, -9, 14, 11, -7, -6, 8, 3, -7, 5, -5, 3, 2, 10, -6, -12,
                3, 11, 1, 1, 12, 10, -8, 0, 8, -5, 6, -8, -6, 8, -12, -14, 7, 9, 12, -15, -12, -2, -4, -4, -12, 6, 7, -3, -6, -14,
                -8, 4, 4, 9, -10, -7, -4, -3, 1, 11, -1, -8, -12, 9, 7, -9, 10, -1, -14, -1, -8, 11, 12, -5, -7 };
        System.out.print( s.threeSum( nums ) );
    }
}
