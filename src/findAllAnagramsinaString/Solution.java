package findAllAnagramsinaString;

import java.util.ArrayList;
import java.util.List;
/*
Runtime
11 ms
Beats
72.50%
Memory
43.3 MB
Beats
98.93%
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] chars_p = new int[26];
        for (char c : p.toCharArray()) {
            chars_p[c-'a'] ++;
        }
        int i=0;
        int j= 0;
        List<Integer> res = new ArrayList<>();
        int[] chars_s = new int[26];
        while (j<s.length()) {
            if (j-i <= p.length()) {
                char c = s.charAt(j);
                chars_s[c-'a']++;
            }
            if (j-i +1 == p.length()) {
                if (check(chars_s, chars_p)) {
                    res.add(i);
                }
                char c = s.charAt(i);
                chars_s[c-'a']--;
                i++;
            }
            j++;
        }
        return res;
    }

    private boolean check(int[] charsS, int[] charsP) {
        for (int i=0; i<26; i++) {
            if (charsP[i] != charsS[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findAnagrams("cbaebabacd","abc");
    }
}
