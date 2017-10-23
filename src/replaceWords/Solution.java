package replaceWords;

import java.util.Arrays;
import java.util.List;

public class Solution {
  // dict will be saved into a trie structure - beat over 50%
  public String replaceWords(List<String> dict, String sentence) {
    Node root = new Node();
    for (String str : dict) {
      addWord(root, str);
    }
    StringBuilder sb = new StringBuilder();
    String[] strs = sentence.split(" ");
    for (String str : strs) {
      sb.append(findRoot(root, str)).append(" ");
    }

    return sb.toString().trim();
  }

  private String findRoot(Node root, String str) {
    Node cur = root;
    StringBuilder sb = new StringBuilder();
    for (char c : str.toCharArray()) {
      if (cur.children[c - 'a'] != null) {
        sb.append(c);
        cur = cur.children[c - 'a'];
        if (cur.isWord) {
          return sb.toString();
        }
      } else {
        return str;
      }
    }
    return str;
  }

  private void addWord(Node root, String word) {
    char c = word.charAt(0);
    int index = c - 'a';
    if (word.length() == 1) {
      if (root.children[index] == null) {
        root.children[index] = new Node();
      }
      root.children[index].isWord = true;
    } else {
      if (root.children[index] == null) {
        root.children[index] = new Node();
      }
      addWord(root.children[index], word.substring(1));
    }
  }

  private static class Node {
    private Node[] children;
    private boolean isWord;

    private Node() {
      isWord = false;
      children = new Node[26];
    }

  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String[] strs = {"a", "aa", "aaa", "aaaa"};
    List<String> dict = Arrays.asList(strs);

    s.replaceWords(dict, "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa");
  }
}
