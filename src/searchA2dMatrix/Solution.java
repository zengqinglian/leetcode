package searchA2dMatrix;

public class Solution {
    // 1ms solution , meet avg speed.
    public boolean searchMatrix(int[][] matrix, int target) {
	if (matrix.length == 0) {
	    return false;
	}

	int rowStart = 0;
	int rowEnd = matrix.length - 1;

	while (rowStart < rowEnd) {
	    int mid = (rowStart + rowEnd) / 2;
	    if (mid == rowStart) {
		break;
	    }
	    if (target == matrix[mid][0]) {
		return true;
	    } else if (target < matrix[mid][0]) {
		rowEnd = mid - 1;
	    } else {
		rowStart = mid;
	    }
	}

	if (rowStart == rowEnd) {
	    return checkRows(matrix, rowStart, target);
	} else {
	    return checkRows(matrix, rowStart, target) || checkRows(matrix, rowEnd, target);

	}


    }

    private boolean checkRows(int[][] matrix, int row, int target) {
	int colStart = 0;
	int colEnd = matrix[row].length - 1;

	while (colStart <= colEnd) {
	    if (matrix[row][colStart] == target || matrix[row][colEnd] == target) {
		return true;
	    }

	    int mid = (colStart + colEnd) / 2;

	    if (mid == colStart) {
		if (matrix[row][colStart] == target || matrix[row][colEnd] == target) {
		    return true;
		} else {
		    return false;
		}
	    }

	    if (matrix[row][mid] == target) {
		return true;
	    } else if (matrix[row][mid] > target) {
		colEnd = mid;
	    } else {
		colStart = mid;
	    }
	}

	return false;
    }

    public static void main(String[] args) {
	int[][] matrix = { { 1 } };
	Solution s = new Solution();
	s.searchMatrix(matrix, 1);
    }
}
