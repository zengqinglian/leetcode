package streamOfCharacters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//someone crate trie back ward, beat 41%
public class StreamChecker1 {

    class Node {
	char val;
	Map<Character, Node> next;
	boolean isLeaf;

	Node(char c) {
	    val = c;
	    next = new HashMap<Character, Node>();
	    isLeaf = false;
	}
    }

    Node head;
    Node cur;
    List<Character> list;
    public StreamChecker1(String[] words) {
	head = new Node('#');
	cur = head;
	list = new ArrayList<Character>();
	for (String s : words) {
	    for (int i = s.length() - 1; i >= 0; i--) {
		char c = s.charAt(i);
		if (!cur.next.containsKey(c)) {
		    cur.next.put(c, new Node(c));
		}
		cur = cur.next.get(c);
	    }
	    cur.isLeaf = true;
	    cur = head;
	}
    }

    public boolean query(char letter) {
	list.add(letter);
	for (int i = list.size() - 1; i >= 0; i--) {
	    char c = list.get(i);
	    if (cur.next.containsKey(c)) {
		cur = cur.next.get(c);
		if (cur.isLeaf) {
		    cur = head;
		    return true;
		}
	    } else {
		cur = head;
		return false;
	    }
	}
	cur = head;
	return false;
    }
}
