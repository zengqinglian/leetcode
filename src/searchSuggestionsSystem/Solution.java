package searchSuggestionsSystem;

import javax.swing.tree.TreeNode;
import java.util.*;

public class Solution {
    //35ms solution, beat 40%
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode();
        for(String product : products){
            updateTrie(root, product,0);
        }
        List<List<String>> res = new ArrayList<>();
        searchFunction(root, searchWord,0, res);
        return res;
    }

    private void searchFunction(TrieNode root, String searchWord, int index, List<List<String>> res) {
        if(index==searchWord.length()){
            return;
        }
        if(root==null){
            res.add(Collections.emptyList());
            searchFunction(null,searchWord,index+1, res);
        }else {
            char c = searchWord.charAt(index);
            TrieNode node = root.children[c - 'a'];
            List<String> list = new ArrayList<>();
            if (node != null) {
                int cnt = 0;
                Collections.sort(node.words);
                for (String word : node.words) {
                    list.add(word);
                    cnt++;
                    if (cnt == 3) {
                        break;
                    }
                }
            }
            res.add(list);
            searchFunction(node, searchWord, index + 1, res);
        }

    }

    private void updateTrie(TrieNode root, String word, int index){
        char c = word.charAt(index);
        TrieNode newNode = root.children[c-'a'];
        if(newNode == null) {
            newNode = new TrieNode();
            root.children[c - 'a'] = newNode;
        }
        newNode.words.add(word);
        if(index == word.length()-1){
            return;
        }else{
            updateTrie(newNode,word, index+1);
        }
    }


    private static class TrieNode{
        private TrieNode[] children = new TrieNode[26];
        private List<String> words = new ArrayList<>();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] products = {"mobile","mouse","moneypot","monitor","mousepad","mouse"};
        s.suggestedProducts(products, "mouse");
    }
}
