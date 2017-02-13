package pacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//First slow solution - over time limit
public class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {

        // two corner ones are always good
        List<int[]> impossibles = new ArrayList<>();
        List<int[]> results = new ArrayList<>();

        if (matrix.length == 0) {
            return results;
        }

        if (matrix.length == 1 && matrix[0].length == 0) {
            return results;
        }
        if (matrix.length == 1 && matrix[0].length == 1) {
            int[] item = { 0, 0 };
            results.add(item);
            return results;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int[] point = { i, j };
                if (checkWater(matrix, point, impossibles, results)) {
                    results.add(point);
                } else {
                    impossibles.add(point);
                }
            }
        }

        return results;

    }

    private boolean checkWater(int[][] matrix, int[] startPoint, List<int[]> imposibles, List<int[]> resutls) {

        for (int[] result : resutls) {
            if (startPoint[0] == result[0] && startPoint[1] == result[1]) {
                return true;
            }
        }

        for (int[] point : imposibles) {
            if (startPoint[0] == point[0] && startPoint[1] == point[1]) {
                return false;
            }
        }

        Stack<int[]> stack = new Stack<>();
        boolean canGoP = false;
        boolean canGoA = false;
        stack.push(startPoint);
        List<int[]> visited = new ArrayList<>();
        visited.add(startPoint);

        while (!stack.isEmpty() && (!canGoP || !canGoA)) {
            int[] point = stack.pop();
            if (point[0] == 0 || point[1] == 0) {
                canGoP = true;
            }
            if (point[0] == matrix.length - 1 || point[1] == matrix[0].length - 1) {
                canGoA = true;
            }
            if (point[0] - 1 >= 0 && matrix[point[0]][point[1]] >= matrix[point[0] - 1][point[1]]) {
                int[] newPoint = { point[0] - 1, point[1] };
                if (!findSameElement(visited, newPoint)) {
                    stack.push(newPoint);
                    visited.add(newPoint);
                }
            }

            if (point[0] + 1 <= matrix.length - 1 && matrix[point[0]][point[1]] >= matrix[point[0] + 1][point[1]]) {
                int[] newPoint = { point[0] + 1, point[1] };
                if (!findSameElement(visited, newPoint)) {
                    stack.push(newPoint);
                    visited.add(newPoint);
                }
            }

            if (point[1] - 1 >= 0 && matrix[point[0]][point[1]] >= matrix[point[0]][point[1] - 1]) {
                int[] newPoint = { point[0], point[1] - 1 };
                if (!findSameElement(visited, newPoint)) {
                    stack.push(newPoint);
                    visited.add(newPoint);
                }
            }

            if (point[1] + 1 <= matrix[0].length - 1 && matrix[point[0]][point[1]] >= matrix[point[0]][point[1] + 1]) {
                int[] newPoint = { point[0], point[1] + 1 };
                if (!findSameElement(visited, newPoint)) {
                    stack.push(newPoint);
                    visited.add(newPoint);
                }
            }
        }

        return canGoP && canGoA;

    }

    private boolean findSameElement(List<int[]> list, int[] target) {
        for (int[] element : list) {
            if (element[0] == target[0] && element[1] == target[1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] matrix = { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1, 4, 5 },
                { 5, 1, 1, 2, 4 } };
        s.pacificAtlantic(matrix);
    }
}
