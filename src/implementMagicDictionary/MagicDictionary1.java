package implementMagicDictionary;

import java.util.HashMap;
import java.util.Map;

// improvement - use hashMap inside the node to reduce the loop time. it should work when word
// number is small
// speed beat 65%
public class MagicDictionary1 {

  private TreeNode root;

  public MagicDictionary1() {
    root = new TreeNode();
  }

  /** Build a dictionary through a list of words */
  public void buildDict(String[] dict) {
    for (String str : dict) {
      buildTrie(str.toCharArray());
    }
  }

  private void buildTrie(char[] chars) {
    if (chars.length == 0) {
      return;
    }
    TreeNode current = root;
    for (int i = 0; i < chars.length; i++) {
      if (!current.children.containsKey(chars[i])) {
        TreeNode newNode = new TreeNode();
        current.children.put(chars[i], newNode);
      }
      if (i == chars.length - 1) {
        current.children.get(chars[i]).isWord = true;
      }
      current = current.children.get(chars[i]);
    }
  }

  /**
   * Returns if there is any word in the trie that equals to the given word after modifying exactly
   * one character
   */
  public boolean search(String word) {
    return search(word, root, false);
  }

  private boolean search(String word, TreeNode node, boolean allMatch) {
    char c = word.charAt(0);
    if (word.length() == 1) {
      if (allMatch) {
        if (node.children.containsKey(c) && node.children.get(c).isWord) {
          return true;
        }
      } else {
        for (char chr : node.children.keySet()) {
          if (chr != c && node.children.get(chr).isWord) {
            return true;
          }
        }
      }
    } else {
      if (allMatch) {
        if (node.children.get(c) != null) {
          return search(word.substring(1), node.children.get(c), true);
        }
      } else {
        for (char chr : node.children.keySet()) {
          if (chr != c) {
            if (search(word.substring(1), node.children.get(chr), true)) {
              return true;
            }
          } else {
            if (search(word.substring(1), node.children.get(chr), false)) {
              return true;
            }
          }
        }
      }
    }
    return false;
  }


  private static class TreeNode {
    private Map<Character, TreeNode> children = new HashMap<>();
    private boolean isWord;

    public TreeNode() {
      isWord = false;
    }
  }

  public static void main(String[] args) {
    String[] dict =
        {"a", "b", "ab", "abc", "abcabacbababdbadbfaejfoiawfjaojfaojefaowjfoawjfoawj",
            "abcdefghijawefe", "aefawoifjowajfowafjeoawjfaow", "cba", "cas", "aaewfawi", "babcda",
            "bcd", "awefj"};
    MagicDictionary1 md = new MagicDictionary1();
    md.buildDict(dict);
    System.out.print(md.search("aefawoifjowajfowafjeoawjfaow"));
  }
}
