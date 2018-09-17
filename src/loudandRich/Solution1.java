package loudandRich;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {
    // someone solution , similar speed.
    public int[] loudAndRich(int[][] richer, int[] quiet) {
	ArrayList<Integer>[] adjList = new ArrayList[quiet.length];

	for (int p = 0; p < quiet.length; p++)
	    adjList[p] = new ArrayList<Integer>();

	for (int r = 0; r < richer.length; r++) {
	    int bigger = richer[r][0];
	    int smaller = richer[r][1];

	    // Edge from smaller to bigger
	    adjList[smaller].add(bigger);
	}

	int[] answer = new int[quiet.length];
	Arrays.fill(answer, -1);
	for (int a = 0; a < answer.length; a++) {
	    answer[a] = findAnswer(a, quiet, adjList, answer);
	}
	return answer;
    }

    // Returning the min quietness node starting at node/person s
    private int findAnswer(int s, int[] quiet, ArrayList<Integer>[] adjList, int[] answer) {
	if (answer[s] != -1)
	    return answer[s];

	int min = s;
	for (Integer child : adjList[s]) {
	    int minInSubtree = findAnswer(child, quiet, adjList, answer);
	    if (quiet[minInSubtree] < quiet[min])
		min = minInSubtree;
	}
	return min;
    }


    public static void main(String[] args) {
	int[][] richer = { { 1, 0 }, { 2, 1 }, { 3, 1 }, { 3, 7 }, { 4, 3 }, { 5, 3 }, { 6, 3 } };
	// int[][] richer = { { 0, 1 }, { 1, 2 } };
	int[] quiet = { 3, 2, 5, 4, 6, 1, 7, 0 };
	Solution1 s = new Solution1();
	s.loudAndRich(richer, quiet);
    }
}
