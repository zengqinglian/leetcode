package implementMagicDictionary;

public class MagicDictionary {
  // trie solution - beat 20% only.
  /** Initialize your data structure here. */

  private Node root;

  public MagicDictionary() {
    root = new Node();
  }

  /** Build a dictionary through a list of words */
  public void buildDict(String[] dict) {
    for (String s : dict) {
      buildTrie(s.toCharArray());
    }
  }

  private void buildTrie(char[] chars) {
    if (chars.length == 0) {
      return;
    }
    Node current = root;
    for (int i = 0; i < chars.length; i++) {
      int index = chars[i] - 'a';
      if (current.children[index] == null) {
        Node newNode = new Node();
        current.children[index] = newNode;
      }
      if (i == chars.length - 1) {
        current.children[index].isWord = true;
      }
      current = current.children[index];
    }
  }

  /**
   * Returns if there is any word in the trie that equals to the given word after modifying exactly
   * one character
   */
  public boolean search(String word) {
    return search(word, root, false);
  }

  private boolean search(String word, Node node, boolean allMatch) {
    if (word.length() == 1) {
      if (allMatch) {
        if (node.children[word.charAt(0) - 'a'] != null
            && node.children[word.charAt(0) - 'a'].isWord) {
          return true;
        }
      } else {
        for (int i = 0; i < 26; i++) {
          if (i != (word.charAt(0) - 'a')) {
            if (node.children[i] != null && node.children[i].isWord) {
              return true;
            }
          }
        }
      }
    } else {
      if (allMatch) {
        Node n = node.children[word.charAt(0) - 'a'];
        if (n != null) {
          return search(word.substring(1), n, true);
        }
      } else {
        for (int i = 0; i < 26; i++) {
          if (i != (word.charAt(0) - 'a')) {
            if (node.children[i] != null) {
              if (search(word.substring(1), node.children[i], true)) {
                return true;
              }
            }
          } else {
            if (node.children[i] != null) {
              if (search(word.substring(1), node.children[i], false)) {
                return true;
              }
            }
          }
        }
      }
    }

    return false;
  }


  private static class Node {
    private Node[] children = new Node[26];
    private boolean isWord;

    public Node() {
      this.isWord = false;
    }
  }

  public static void main(String[] args) {
    MagicDictionary dic = new MagicDictionary();
    String[] dict = {"hello", "hallo", "leetcode"};
    dic.buildDict(dict);
    System.out.println(dic.search("hallo"));

  }

}

/**
 * Your MagicDictionary object will be instantiated and called as such: MagicDictionary obj = new
 * MagicDictionary(); obj.buildDict(dict); boolean param_2 = obj.search(word);
 */
