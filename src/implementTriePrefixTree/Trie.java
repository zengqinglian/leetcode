package implementTriePrefixTree;
/*
Runtime
34 ms
Beats
84.62%
Memory
54.5 MB
Beats
86.3%
 */
public class Trie {

    private TreeNode root;
    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word) {
        TreeNode cur = root;
        for(char c : word.toCharArray()) {
            int index = c-'a';
            if (cur.leaves[index] == null) {
                cur.leaves[index] = new TreeNode();
            }
            cur = cur.leaves[index];
        }
        cur.isLeaf = true;
    }

    public boolean search(String word) {
        TreeNode cur = root;
        for(char c : word.toCharArray()) {
            int index = c-'a';
            if (cur.leaves[index]==null) {
                return false;
            }
            cur = cur.leaves[index];
        }
        return cur.isLeaf;
    }

    public boolean startsWith(String prefix) {
        TreeNode cur = root;
        for(char c : prefix.toCharArray()) {
            int index = c-'a';
            if (cur.leaves[index]==null) {
                return false;
            }
            cur = cur.leaves[index];
        }
        return true;
    }

    private static class TreeNode {
        TreeNode[] leaves = new TreeNode[26];
        boolean isLeaf;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("app");
        trie.search("apps");
        trie.search("app");
    }
}
