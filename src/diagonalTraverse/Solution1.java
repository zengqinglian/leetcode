package diagonalTraverse;

public class Solution1 {
  // improvement. 8ms solution meet avg speed. beat 50%
  public int[] findDiagonalOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return new int[0];
    }

    int H = matrix.length;
    int L = matrix[0].length;
    int[] result = new int[H * L];

    result[0] = matrix[0][0];
    int index = 1;

    int startY = 0; // L
    int startX = 0; // H

    boolean moveDown = false;

    while (index < result.length) {

      if (!moveDown) {
        if (startX == 0 && startY + 1 < L) {
          startY = startY + 1;
          moveDown = !moveDown;
        } else if (startY + 1 >= L) {
          startX = startX + 1;
          moveDown = !moveDown;
        } else {
          startX = startX - 1;
          startY = startY + 1;
        }
      } else {
        if (startY == 0 && startX + 1 < H) {
          startX = startX + 1;
          moveDown = !moveDown;
        } else if (startX + 1 >= H) {
          startY = startY + 1;
          moveDown = !moveDown;
        } else {
          startX = startX + 1;
          startY = startY - 1;
        }
      }
      result[index] = matrix[startX][startY];
      index++;

    }
    return result;
  }
}
