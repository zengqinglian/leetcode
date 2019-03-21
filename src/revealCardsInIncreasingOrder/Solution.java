package revealCardsInIncreasingOrder;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    // 4ms solution , beat 80%
    public int[] deckRevealedIncreasing(int[] deck) {
	int len = deck.length;
	LinkedList<Integer> list = new LinkedList<>();
	LinkedList<Integer> indexOrders = new LinkedList<>();
	for (int i = 0; i < len; i++) {
	    list.add(i);
	}

	boolean remove = true;
	while (!list.isEmpty()) {
	    int v = list.pollFirst();
	    if (remove) {
		indexOrders.add(v);
		remove = false;
	    } else {
		list.add(v);
		remove = true;
	    }
	}

	Arrays.sort(deck);

	int[] res = new int[len];

	for (int i = 0; i < len; i++) {
	    res[indexOrders.pollFirst()] = deck[i];
	}

	return res;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] deck = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	s.deckRevealedIncreasing(deck);
    }

}
