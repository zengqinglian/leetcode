package waterandJugProblem;

public class Solution1
{
    /*
     * Quote from wiki:
     * 
     * Bézout's identity (also called Bézout's lemma) is a theorem in the elementary theory of numbers:
     * 
     * let a and b be nonzero integers and let d be their greatest common divisor. Then there exist integers x and y such that
     * ax+by=d
     * 
     * In addition, the greatest common divisor d is the smallest positive integer that can be written as ax + by
     * 
     * every integer of the form ax + by is a multiple of the greatest common divisor d. If a or b is negative this means we are
     * emptying a jug of x or y gallons respectively.
     * 
     * Similarly if a or b is positive this means we are filling a jug of x or y gallons respectively.
     * 
     * x = 4, y = 6, z = 8.
     * 
     * GCD(4, 6) = 2
     * 
     * 8 is multiple of 2
     * 
     * so this input is valid and we have:
     * 
     * -1 * 4 + 6 * 2 = 8
     * 
     * In this case, there is a solution obtained by filling the 6 gallon jug twice and emptying the 4 gallon jug once. (Solution.
     * Fill the 6 gallon jug and empty 4 gallons to the 4 gallon jug. Empty the 4 gallon jug. Now empty the remaining two gallons
     * from the 6 gallon jug to the 4 gallon jug. Next refill the 6 gallon jug. This gives 8 gallons in the end)
     * 
     * See wiki:
     * 
     * Bézout's identity
     * 
     * and comments in the code
     */

    // 0ms math solution
    public boolean canMeasureWater( int x, int y, int z ) {
        // limit brought by the statement that water is finallly in one or both buckets
        if( x + y < z )
            return false;
        // case x or y is zero
        if( x == z || y == z || x + y == z )
            return true;

        // get GCD, then we can use the property of Bézout's identity
        return z % GCD( x, y ) == 0;
    }

    public int GCD( int a, int b ) {
        while( b != 0 ) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
