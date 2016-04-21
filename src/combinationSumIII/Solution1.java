package combinationSumIII;

import java.util.ArrayList;
import java.util.List;

public class Solution1
{
    public List<List<Integer>> combinationSum3( int k, int n ) {
        int[] availableNumbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        List<List<Integer>> result = new ArrayList<>();
        getCombinations( availableNumbers, 0, k, n, new ArrayList<Integer>(), result );
        return result;
    }

    private void getCombinations( int[] availableNumbers, int startIndex, int totalK, int sum, List<Integer> temp,
            List<List<Integer>> result ) {
        for( int i = startIndex; i < availableNumbers.length; i++ ) {
            if( temp.size() == totalK - 1 ) {
                if( availableNumbers[i] == sum ) {
                    temp.add( availableNumbers[i] );
                    result.add( temp );
                    return;
                }
            } else if( temp.size() < totalK - 1 ) {
                if( availableNumbers[i] < sum ) {
                    List<Integer> newTemp = new ArrayList<>( temp );
                    newTemp.add( availableNumbers[i] );
                    getCombinations( availableNumbers, i + 1, totalK, sum - availableNumbers[i], newTemp, result );
                }
            }
        }
    }

    public static void main( String[] args ) {
        Solution1 s = new Solution1();
        s.combinationSum3( 3, 9 );
    }
}
