package uniqueBinarySearchTrees;

public class Solution
{
    public int numTrees( int n ) {
        if( n == 0 ) {
            return 0;
        }

        if( n == 1 ) {
            return 1;
        }
        if( n == 2 ) {
            return 2;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;
        result[2] = 2;
        int index = 3;
        while( index <= n ) {
            int total = 0;
            for( int i = 0, j = index - 1; i <= index - 1 && j >= 0; i++, j-- ) {
                total += result[i] * result[j];
            }
            result[index] = total;
            index++;
        }
        return result[n];
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        System.out.print( s.numTrees( 3 ) );
    }

}
