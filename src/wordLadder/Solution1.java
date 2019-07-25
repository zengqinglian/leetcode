package wordLadder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javafx.util.Pair;

//someone's 55 ms solution, beat 60%
public class Solution1 {
    private int L;
    private HashMap<String, ArrayList<String>> allComboDict;

    Solution1() {
      this.L = 0;

      // Dictionary to hold combination of words that can be formed,
      // from any given word. By changing one letter at a time.
      this.allComboDict = new HashMap<String, ArrayList<String>>();
    }

    private int visitWordNode(Queue<Pair<String, Integer>> Q, HashMap<String, Integer> visited,
	    HashMap<String, Integer> othersVisited) {
	Pair<String, Integer> node = Q.remove();
	String word = node.getKey();
	int level = node.getValue();

	for (int i = 0; i < this.L; i++) {

	    // Intermediate words for current word
	    String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

	    // Next states are all the words which share the same intermediate state.
	    for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
		// If at any point if we find what we are looking for
		// i.e. the end word - we can return with the answer.
		if (othersVisited.containsKey(adjacentWord)) {
		    return level + othersVisited.get(adjacentWord);
		}

		if (!visited.containsKey(adjacentWord)) {

		    // Save the level as the value of the dictionary, to save number of hops.
		    visited.put(adjacentWord, level + 1);
		    Q.add(new Pair(adjacentWord, level + 1));
		}
	    }
	}
	return -1;
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

	if (!wordList.contains(endWord)) {
	    return 0;
	}

	// Since all words are of same length.
	this.L = beginWord.length();

	wordList.forEach(word -> {
	    for (int i = 0; i < L; i++) {
		// Key is the generic word
		// Value is a list of words which have the same intermediate generic word.
		String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
		ArrayList<String> transformations = this.allComboDict.getOrDefault(newWord, new ArrayList<String>());
		transformations.add(word);
		this.allComboDict.put(newWord, transformations);
	    }
	});

	// Queues for birdirectional BFS
	// BFS starting from beginWord
	Queue<Pair<String, Integer>> Q_begin = new LinkedList<Pair<String, Integer>>();
	// BFS starting from endWord
	Queue<Pair<String, Integer>> Q_end = new LinkedList<Pair<String, Integer>>();
	Q_begin.add(new Pair(beginWord, 1));
	Q_end.add(new Pair(endWord, 1));

	// Visited to make sure we don't repeat processing same word.
	HashMap<String, Integer> visitedBegin = new HashMap<String, Integer>();
	HashMap<String, Integer> visitedEnd = new HashMap<String, Integer>();
	visitedBegin.put(beginWord, 1);
	visitedEnd.put(endWord, 1);

	while (!Q_begin.isEmpty() && !Q_end.isEmpty()) {

	    // One hop from begin word
	    int ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
	    if (ans > -1) {
		return ans;
	    }

	    // One hop from end word
	    ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
	    if (ans > -1) {
		return ans;
	    }
	}

	return 0;
    }


    public static void main(String[] args) {
	Solution1 s = new Solution1();
	String[] list = { "si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av",
		"sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe",
		"ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if",
		"pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi",
		"os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt",
		"io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye" };
	List<String> wordList = Arrays.asList(list);
	s.ladderLength("qa", "sq", wordList);
    }
}
