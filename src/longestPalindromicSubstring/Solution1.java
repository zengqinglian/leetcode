package longestPalindromicSubstring;

public class Solution1
{
    public String longestPalindrome( String s ) {
        int length = s.length();
        if( length < 3 ) {
            if( length == 1 ) {
                return s;
            }
            if( length == 2 ) {
                if( s.charAt( 0 ) == s.charAt( 1 ) ) {
                    return s;
                }
            }
        }
        int longest = 0;
        int startIndex = -1;
        int endIndex = -1;
        int index = 1;
        while( index <= length - 1 ) {
            if( index + 1 <= length - 1 && s.charAt( index - 1 ) == s.charAt( index + 1 ) ) {
                int len = 3;
                int si = index - 1;
                int ei = index + 1;
                int shift = 2;
                while( index - shift >= 0 && index + shift <= length - 1 ) {
                    if( s.charAt( index - shift ) == s.charAt( index + shift ) ) {
                        len += 2;
                        si -= 1;
                        ei += 1;
                        shift++;
                    } else {
                        break;
                    }
                }
                if( len > longest ) {
                    longest = len;
                    startIndex = si;
                    endIndex = ei;
                }

            }

            if( s.charAt( index - 1 ) == s.charAt( index ) ) {
                int len = 2;
                int si = index - 1;
                int ei = index;
                int shift = 1;

                while( index - shift - 1 >= 0 && index + shift <= length - 1 ) {
                    if( s.charAt( index - shift - 1 ) == s.charAt( index + shift ) ) {
                        len += 2;
                        shift++;
                        si -= 1;
                        ei += 1;
                    } else {
                        break;
                    }
                }
                if( len > longest ) {
                    longest = len;
                    startIndex = si;
                    endIndex = ei;
                }

            }
            index++;
        }
        return s.substring( startIndex, endIndex + 1 );
    }

    public static void main( String[] args ) {
        Solution1 s = new Solution1();
        s.longestPalindrome( "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth" );

    }
}
