package removeInvalidParentheses;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution1
{
    // accept solution beat 54%
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
            while( index <= sb.length() - 1 && sb.charAt( index ) != '(' ) {
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

        Stack<Character> stack = new Stack<>();
        List<Integer> rightAvailable = new ArrayList<>();
        List<Integer> leftAvailable = new ArrayList<>();

        int leftInvalidNum = 0;
        int rightInvlidNum = 0;

        for( int i = 0; i < newStr.length(); i++ ) {
            if( newStr.charAt( i ) == '(' ) {
                leftAvailable.add( i );
            }

            if( newStr.charAt( i ) == ')' ) {
                rightAvailable.add( i );
            }

            if( newStr.charAt( i ) == '(' ) {
                stack.push( newStr.charAt( i ) );
            } else if( newStr.charAt( i ) == ')' ) {
                if( stack.isEmpty() ) {
                    rightInvlidNum++;
                    stack.push( ')' );
                } else if( stack.peek() == '(' ) {
                    stack.pop();
                } else {
                    rightInvlidNum++;
                    stack.push( ')' );
                }
            }
        }

        if( stack.isEmpty() ) {
            result.add( newStr );
            return result;
        } else {
            leftInvalidNum = stack.size() - rightInvlidNum;

            if( leftInvalidNum != 0 && rightInvlidNum != 0 ) {

                List<List<Integer>> possibleRightCombination = getAllCombination( rightAvailable, rightInvlidNum );
                List<List<Integer>> possibleLeftCombination = getAllCombination( leftAvailable, leftInvalidNum );

                for( List<Integer> l : possibleLeftCombination ) {
                    for( List<Integer> r : possibleRightCombination ) {
                        StringBuilder build = new StringBuilder();
                        for( int i = 0; i < newStr.length(); i++ ) {
                            if( !l.contains( i ) && !r.contains( i ) ) {
                                build.append( newStr.charAt( i ) );
                            }
                        }
                        if( isValid( build.toString() ) && !result.contains( build.toString() ) )
                            result.add( build.toString() );
                    }
                }
            } else if( leftInvalidNum == 0 && rightInvlidNum != 0 ) {
                List<List<Integer>> possibleRightCombination = getAllCombination( rightAvailable, rightInvlidNum );
                for( List<Integer> r : possibleRightCombination ) {
                    StringBuilder build = new StringBuilder();
                    for( int i = 0; i < newStr.length(); i++ ) {
                        if( !r.contains( i ) ) {
                            build.append( newStr.charAt( i ) );
                        }
                    }
                    if( isValid( build.toString() ) && !result.contains( build.toString() ) )
                        result.add( build.toString() );
                }
            } else if( leftInvalidNum != 0 && rightInvlidNum == 0 ) {
                List<List<Integer>> possibleLeftCombination = getAllCombination( leftAvailable, leftInvalidNum );
                for( List<Integer> l : possibleLeftCombination ) {
                    StringBuilder build = new StringBuilder();
                    for( int i = 0; i < newStr.length(); i++ ) {
                        if( !l.contains( i ) ) {
                            build.append( newStr.charAt( i ) );
                        }
                    }
                    if( isValid( build.toString() ) && !result.contains( build.toString() ) )
                        result.add( build.toString() );

                }
            }

            return result;
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

    public static void main( String[] args ) {
        Solution1 s = new Solution1();
        s.removeInvalidParentheses( ")()(" );
    }
}
