package singleNumber2;

public class Solution1
{
    // The solution is checking to see how many times a bit is on at a particular position and saving it in the sum variable. Since
    // each number appears three times, except for the one we are looking for then sum % 3 will tell us if the the bit at that
    // location should be on for the number that appears only once.
    //
    // For example, for every number that appears only three times and doesn't share a bit with the number we are looking for the
    // sum will be 3 at that location and the sum % 3 will be 0. If the number that appears once does share a bit at this location
    // with others then sum must be some multiple of 3 plus 1. Since every other number appears three times then sum must be some
    // number n * 3 plus 1 if the number we are searching for shares a bit as well. Thus, sum % 3 will always be 0 or 1.
    //
    // The left shift, just moves the bit back into its proper place to be added to result. Since we right shifted the bit, we have
    // to left shift it again before inserting it into result.
    //
    // So for example, lets say we have an array with [3, 3, 3, 1], the bits look like: 0111 0111 0111 0001
    //
    // For each iteration of the loop: i = 0, sum = 4, sum % 3 = 1 result = 1 i = 1, sum = 3, sum % 3 = 0 result = 1 i = 2, sum = 3,
    // sum % 3 = 0 result = 1 i = 3, sum =3, sum % 3 = 0 result = 1
    //
    // We then return 1 as the result.
    public int singleNumber( int[] nums ) {
        int len = nums.length, result = 0;
        for( int i = 0; i < 32; i++ ) {
            int sum = 0;
            for( int j = 0; j < len; j++ ) {
                sum += (nums[j] >> i) & 1;
            }
            result |= (sum % 3) << i;
        }
        return result;

    }
}
