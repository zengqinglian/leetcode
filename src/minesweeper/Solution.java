package minesweeper;

public class Solution {
    // avg speed. beat 60%
    private int[] loopH = { 0, 0, 1, 1, 1, -1, -1, -1 };
    private int[] loopW = { 1, -1, 0, 1, -1, 0, 1, -1 };
    public char[][] updateBoard(char[][] board, int[] click) {
        int h = board.length;
        int w = board[0].length;
        boolean[][] checked = new boolean[h][w];
        update(board, click[0], click[1], checked);

        return board;
    }

    private void update(char[][] board, int h, int w, boolean[][] checked) {
        checked[h][w] = true;
        if (board[h][w] == 'M') {
            board[h][w] = 'X';
        } else if (board[h][w] == 'E') {
            int mines = 0;
            for (int i = 0; i < loopH.length; i++) {
                if (h + loopH[i] >= 0 && h + loopH[i] < board.length && w + loopW[i] >= 0
                        && w + loopW[i] < board[0].length && board[h + loopH[i]][w + loopW[i]] == 'M') {
                    mines++;
                }
            }
            if (mines > 0) {
                board[h][w] = (char) (mines + 48);
            } else {
                board[h][w] = 'B';
                for (int i = 0; i < loopH.length; i++) {
                    if (h + loopH[i] >= 0 && h + loopH[i] < board.length && w + loopW[i] >= 0
                            && w + loopW[i] < board[0].length && !checked[h + loopH[i]][w + loopW[i]]
                            && board[h + loopH[i]][w + loopW[i]] == 'E') {
                        update(board, h + loopH[i], w + loopW[i], checked);
                    }
                }
            }

        } else {
            return;
        }
    }

}
