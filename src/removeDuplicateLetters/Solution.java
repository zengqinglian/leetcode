package removeDuplicateLetters;

import java.util.LinkedList;
/*
Runtime
2 ms
Beats
96.25%
Memory
41 MB
Beats
90.14%
 */
public class Solution {
    public String removeDuplicateLetters(String s) {
        int[] letters = new int[26];
        for(char c : s.toCharArray()) {
            letters[c-'a']++;
        }
        LinkedList<Character> ll = new LinkedList<>();
        boolean[] status = new boolean[26];
        for(char c : s.toCharArray()) {
            letters[c-'a']--;
            if (status[c-'a']) {
                continue;
            }
            if (ll.isEmpty()) {
                ll.add(c);
                status[c-'a'] = true;
            }else {
                char top = ll.peekLast();
                while(!ll.isEmpty() && top > c && letters[top-'a'] >0) {
                    ll.removeLast();
                    status[top-'a']=false;
                    if (!ll.isEmpty()) {
                        top = ll.peekLast();
                    }
                }
                ll.add(c);
                status[c-'a']=true;
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!ll.isEmpty()) {
            sb.append(ll.remove());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.removeDuplicateLetters("bbcaac");
    }
}
