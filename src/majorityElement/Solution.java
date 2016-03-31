package majorityElement;

public class Solution
{
    // Moore's Voting Algorithm
    public int majorityElement( int[] nums ) {
        int count = 0;
        int majorityElement = nums[0];
        for( int x : nums ) {
            if( x != majorityElement ) {
                count--;
            } else {
                count++;
            }
            if( count == 0 ) {
                majorityElement = x;
                count = 1;
            }
        }
        return majorityElement;
    }
}
