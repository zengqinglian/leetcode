package streamOfCharacters;

import java.util.LinkedList;
import java.util.Queue;

//750ms Trie solution , beat 13%
public class StreamChecker {

    Queue<TrieNode> queue;
    TrieNode root;
    public StreamChecker(String[] words) {
	root = new TrieNode();
	for (String s : words) {
	    createTrie(root, s);
	}
	queue = new LinkedList<>();
    }

    private void createTrie(TrieNode root, String s) {
	TrieNode node = root;
	for (char c : s.toCharArray()) {
	    if (node.nodes[c - 'a'] == null) {
		node.nodes[c - 'a'] = new TrieNode();
	    }
	    node = node.nodes[c - 'a'];
	}
	node.isWord = true;
    }

    public boolean query(char letter) {
	int size = queue.size();
	boolean result = false;
	if(root.nodes[letter -'a']!=null) {
	    queue.add(root.nodes[letter - 'a']);
	    if (root.nodes[letter - 'a'].isWord) {
		result = true;
	    }
	}
	for (int i = 0; i < size; i++) {
	    TrieNode node = queue.poll();

	    if (node.nodes[letter - 'a'] != null) {
		queue.add(node.nodes[letter - 'a']);
		if (!result && node.nodes[letter - 'a'].isWord) {
		    result = true;
		}
	    }
	}
	return result;
    }

    private static class TrieNode {
	private TrieNode[] nodes = new TrieNode[26];
	private boolean isWord = false;
    }

    public static void main(String[] args) {
	String[] str = { "abaa", "abaab", "aabbb", "bab", "ab" };
	StreamChecker checker = new StreamChecker(str);
	System.out.println(checker.query('a'));
	System.out.println(checker.query('a'));
	System.out.println(checker.query('b'));
	System.out.println(checker.query('b'));
	System.out.println(checker.query('b'));
	System.out.println(checker.query('a'));

    }
}
/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words); boolean param_1 =
 * obj.query(letter);
 */
