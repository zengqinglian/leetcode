package KthSmallestElementinaSortedMatrix;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int l = matrix.length;
        if(k==1){
            return matrix[0][0];
        }
        if (k == l * l) {
            return matrix[l - 1][l - 1];
        }
        int[] temp = new int[l];

        int found = 1;
        int val = 0;
        temp[0] = 1;
        int currentIndex = 0;
        while (found < k) {
            val = Integer.MAX_VALUE;
            for (int i = 0; i < l; i++) {
                if (temp[i] >= l) {
                    continue;
                } else if (val > matrix[i][temp[i]]) {
                    val = matrix[i][temp[i]];
                    currentIndex = i;
                }
            }
            temp[currentIndex] = temp[currentIndex] + 1;
            found++;
        }

        return val;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        s.kthSmallest(matrix, 8);
    }
}
