package firstBadVersion;

/* The isBadVersion API is defined in the parent class VersionControl.
 boolean isBadVersion(int version); */

public class Solution extends VersionControl
{
    public int firstBadVersion( int n ) {
        int startSearch = 1;
        int endSearch = n;
        while( true ) {
            if( endSearch - startSearch == 0 ) {
                return endSearch;
            }
            if( endSearch - startSearch == 1 ) {
                if( isBadVersion( startSearch ) ) {
                    return startSearch;
                }

                if( isBadVersion( endSearch ) ) {
                    return endSearch;
                }
            }
            int halfLength = (endSearch - startSearch) / 2;
            int target = startSearch + halfLength;

            if( isBadVersion( target ) ) {
                endSearch = target;
            } else {
                startSearch = target;
            }
        }
    }
}
