package prisonCellsAfterNDays;

public class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
	if (N == 0) {
	    return cells;
	}

	int[] res = new int[cells.length];
	for (int i = 1; i < cells.length - 1; i++) {
	    if (cells[i - 1] == cells[i + 1]) {
		res[i] = 1;
	    } else {
		res[i] = 0;
	    }
	}
	cells = res;

	int actual = (N - 1) % 28;

	for (int x = 0; x < actual; x++) {
	    res = new int[cells.length];
	    for (int i = 1; i < cells.length - 1; i++) {
		if (cells[i - 1] == cells[i + 1]) {
		    res[i] = 1;
		} else {
		    res[i] = 0;
		}
	    }
	    cells = res;
	}

	return cells;
    }

    public static void main(String[] args) {
	int[] cells = {0,1,0,1,1,0,0,1};
	Solution s = new Solution();
	s.prisonAfterNDays(cells, 35);
    }
}
