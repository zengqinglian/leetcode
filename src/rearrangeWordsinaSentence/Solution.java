package rearrangeWordsinaSentence;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/*
Runtime: 25 ms, faster than 49.24% of Java online submissions for Rearrange Words in a Sentence.
Memory Usage: 39.8 MB, less than 80.48% of Java online submissions for Rearrange Words in a Sentence.
 */
public class Solution {
    public String arrangeWords(String text) {
        String[] arr = text.split(" ");
        Arrays.sort(arr, Comparator.comparingInt(String::length));
        String res = Arrays.stream(arr).map(a -> {
            char c = a.charAt(0);
            if(c>=65 && c<=90){
               c =  (char)(c+32);
               return c+a.substring(1);
            }
            return a;

        }).collect(Collectors.joining(" "));
        char c = res.charAt(0);
        char newC = (char)(c-32);
        return newC + res.substring(1);
    }

    private static class Node{
        private String text;
        private int index;
        Node(String text, int index){
            this.text = text;
            this.index = index;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.arrangeWords("LeetCode is cool");
    }
}
