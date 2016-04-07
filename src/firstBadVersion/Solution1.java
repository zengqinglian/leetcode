package firstBadVersion;

public class Solution1 extends VersionControl
{
    // imporve divide to three
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

            if( endSearch - startSearch == 2 ) {
                if( isBadVersion( startSearch ) ) {
                    return startSearch;
                }

                if( isBadVersion( startSearch + 1 ) ) {
                    return startSearch + 1;
                }
                if( isBadVersion( startSearch + 2 ) ) {
                    return startSearch + 2;
                }
            }

            int length = (endSearch - startSearch) / 3;
            int index1 = startSearch + length;
            int index2 = index1 + length;

            if( isBadVersion( index1 ) ) {
                endSearch = index1;
            }

            if( !isBadVersion( index1 ) && isBadVersion( index2 ) ) {
                startSearch = index1;
                endSearch = index2;
            }

            if( !isBadVersion( index2 ) ) {
                startSearch = index2;
            }

        }
    }
}
