package romanToInt;


public class Solution
{
    public int romanToInt( String s ) {
        if( s.length() == 1 )
            return getValue( s.charAt( 0 ) );

        int N = s.length();
        int value = 0;
        int previousValue = 0;
        int currentValue = 0;
        char previousRomainSign = s.charAt( 0 );

        for( int i = 1; i < N; i++ ) {
            previousValue = getValue( previousRomainSign );
            currentValue = getValue( s.charAt( i ) );
            if( previousValue >= currentValue )
                value += previousValue;
            else
                value -= previousValue;
            previousRomainSign = s.charAt( i );
        }
        value += currentValue;
        return value;
    }

    private int getValue( char romainSign ) {
        if( romainSign == 'I' )
            return 1;
        else if( romainSign == 'V' )
            return 5;
        else if( romainSign == 'X' )
            return 10;
        else if( romainSign == 'L' )
            return 50;
        else if( romainSign == 'C' )
            return 100;
        else if( romainSign == 'D' )
            return 500;
        else
            return 1000;
    }
}