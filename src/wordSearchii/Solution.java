package wordSearchii;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
Runtime
672 ms
Beats 26.53%
of users with Java
Memory 46.82 MB
Beats 29.87%
of users with Java
 */
public class Solution {
    int[] moveX = {1,-1, 0 ,0};
    int[] moveY = {0,0, 1 ,-1};
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(String word : words) {
            trie.addWord(word);
        }
        Set<String> result = new HashSet<>();
        boolean[][] status = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                helper(i, j, board, status, result, trie.head, new StringBuilder());
            }
        }
        return new ArrayList<>(result);
    }

    private void helper(int i, int j, char[][] board, boolean[][] status, Set<String> result, Node node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        char c = board[i][j];
        if (node.children[c-'a'] ==null) {
            return;
        }
        sb.append(c);
        Node newNode = node.children[c-'a'];
        if (newNode.isLeaf) {
            result.add(sb.toString());
        }
        status[i][j] = true;
        int StringLen = sb.length();
        for(int x=0; x<4; x++) {
            int newI = i + moveX[x];
            int newJ = j + moveY[x];
            if (newI>=0 && newI<board.length && newJ>=0 && newJ<board[0].length && !status[newI][newJ]) {
                helper(newI, newJ, board, status, result, newNode, sb);
            }
        }
        sb.setLength(StringLen-1);
        status[i][j] = false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] words = {"oa","oaa"};
        char[][] board ={{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        s.findWords(board, words);
    }

    private static class Trie {
        private Node head = new Node();

        private void addWord(String word) {
            Node current = head;
            for (char c : word.toCharArray()) {
                if (current.children[c-'a']==null) {
                    current.children[c-'a'] = new Node();
                }
                current = current.children[c-'a'];
            }
            current.isLeaf = true;
        }
    }

    private static class Node {
        private Node[] children = new Node[26];
        private boolean isLeaf = false;
    }


}
