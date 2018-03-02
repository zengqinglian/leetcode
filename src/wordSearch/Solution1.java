package wordSearch;

public class Solution1 {

    // 20ms solution - meet avg speed
    private int[] posX = { 1, -1, 0, 0 };
    private int[] posY = { 0, 0, 1, -1 };

    public boolean exist(char[][] board, String word) {
	if (board.length == 0) {
	    return false;
	}

	if (word.length() == 0) {
	    return true;
	}

	boolean[][] tracker = new boolean[board.length][board[0].length];
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[0].length; j++) {
		if (board[i][j] == word.charAt(0)) {
		    if (word.length() == 1) {
			return true;
		    }
		    tracker[i][j] = true;
		    if (check(board, i, j, word, 1, tracker)) {
			return true;
		    }
		    tracker[i][j] = false;
		}
	    }
	}
	return false;
    }

    private boolean check(char[][] board, int x, int y, String word, int index, boolean[][] tracker) {
	if (index == word.length() - 1) {
	    for (int n = 0; n < 4; n++) {
		int newX = posX[n] + x;
		int newY = posY[n] + y;
		if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && !tracker[newX][newY]
			&& board[newX][newY] == word.charAt(index)) {
		    return true;
		}
	    }
	    return false;
	}
	
	for (int n = 0; n < 4; n++) {
	    int newX = posX[n] + x;
	    int newY = posY[n] + y;
	    if (newX >= 0 && newX < board.length && newY >= 0 && newY < board[0].length && !tracker[newX][newY]
		    && board[newX][newY] == word.charAt(index)) {
		tracker[newX][newY] = true;
		if (check(board, newX, newY, word, index + 1, tracker)) {
		    return true;
		}
		tracker[newX][newY] = false;
	    }
	}
	return false;
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'E', 'S' }, { 'A', 'D', 'E', 'E' } };
	s.exist(board, "ABCESEEEFS");
    }
}
