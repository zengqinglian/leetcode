package palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

//25ms solution beat 8% only.
public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if (s.length() == 0) {
            return result;
        }
        if (s.length() == 1) {
            List<String> list = new ArrayList<>();
            list.add(s);
            result.add(list);
            return result;
        }

        int length = s.length();
        for (int i = 1; i <= length; i++) {
            String subStr = s.substring(0, i);
            if (isPalindrome(subStr)) {
                if (subStr.equals(s)) {
                    List<String> list = new ArrayList<>();
                    list.add(subStr);
                    result.add(list);
                } else {
                    List<List<String>> subStringResult = partition(s.substring(i));
                    for (List<String> list : subStringResult) {
                        list.add(0, subStr);
                        result.add(list);
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        if (s.length() == 1) {
            return true;
        }

        if (s.length() == 2) {
            return s.substring(0, 1).equals(s.substring(1));
        }

        if (s.substring(0, 1).equals(s.substring(s.length() - 1))) {
            return isPalindrome(s.substring(1, s.length() - 1));
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.partition("bb");
    }
}
