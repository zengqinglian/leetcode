package longestWordinDictionary;

import java.util.Arrays;

public class Solution {
  // Sort the words array by length and use trie to check if any work can be build
  // 110ms beat 10 %
  public String longestWord(String[] words) {
    if (words.length == 0) {
      return "";
    }

    if (words.length == 1) {
      if (words[0].length() == 1) {
        return words[0];
      } else {
        return "";
      }
    }
    Arrays.sort(words, (a, b) -> {
      if (a.length() == b.length()) {
        return a.compareTo(b);
      }
      return a.length() - b.length();
    });

    String result = words[0];
    Node root = new Node();
    for (String s : words) {
      if (checkWord(root, s)) {
        if (s.length() > result.length()) {
          result = s;
        }
      }
    }

    return result;

  }

  private boolean checkWord(Node root, String s) {
    if (s.length() == 1) {
      root.children[s.charAt(0) - 'a'] = new Node();
      return true;
    }
    Node cur = root;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (i == s.length() - 1) {
        cur.children[c - 'a'] = new Node();
      } else {
        if (cur.children[c - 'a'] == null) {
          return false;
        } else {
          cur = cur.children[c - 'a'];
        }
      }
    }
    return true;
  }

  private class Node {
    private Node[] children;

    Node() {
      children = new Node[26];
    }
  }
}
