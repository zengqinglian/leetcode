package trappingRainWater;

public class Solution
{
    // mid element A is the one smaller than A-1 and A+1;
    // Back track
    public int trap( int[] height ) {
        if( height.length < 3 ) {
            return 0;
        }

        int result = 0;
        int findLeft = -1;
        int depth = 0;

        int currentIndex = 0;
        while( currentIndex < height.length ) {
            if( findLeft == -1 && height[currentIndex] > 0 ) {
                findLeft = currentIndex;
                depth = height[findLeft];
                currentIndex++;
            } else if( findLeft >= 0 && height[currentIndex] < depth ) {
                currentIndex++;
            } else if( findLeft >= 0 && height[currentIndex] >= depth ) {
                for( int i = findLeft + 1; i < currentIndex; i++ ) {
                    result += depth - height[i];
                }
                findLeft = currentIndex;
                depth = height[findLeft];
                currentIndex++;
            } else {
                currentIndex++;
            }
        }

        // back track
        if( findLeft != -1 ) {
            int[] newHeight = new int[height.length - findLeft];
            int index = 0;
            for( int i = height.length - 1; i >= findLeft; i-- ) {
                newHeight[index] = height[i];
                index++;
            }
            result += trap( newHeight );
        }

        return result;

    }

    public static void main( String[] args ) {
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        Solution s = new Solution();
        s.trap( height );
    }
}
