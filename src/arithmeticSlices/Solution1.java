package arithmeticSlices;

public class Solution1 {
    // improved space O(1)
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length <= 2)
            return 0;
        int count = 0, len = 0;
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2])
                len++;
            else {
                if (len >= 1) {
                    count += len * (len + 1) / 2;
                }
                len = 0;
            }
        }
        if (len >= 1)
            count += len * (len + 1) / 2;
        return count;
    }
}
