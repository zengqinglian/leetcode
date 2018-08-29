package shortEncodingofWords;

public class Solution {
    // 19ms trie solution - beat 96%
    public int minimumLengthEncoding(String[] words) {
	int result = 0;
	Node root = new Node();
	int wordsCount = 0;
	for (String word : words) {
	    int count = 0;
	    Node cur = root;
	    boolean endingWithExist = false;
	    boolean isInside = true;
	    for (int i = word.length() - 1; i >= 0; i--) {
		char c = word.charAt(i);
		if (cur.nodes[c - 'a'] != null) {
		    if (cur.nodes[c - 'a'].isWord) {
			count = 0;
			cur.nodes[c - 'a'].isWord = false;
			endingWithExist = true;
		    } else {
			count++;
		    }
		} else {
		    if (!endingWithExist) {
			isInside = false;
		    }
		    count++;
		    cur.nodes[c - 'a'] = new Node();
		}
		cur = cur.nodes[c - 'a'];
	    }

	    if (!endingWithExist && !isInside) {
		wordsCount++;
		result += count;
		cur.isWord = true;
	    } else {
		boolean needUpdate = true;
		for (Node node : cur.nodes) {
		    if (node != null) {
			needUpdate = false;
			break;
		    }
		}
		if (needUpdate) {
		    result += count;
		    cur.isWord = true;
		}
	    }
	}
	return result + wordsCount;

    }

    private class Node {
	private Node[] nodes = new Node[26];
	private boolean isWord = false;

	public Node() {
	}

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	// String[] words = { "time", "atime", "abtime" };
	String[] words = { "time", "me", "bell" };
	s.minimumLengthEncoding(words);
    }
}
