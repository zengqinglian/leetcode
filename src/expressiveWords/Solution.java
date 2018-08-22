package expressiveWords;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 5ms solution , meet avg speed , beat 50%
    public int expressiveWords(String S, String[] words) {
	if (S.length() == 0) {
	    return 0;
	}

	if (words.length == 0) {
	    return 0;
	}
	List<Node> list = new ArrayList<>();
	for (char c : S.toCharArray()) {
	    if (list.isEmpty() || list.get(list.size() - 1).c != c) {
		list.add(new Node(c, 1));

	    } else {
		list.get(list.size() - 1).num += 1;
	    }
	}

	int[] index = new int[words.length];
	int result = words.length;
	for (Node n : list) {
	    char c = n.c;
	    int num = n.num;
	    for (int j = 0; j < words.length; j++) {
		int idx = index[j];
		if (idx >= 0) {
		    String word = words[j];
		    if (word.length() - 1 < idx) {
			index[j] = -1;
			result--;
			continue;
		    }
		    if (word.charAt(idx) != c) {
			index[j] = -1;
			result--;
			continue;
		    }
		    idx++;
		    int length = 1;
		    while (idx < word.length()) {
			if (word.charAt(idx) == c) {
			    length++;
			} else {
			    break;
			}
			idx++;
		    }
		    if (num < 3) {
			if (length == num) {
			    index[j] = idx;
			} else {
			    index[j] = -1;
			    result--;
			}
		    } else {
			if (length <= num) {
			    index[j] = idx;
			} else {
			    index[j] = -1;
			    result--;
			}
		    }
		}
	    }
	    
	}
	return result;
    }

    private class Node {
	private char c;
	private int num;

	Node(char c, int num) {
	    this.c = c;
	    this.num = num;
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	String S = "nnnnnnzzzznnnnnnpppppfffff";
	String[] words= {"nzznpf","nnzznnpff","nznpff","nnznnpf","nnznpff","nzznppf","nzznpff","nnzznnppf"};
	s.expressiveWords(S, words);
    }
}
