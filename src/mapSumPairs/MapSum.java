package mapSumPairs;

import java.util.HashMap;
import java.util.Map;

// Trie Solution beat 80%
public class MapSum {
  /** Initialize your data structure here. */
  // use trie structure
  // insert log n , search log n
  private TreeNode root;

  public MapSum() {
    root = new TreeNode(0, false);
  }

  public void insert(String key, int val) {
    TreeNode curNode = root;
    char[] charArr = key.toCharArray();
    for (int i = 0; i < charArr.length; i++) {
      if (curNode.children.get(charArr[i]) != null) {
        curNode = curNode.children.get(charArr[i]);
      } else {
        TreeNode newNode = new TreeNode(0, false);
        curNode.children.put(charArr[i], newNode);
        curNode = newNode;
      }

      if (i == charArr.length - 1) {
        curNode.isWord = true;
        curNode.val = val;
      }
    }
  }

  public int sum(String prefix) {
    char[] chars = prefix.toCharArray();
    TreeNode cur = root;
    int sum = 0;
    for (int i = 0; i < chars.length; i++) {
      if (cur.children.containsKey(chars[i])) {
        cur = cur.children.get(chars[i]);
      } else {
        return 0;
      }
    }

    return getSum(cur);
  }

  private int getSum(TreeNode node) {
    int sum = 0;
    if (node.isWord) {
      sum = node.val;
    }

    for (TreeNode cNode : node.children.values()) {
      sum += getSum(cNode);
    }
    return sum;
  }

  private static class TreeNode {
    private int val;
    private Map<Character, TreeNode> children;
    private boolean isWord;

    public TreeNode(int val, boolean isWord) {
      this.val = val;
      this.children = new HashMap<>();
      this.isWord = isWord;
    }

    @Override
    public String toString() {
      return "TreeNode [val=" + val + ", children=" + children + "]";
    }
  }
}

/**
 * Your MapSum object will be instantiated and called as such: MapSum obj = new MapSum();
 * obj.insert(key,val); int param_2 = obj.sum(prefix);
 */
