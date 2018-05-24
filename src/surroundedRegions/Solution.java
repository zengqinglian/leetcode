package surroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

// 10ms solution - meet avg speed.
private int[] rm = { 1, -1, 0, 0 };
private int[] cm = { 0, 0, 1, -1 };
public void solve(char[][] board) {
if (board == null) {
return;
}
int rows = board.length;
if (rows <= 1) {
return;
}

int cols = board[0].length;

char[][] tracker = new char[rows][cols];

// first row
checkPos(0, 0, 0, cols - 1, board, tracker);
// last row
checkPos(rows - 1, rows - 1, 0, cols - 1, board, tracker);
// first col
checkPos(1, rows - 2, 0, 0, board, tracker);
// last col
checkPos(1, rows - 2, cols - 1, cols - 1, board, tracker);

for (int r = 0; r < rows; r++) {
for (int c = 0; c < cols; c++) {
if (board[r][c] == 'O' && tracker[r][c] != 'v') {
board[r][c] = 'X';
}
}
}
}

private void checkPos(int rowStart, int rowEnd, int colStart, int colEnd, char[][] board, char[][] tracker) {
for (int r = rowStart; r <= rowEnd; r++) {
for (int c = colStart; c <= colEnd; c++) {
if (board[r][c] == 'O' && tracker[r][c] != 'v') {
Queue<int[]> q = new LinkedList<>();
int[] pos = new int[2];
pos[0] = r;
pos[1] = c;
q.add(pos);
tracker[pos[0]][pos[1]] = 'v';
while (!q.isEmpty()) {
int[] p = q.poll();
for (int i = 0; i < 4; i++) {
int newR = p[0] + rm[i];
int newC = p[1] + cm[i];
if (newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length
&& board[newR][newC] == 'O' && tracker[newR][newC] != 'v') {
int[] newPos = new int[2];
newPos[0] = newR;
newPos[1] = newC;
q.add(newPos);
tracker[newR][newC] = 'v';
}
}
}
}
}
}

}

public static void main(String[] args) {
Solution s = new Solution();
char[][] board = {
{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O' },
{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
{ 'X', 'O', 'O', 'X', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O' },
{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O' },
{ 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
{ 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O' },
{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O' },
{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O' },
{ 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
{ 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
{ 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
{ 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'X' },
{ 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'O', 'X', 'O', 'O' },
{ 'O', 'X', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O' },
{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'X', 'X', 'O', 'O', 'O', 'X', 'O', 'O', 'X', 'O', 'O', 'X' },
{ 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O', 'O',
'O' } };
s.solve(board);

}
}
