package removeInvalidParentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution
{

    // wrong solution - when dealing with deleting )( , won't work
    public List<String> removeInvalidParentheses( String s ) {
        List<String> result = new ArrayList<>();
        int length = s.length();
        String newStr = s;
        StringBuilder sb = new StringBuilder( s );
        if( s.length() == 0 ) {
            result.add( "" );
            return result;
        } else if( s.length() == 1 ) {
            if( s.charAt( 0 ) >= 'a' && s.charAt( 0 ) <= 'z' ) {
                result.add( s );
            } else {
                result.add( "" );
            }
            return result;
        } else {
            // get rid of starting ) and ending ( and ignoring letters
            int index = 0;
            while( sb.length() >= index + 1 && sb.charAt( index ) != '(' ) {
                if( sb.charAt( index ) >= 'a' && sb.charAt( index ) <= 'z' ) {
                    index++;
                } else {
                    sb.deleteCharAt( index );
                }
            }

            index = 1;
            while( sb.length() - index >= 0 && sb.charAt( sb.length() - index ) != ')' ) {
                if( sb.charAt( sb.length() - index ) >= 'a' && sb.charAt( sb.length() - index ) <= 'z' ) {
                    index++;
                } else {
                    sb.deleteCharAt( sb.length() - index );
                }
            }
            newStr = sb.toString();
            length = newStr.length();
        }

        if( length == 0 ) {
            result.add( "" );
            return result;
        } else if( length == 1 ) {
            if( newStr.charAt( 0 ) >= 'a' && newStr.charAt( 0 ) <= 'z' ) {
                result.add( newStr );
            } else {
                result.add( "" );
            }
            return result;
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for( int i = 0; i < length; i++ ) {
            if( newStr.charAt( i ) == '(' ) {
                left.add( i );
            } else if( newStr.charAt( i ) == ')' ) {
                right.add( i );
            }
        }

        int leftCount = left.size();
        int rightCount = right.size();

        if( leftCount == rightCount ) {
            result.add( newStr );
            return result;
        }

        int removeSize = Math.abs( leftCount - rightCount );
        char removeChar = leftCount > rightCount ? '(' : ')';
        List<Integer> availables = null;
        if( removeChar == '(' ) {
            availables = left;
        } else {
            availables = right;
        }

        List<List<Integer>> possibleCombination = getAllCombination( availables, removeSize );

        for( List<Integer> li : possibleCombination ) {
            // delete char
            StringBuilder build = new StringBuilder();
            for( int i = 0; i < newStr.length(); i++ ) {
                if( !li.contains( i ) ) {
                    build.append( newStr.charAt( i ) );
                }
            }
            if( isValid( build.toString() ) && !result.contains( build.toString() ) )
                result.add( build.toString() );
        }

        return result;
    }

    private boolean isValid( String s ) {
        Stack<Character> stack = new Stack<>();
        for( int i = 0; i < s.length(); i++ ) {
            if( s.charAt( i ) == '(' ) {
                stack.push( s.charAt( i ) );
            } else if( s.charAt( i ) == ')' ) {
                if( stack.isEmpty() ) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        if( stack.isEmpty() ) {
            return true;
        } else {
            return false;
        }
    }

    private List<List<Integer>> getAllCombination( List<Integer> availables, int total ) {
        List<List<Integer>> possibleCombination = new ArrayList<>();
        getCombinations( availables, total, 0, new ArrayList<Integer>(), possibleCombination );
        return possibleCombination;
    }

    private void getCombinations( List<Integer> availables, int remain, int startIndex, List<Integer> temp,
            List<List<Integer>> result ) {
        if( remain == 1 ) {
            for( int i = startIndex; i < availables.size(); i++ ) {
                List<Integer> newTemp = new ArrayList<>( temp );
                newTemp.add( availables.get( i ) );
                result.add( newTemp );
            }
        } else if( remain > 1 ) {
            for( int i = startIndex; i <= availables.size() - remain; i++ ) {
                List<Integer> newTemp = new ArrayList<>( temp );
                newTemp.add( availables.get( i ) );
                getCombinations( availables, remain - 1, i + 1, newTemp, result );
            }
        }
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        s.removeInvalidParentheses( "())(((()m)(" );
    }
}
