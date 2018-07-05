package slidingPuzzle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Solution {
    // 16ms beat 90%
    public int slidingPuzzle(int[][] board) {
	Set<CheckObject> processed = new HashSet<>();
	Queue<CheckObject> q = new LinkedList<>();
	CheckObject init = new CheckObject(board, null);
	q.add(init);
	int[][] targetArray = { { 1, 2, 3 }, { 4, 5, 0 } };
	int[] zeroPoint = { 1, 2 };
	CheckObject target = new CheckObject(targetArray, zeroPoint);
	int step = 0;

	while (!q.isEmpty()) {
	    int len = q.size();
	    for (int i = 1; i <= len; i++) {
		CheckObject top = q.poll();
		processed.add(top);
		if (top.equals(target)) {
		    return step;
		} else {
		    List<CheckObject> newObjs = generateCheckObj(top);
		    for (CheckObject newObj : newObjs) {
			if (!processed.contains(newObj)) {
			    q.add(newObj);
			}
		    }
		}
	    }
	    step++;
	}

	return -1;
    }

    private List<CheckObject> generateCheckObj(CheckObject top) {
	List<CheckObject> result = new ArrayList<>();
	int[] zero = top.pointZero;
	// up
	if (zero[0] - 1 >= 0) {
	    int[][] newArray = new int[2][3];
	    newArray[0] = Arrays.copyOf(top.array[0], 3);
	    newArray[1] = Arrays.copyOf(top.array[1], 3);

	    int[] newZero = new int[2];
	    newZero[0] = zero[0] - 1;
	    newZero[1] = zero[1];

	    int temp = newArray[newZero[0]][newZero[1]];

	    newArray[newZero[0]][newZero[1]] = 0;
	    newArray[zero[0]][zero[1]] = temp;

	    CheckObject newobj = new CheckObject(newArray, newZero);
	    result.add(newobj);
	}
	// down
	if (zero[0] + 1 < 2) {
	    int[][] newArray = new int[2][3];
	    newArray[0] = Arrays.copyOf(top.array[0], 3);
	    newArray[1] = Arrays.copyOf(top.array[1], 3);

	    int[] newZero = new int[2];
	    newZero[0] = zero[0] + 1;
	    newZero[1] = zero[1];

	    int temp = newArray[newZero[0]][newZero[1]];

	    newArray[newZero[0]][newZero[1]] = 0;
	    newArray[zero[0]][zero[1]] = temp;

	    CheckObject newobj = new CheckObject(newArray, newZero);
	    result.add(newobj);
	}

	// left
	if (zero[1] - 1 >= 0) {
	    int[][] newArray = new int[2][3];
	    newArray[0] = Arrays.copyOf(top.array[0], 3);
	    newArray[1] = Arrays.copyOf(top.array[1], 3);

	    int[] newZero = new int[2];
	    newZero[0] = zero[0];
	    newZero[1] = zero[1] - 1;

	    int temp = newArray[newZero[0]][newZero[1]];

	    newArray[newZero[0]][newZero[1]] = 0;
	    newArray[zero[0]][zero[1]] = temp;

	    CheckObject newobj = new CheckObject(newArray, newZero);
	    result.add(newobj);
	}

	// right
	if (zero[1] + 1 < 3) {
	    int[][] newArray = new int[2][3];
	    newArray[0] = Arrays.copyOf(top.array[0], 3);
	    newArray[1] = Arrays.copyOf(top.array[1], 3);

	    int[] newZero = new int[2];
	    newZero[0] = zero[0];
	    newZero[1] = zero[1] + 1;

	    int temp = newArray[newZero[0]][newZero[1]];

	    newArray[newZero[0]][newZero[1]] = 0;
	    newArray[zero[0]][zero[1]] = temp;

	    CheckObject newobj = new CheckObject(newArray, newZero);
	    result.add(newobj);
	}

	return result;

    }

    private static class CheckObject {
	int[][] array;
	int[] pointZero;

	CheckObject(int[][] array, int[] point) {
	    this.array = array;

	    if (point == null) {
		pointZero = new int[2];
		for (int i = 0; i < 2; i++) {
		    for (int j = 0; j < 3; j++) {
			if (array[i][j] == 0) {
			    pointZero[0] = i;
			    pointZero[1] = j;
			}
		    }
		}
	    } else {
		this.pointZero = point;
	    }
	}

	@Override
	public int hashCode() {
	    return array[0][0] * 1 + array[0][1] * 10 + array[0][2] * 100 + array[1][0] * 1000 + array[1][1] * 10000
		    + array[1][2] * 100000;
	}

	@Override
	public boolean equals(Object obj) {
	    CheckObject other = (CheckObject) obj;
	    return Arrays.equals(this.array[0], other.array[0]) && Arrays.equals(this.array[1], other.array[1]);
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[][] board = { { 3, 2, 4 }, { 1, 5, 0 } };
	s.slidingPuzzle(board);
    }
}
