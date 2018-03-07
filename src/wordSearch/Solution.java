package wordSearch;

import java.util.Stack;

public class Solution {
    // 280ms solution - very slow beat 5%
    public boolean exist(char[][] board, String word) {
	if (board.length == 0) {
	    return false;
	}

	if (word.length() == 0) {
	    return true;
	}

	Stack<Node> stack = new Stack<>();

	char first = word.charAt(0);

	int[] x = { 1, -1, 0, 0 };
	int[] y = { 0, 0, 1, -1 };


	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[0].length; j++) {
		boolean[][] tracker = new boolean[board.length][board[0].length];
		if (board[i][j] == first) {
		    Node node = new Node(i, j, 0, null);
		    stack.push(node);
		    if (0 == word.length() - 1) {
			return true;
		    }
		}
		while (!stack.isEmpty()) {
		    Node curNode = stack.pop();
		    tracker[curNode.posX][curNode.posY] = true;
		    int index = curNode.index + 1;
		    if (index == word.length()) {
			throw new RuntimeException("Algo error!");
		    }
		    char cur = word.charAt(index);
		    boolean trackBack = true;
		    for (int n = 0; n < 4; n++) {
			int newX = curNode.posX + x[n];
			int newY = curNode.posY + y[n];
			if (newX >= 0 && newY >= 0 && newX < board.length && newY < board[0].length
				&& !tracker[newX][newY] && board[newX][newY] == cur) {
			    if (index == word.length() - 1) {
				return true;
			    }
			    Node newNode = new Node(newX, newY, index, curNode);
			    stack.push(newNode);
			    trackBack = false;
			}
		    }

		    if (trackBack && !stack.isEmpty()) {
			Node checkNode = stack.peek();
			while (!checkNode.last.equals(curNode.last)) {
			    tracker[curNode.posX][curNode.posY] = false;
			    curNode = curNode.last;
			}
			tracker[curNode.posX][curNode.posY] = false;
		    }

		}

	    }
	}

	return false;
    }

    private static class Node {
	private int posX;
	private int posY;
	private int index;
	private Node last;

	public Node(int posX, int posY, int index, Node last) {
	    this.posX = posX;
	    this.posY = posY;
	    this.index = index;
	    this.last = last;
	}

	@Override
	public boolean equals(Object obj) {
	    if (this == obj)
		return true;
	    if (obj == null)
		return false;
	    if (getClass() != obj.getClass())
		return false;
	    Node other = (Node) obj;
	    if (index != other.index)
		return false;
	    if (posX != other.posX)
		return false;
	    if (posY != other.posY)
		return false;
	    return true;
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	char[][] board = { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D' } };
	s.exist(board, "AAB");
    }
}
