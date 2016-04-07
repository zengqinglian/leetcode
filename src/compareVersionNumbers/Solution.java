package compareVersionNumbers;

public class Solution
{
    public int compareVersion( String version1, String version2 ) {
        String[] numbers1 = version1.split( "\\." );
        String[] numbers2 = version2.split( "\\." );

        int index = 0;

        while( index < numbers1.length && index < numbers2.length ) {
            int number1 = Integer.parseInt( numbers1[index] );
            int number2 = Integer.parseInt( numbers2[index] );

            if( number1 > number2 ) {
                return 1;
            } else if( number1 < number2 ) {
                return -1;
            } else {
                index++;
            }
        }

        if( index == numbers1.length && index == numbers2.length ) {
            return 0;
        } else {
            if( index == numbers1.length ) {
                int totalRemain = 0;
                while( index < numbers2.length ) {
                    totalRemain += Integer.parseInt( numbers2[index] );
                    index++;
                }
                if( totalRemain > 0 ) {
                    return -1;
                } else {
                    return 0;
                }
            } else {
                int totalRemain = 0;
                while( index < numbers1.length ) {
                    totalRemain += Integer.parseInt( numbers1[index] );
                    index++;
                }
                if( totalRemain > 0 ) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        s.compareVersion( "1", "1.1" );
    }
}
