package missingNumber;

public class Solution
{
    public int missingNumber( int[] nums ) {
        int length = nums.length;
        int sum = 0;
        for( int i : nums ) {
            sum += i;
        }
        int formulaSum = ((0 + length) * (length + 1)) / 2;
        return formulaSum - sum;
    }
}
