package validTicTacToeState;

public class Solution {
    // valid
    // X == O or X=O+1
    // No body win
    // 5ms solution meeat avg
    public boolean validTicTacToe(String[] board) {
	int[] total = new int[26];

	char top1 = ' ';
	char top2 = ' ';
	char top3 = ' ';

	char mid1 = ' ';
	char mid2 = ' ';
	char mid3 = ' ';

	char bottom1 = ' ';
	char bottom2 = ' ';
	char bottom3 = ' ';

	boolean midcheck = false;

	mid2 = board[1].charAt(1);

	boolean resultX = true;
	boolean resultO = true;

	if (mid2 != ' ') {
	    total[mid2 - 'A'] = total[mid2 - 'A'] + 1;
	    midcheck = true;

	    top2 = board[0].charAt(1);
	    if (top2 != ' ')
		total[top2 - 'A'] = total[top2 - 'A'] + 1;

	    bottom2 = board[2].charAt(1);
	    if (bottom2 != ' ')
		total[bottom2 - 'A'] = total[bottom2 - 'A'] + 1;


	    if (top2 == mid2 && mid2 == bottom2) {
		if (top2 == 'X') {
		    resultX = false;
		} else if (top2 == 'O') {
		    resultO = false;
		}
	    }

	    mid1 = board[1].charAt(0);
	    if (mid1 != ' ')
		total[mid1 - 'A'] = total[mid1 - 'A'] + 1;


	    mid3 = board[1].charAt(2);
	    if (mid3 != ' ')
		total[mid3 - 'A'] = total[mid3 - 'A'] + 1;

	    if (mid1 == mid2 && mid2 == mid3) {
		if (mid1 == 'X') {
		    resultX = false;
		} else if (mid1 == 'O'){
		    resultO = false;
		}
	    }

	    top1 = board[0].charAt(0);
	    if (top1 != ' ')
		total[top1 - 'A'] = total[top1 - 'A'] + 1;


	    bottom3 = board[2].charAt(2);
	    if (bottom3 != ' ')
		total[bottom3 - 'A'] = total[bottom3 - 'A'] + 1;


	    if (top1 == mid2 && mid2 == bottom3) {
		if (top1 == 'X') {
		    resultX = false;
		} else if (top1 == 'O'){
		    resultO = false;
		}
	    }

	    top3 = board[0].charAt(2);
	    if (top3 != ' ')
		total[top3 - 'A'] = total[top3 - 'A'] + 1;


	    bottom1 = board[2].charAt(0);
	    if (bottom1 != ' ')
		total[bottom1 - 'A'] = total[bottom1 - 'A'] + 1;


	    if (top3 == mid2 && mid2 == bottom1) {
		if (top3 == 'X') {
		    resultX = false;
		} else if (top3 == 'O'){
		    resultO = false;
		}
	    }

	}


	if (!midcheck) {
	    top1 = board[0].charAt(0);
	    if (top1 != ' ')
		total[top1 - 'A'] = total[top1 - 'A'] + 1;

	    top3 = board[0].charAt(2);
	    if (top3 != ' ')
		total[top3 - 'A'] = total[top3 - 'A'] + 1;

	    top2 = board[0].charAt(1);
	    if (top2 != ' ')
		total[top2 - 'A'] = total[top2 - 'A'] + 1;

	}


	if (top1 == top2 && top2 == top3) {
	    if (top2 == 'X') {
		resultX = false;
	    } else if (top2 == 'O'){
		resultO = false;
	    }
	}

	if (!midcheck) {

	    mid1 = board[1].charAt(0);
	    if (mid1 != ' ')
		total[mid1 - 'A'] = total[mid1 - 'A'] + 1;

	    bottom1 = board[2].charAt(0);
	    if (bottom1 != ' ')
		total[bottom1 - 'A'] = total[bottom1 - 'A'] + 1;

	}

	if (top1 == mid1 && mid1 == bottom1) {
	    if (top1 == 'X') {
		resultX = false;
	    } else  if (top1 == 'O'){
		resultO = false;
	    }
	}

	if (!midcheck) {

	    bottom2 = board[2].charAt(1);
	    if (bottom2 != ' ')
		total[bottom2 - 'A'] = total[bottom2 - 'A'] + 1;

	    bottom3 = board[2].charAt(2);
	    if (bottom3 != ' ')
		total[bottom3 - 'A'] = total[bottom3 - 'A'] + 1;

	}

	if (bottom1 == bottom2 && bottom3 == bottom1) {
	    if (bottom1 == 'X') {
		resultX = false;
	    } else if (bottom1 == 'O') {
		resultO = false;
	    }
	}

	if (!midcheck) {

	    mid3 = board[1].charAt(2);
	    if (mid3 != ' ')
		total[mid3 - 'A'] = total[mid3 - 'A'] + 1;

	}

	if (top3 == bottom3 && bottom3 == mid3) {
	    if (top3 == 'X') {
		resultX = false;
	    } else if(top3=='O'){
		resultO = false;
	    }
	}
	
	if (total['X' - 'A'] == total['O' - 'A']) {
	    if (!resultX) {
		return false;
	    } else {
		return true;
	    }
	} else if (total['X' - 'A'] == total['O' - 'A'] + 1) {
	    if (!resultO) {
		return false;
	    } else {
		return true;
	    }
	}else {
	    return false;
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	String[] board = { "XXO", " O ", "   " };
	s.validTicTacToe(board);
    }
}
