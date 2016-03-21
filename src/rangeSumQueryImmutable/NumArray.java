package rangeSumQueryImmutable;

public class NumArray
{
    private final int[] sum;

    public NumArray( int[] nums ) {
        sum = new int[nums.length];
        int total = 0;
        for( int index = 0; index < nums.length; index++ ) {
            total += nums[index];
            sum[index] = total;
        }
    }

    /*
     * public int sumRange( int i, int j ) { if( i > numArray.length || j > numArray.length ) { return 0; } int total = 0; for( int
     * index = i; index <= j; index++ ) { total += numArray[index]; } return total; }
     */
    public int sumRange( int i, int j ) {

        if( i == 0 ) {
            return sum[j];
        }
        return sum[j] - sum[i - 1];

    }

}

// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);