package maximalRectangle;

//timelimt over solution O(n3)
public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        if (matrix[0].length == 0) {
            return 0;
        }
        int result = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result = Math.max(result, calculate(matrix, i, j));
            }
        }

        return result;
    }

    private int calculate(char[][] matrix, int startRowIndex, int startColIndex) {

        if (matrix[startRowIndex][startColIndex] == '0') {
            return 0;
        }
        
        int[][] tempResult = new int[matrix.length][matrix[0].length];
        
        int height = matrix.length;
        int width = matrix[0].length;
        
        int maxHeightIndex = height-1;
        int maxWidthIndex = width-1;

        tempResult[startRowIndex][startColIndex] = 1;

        int diff = 1;

        int max = 1;

        while (startRowIndex + diff <= maxHeightIndex || startColIndex + diff <= maxWidthIndex) {
            for (int i = 0; i <= diff; i++) {
                if (startRowIndex + diff <= maxHeightIndex) {
                    if (i == 0) {
                        if (matrix[startRowIndex + diff][i + startColIndex] == '1') {

                            tempResult[startRowIndex + diff][i
                                    + startColIndex] = tempResult[startRowIndex + diff - 1][i + startColIndex] + 1;

                            max = Math.max(max, tempResult[startRowIndex + diff][i + startColIndex]);

                        }
                    } else if (i + startColIndex <= maxWidthIndex) {
                        if (matrix[startRowIndex + diff][i + startColIndex] == '1') {
                            if (tempResult[startRowIndex + diff - 1][i + startColIndex] > 0
                                    && tempResult[startRowIndex + diff][i + startColIndex - 1] > 0) {
                                tempResult[startRowIndex + diff][i + startColIndex] = (diff + 1) * (i + 1);

                                max = Math.max(max, tempResult[startRowIndex + diff][i + startColIndex]);
                            }
                        }
                    }



                }
                if (startColIndex + diff <= maxWidthIndex) {
                    if (i == 0) {
                        if (matrix[i + startRowIndex][startColIndex + diff] == '1') {
                            tempResult[i + startRowIndex][startColIndex
                                + diff] = tempResult[i + startRowIndex][startColIndex + diff - 1] + 1;
                            max = Math.max(max, tempResult[i + startRowIndex][startColIndex + diff]);
                        }
                    } else if (i + startRowIndex <= maxHeightIndex) {
                        if (matrix[i + startRowIndex][startColIndex + diff] == '1') {
                            if (tempResult[i + startRowIndex - 1][startColIndex + diff] > 0
                                    && tempResult[i + startRowIndex][startColIndex + diff - 1] > 0) {
                                tempResult[i + startRowIndex][startColIndex + diff] = (diff + 1) * (i + 1);
                                max = Math.max(max, tempResult[i + startRowIndex][startColIndex + diff]);
                            }
                        }
                    }
                }
            }

            diff++;
        }

        return max;

    }

    public static void main(String[] args) {
        // ["11111111","11111110","11111110","11111000","01111000"]
        Solution s = new Solution();
        char[][] matrix = { { '1', '1', '1', '1', '1', '1', '1', '1' }, { '1', '1', '1', '1', '1', '1', '1', '0' },
                { '1', '1', '1', '1', '1', '1', '1', '0' }, { '1', '1', '1', '1', '1', '0', '0', '0' },
                { '0', '1', '1', '1', '1', '0', '0', '0' } };
        s.maximalRectangle(matrix);
    }
}
