package longestPalindrome;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    // avg speed
    public int longestPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return s.length();
        }
        int total = 0;
        Set<Character>  set = new HashSet<>(s.length());
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                total += 2;
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        if (set.isEmpty()) {
            return total;
        } else {
            return total + 1;
        }
    }
}
