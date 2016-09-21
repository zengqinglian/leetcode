package palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

//substring is slow, reduce the time calling it.
//loop from the end of string, so we add new element at the end of arraylist instead of adding from beginning to avoid shift element
//6ms solution - meet avg beat 60%
public class Solution1 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        int length = s.length();
        if (length == 0) {
            return result;
        }

        if (length == 1) {
            List<String> list = new ArrayList<>();
            list.add(s);
            result.add(list);
            return result;
        }

        for (int i = length - 1; i >= 0; i--) {
            if (isPalindrome(s, i, length - 1)) {
                if (i == 0) {
                    List<String> list = new ArrayList<>();
                    list.add(s);
                    result.add(list);
                } else {
                    List<List<String>> list = partition(s.substring(0, i));
                    for (List<String> li : list) {
                        li.add(s.substring(i, length));
                        result.add(li);
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s, int start, int end) {
        if (start == end) {
            return true;
        }

        if (end - start == 1) {
            return s.charAt(end) == s.charAt(start);
        }

        if (s.charAt(start) == s.charAt(end)) {
            return isPalindrome(s, start + 1, end - 1);
        }
        return false;
    }
}
