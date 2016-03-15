package zigZagConversion;

public class Solution
{
    public String convert( String s, int numRows ) {
        int cols = s.length();

        char[][] resultArray = new char[cols][numRows];
        int rowCounter = 0;
        boolean isGoDown = true;
        for( int i = 0; i < cols; i++ ) {
            resultArray[i][rowCounter] = s.charAt( i );
            if( rowCounter < numRows - 1 && rowCounter >= 0 && isGoDown ) {
                rowCounter++;
            }

            if( rowCounter <= numRows - 1 && rowCounter > 0 && !isGoDown ) {
                rowCounter--;
            }

            if( rowCounter == (numRows - 1) || rowCounter == 0 ) {
                isGoDown = !isGoDown;
            }

        }
        StringBuffer sb = new StringBuffer();
        for( int row = 0; row < numRows; row++ ) {
            for( int col = 0; col < cols; col++ ) {
                if( resultArray[col][row] != '\u0000' ) {
                    sb.append( resultArray[col][row] );
                }
            }
        }
        return sb.toString();
    }
}
