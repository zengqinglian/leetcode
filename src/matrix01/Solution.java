package matrix01;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // 50ms solution beat 90%
    public int[][] updateMatrix(int[][] matrix) {
        boolean[][] viewed = new boolean[matrix.length][matrix[0].length];
        Queue<int[]> queue = new LinkedList<>();
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    int[] pos = { i, j };
                    queue.add(pos);
                    viewed[pos[0]][pos[1]] = true;
                }
            }
        }
        int[] rows = { 1, -1, 0, 0 };
        int[] cols = { 0, 0, 1, -1 };
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                if (pos[0] + rows[i] >= 0 && pos[0] + rows[i] < viewed.length && pos[1] + cols[i] >= 0
                        && pos[1] + cols[i] < viewed[0].length) {
                    int[] newPos = { pos[0] + rows[i], pos[1] + cols[i] };
                    if (!viewed[newPos[0]][newPos[1]]) {
                        queue.add(newPos);
                        result[newPos[0]][newPos[1]] = result[pos[0]][pos[1]] + 1;
                        viewed[newPos[0]][newPos[1]] = true;
                    }
                }
            }
        }

        return result;

    }

    public static void main(String[] args) {
        Solution s = new Solution();

        int[][] matrix = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

        s.updateMatrix(matrix);


    }
}
