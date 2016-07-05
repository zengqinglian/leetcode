package waterandJugProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution
{

    // 5ms solution
    public boolean canMeasureWater( int x, int y, int z ) {
        if( z == 0 ) {
            return true;
        }
        if( x + y < z ) {
            return false;
        }

        if( x == 0 && y == 0 ) {
            return false;
        } else if( x == 0 && y > z ) {
            return false;
        } else if( y == 0 && x > z ) {
            return false;
        }

        Set<Integer> result = new HashSet<>();

        getPossibleNums( x, y, z, result );

        if( result.contains( 1 ) ) {
            return true;
        }

        List<Integer> list = new ArrayList<>( result );
        Collections.sort( list );

        boolean[] dp = new boolean[z + 1];

        for( int i = 1; i <= z; i++ ) {
            for( int num : list ) {
                if( i == num ) {
                    dp[i] = true;
                    break;
                } else if( i > num && dp[i - num] ) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[z];

    }

    private void getPossibleNums( int x, int y, int z, Set<Integer> result ) {
        if( x == 0 ) {
            if( z % y == 0 ) {
                result.add( 1 );
            }
            return;

        } else if( y == 0 ) {
            if( z % x == 0 ) {
                result.add( 1 );
            }
            return;
        } else {

            if( z % x == 0 || z % y == 0 || x == 1 || y == 1 ) {
                result.add( 1 );
                return;
            }

            if( x != 0 ) {
                result.add( x );
            }
            if( y != 0 ) {
                result.add( y );
            }

            if( x > y && y != 0 ) {
                int mod = x % y;
                if( x / y == 0 ) {
                    if( mod != 0 ) {
                        result.add( mod );
                        return;
                    }
                } else {
                    getPossibleNums( x, mod, z, result );
                    getPossibleNums( y, mod, z, result );
                }
            } else if( x < y && x != 0 ) {
                int mod = y % x;
                if( y / x == 0 ) {
                    if( mod != 0 ) {
                        result.add( mod );
                        return;
                    }
                } else {
                    getPossibleNums( x, mod, z, result );
                    getPossibleNums( y, mod, z, result );
                }
            }
        }
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        s.canMeasureWater( 0, 2, 1 );
    }
}
