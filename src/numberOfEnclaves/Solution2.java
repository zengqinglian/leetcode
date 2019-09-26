package numberOfEnclaves;

//6ms recurssion solution , beat 60%
public class Solution2 {
    int[] X = { 1, -1, 0, 0 };
    int[] Y = { 0, 0, 1, -1 };

    public int numEnclaves(int[][] A) {
	int total = 0;
	for (int i = 0; i < A.length; i++) {
	    for (int j = 0; j < A[0].length; j++) {
		if (A[i][j] == 1) {
		    total++;
		}
	    }
	}
	boolean[][] visited = new boolean[A.length][A[0].length];
	int res = 0;
	for (int i = 0; i < A.length; i++) {
	    if (i == 0 || i == A.length - 1) {
		for (int j = 0; j < A[0].length; j++) {
		    if (A[i][j] == 1 && !visited[i][j]) {
			int[] pos = {i,j};
			visited[i][j] = true;
			res += countOnes(pos, visited, A);
		    }
		}
	    }
	    if (A[i][0] == 1 && !visited[i][0]) {
		int[] pos = { i, 0 };
		visited[i][0] = true;
		res += countOnes(pos, visited, A);
	    }
	    
	    if (A[i][A[0].length - 1] == 1 && !visited[i][A[0].length - 1]) {
		int[] pos = { i, A[0].length - 1 };
		visited[i][A[0].length - 1] = true;
		res += countOnes(pos, visited, A);
	    }
	}

	return total - res;

    }

    private int countOnes(int[] pos, boolean visited[][], int[][] A) {
	int count = 1;
	for (int n = 0; n < 4; n++) {
	    int newX = pos[0] + X[n];
	    int newY = pos[1] + Y[n];
	    if (newX >= 0 && newY >= 0 && newX <= A.length - 1 && newY <= A[0].length - 1 && A[newX][newY] == 1
		    && !visited[newX][newY]) {
		int[] newPos = { newX, newY };
		visited[newX][newY] = true;
		count += countOnes(newPos, visited, A);
	    }
	}
	return count;
    }
}
