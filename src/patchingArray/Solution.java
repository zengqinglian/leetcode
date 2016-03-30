package patchingArray;

public class Solution
{

    // The question asked for the "minimum number of patches required". In other words, it asked for an optimal solution. Lots of
    // problems involving optimal solution can be solved by dynamic programming and/or greedy algorithm. I started with greedy
    // algorithm which is conceptually easy to design. Typically, a greedy algorithm needs selection of best moves for a subproblem.
    // So what is our best move?
    //
    // Think about this example: nums = [1, 2, 3, 9]. We naturally want to iterate through nums from left to right and see what we
    // would discover. After we encountered 1, we know 1...1 is patched completely. After encountered 2, we know 1...3 (1+2) is
    // patched completely. After we encountered 3, we know 1...6 (1+2+3) is patched completely. After we encountered 9, the smallest
    // number we can get is 9. So we must patch a new number here so that we don't miss 7, 8. To have 7, the numbers we can patch is
    // 1, 2, 3 ... 7. Any number greater than 7 won't help here. Patching 8 will not help you get 7. So we have 7 numbers (1...7) to
    // choose from. I hope you can see number 7 works best here because if we chose number 7, we can move all the way up to 1+2+3+7
    // = 13. (1...13 is patched completely) and it makes us reach n as quickly as possible. After we patched 7 and reach 13, we can
    // consider last element 9 in nums. Having 9 makes us reach 13+9 = 22, which means 1...22 is completely patched. If we still
    // did't reach n, we can then patch 23, which makes 1...45 (22+23) completely patched. We continue until we reach n.
    public int minPatches( int[] nums, int n ) {
        int count = 0, i = 0;
        for( long covered = 0; covered < n; ) {
            if( (i < nums.length && nums[i] > covered + 1) || i >= nums.length ) { // at this moment, we need (covered+1), patch it.
                covered += covered + 1;
                ++count;
            } else {
                covered += nums[i++];
            }
        }
        return count;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] nums = { 1, 5, 10 };

        s.minPatches( nums, 20 );
    }
}
