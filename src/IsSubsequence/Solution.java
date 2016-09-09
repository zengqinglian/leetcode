package IsSubsequence;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int lengthS = s.length();
        int lengthT = t.length();
        int i = 0;
        int j = 0;
        while (j < lengthT) {
            if (t.charAt(j) == s.charAt(i)) {
                if (i == lengthS - 1) {
                    return true;
                } else {
                    j++;
                    i++;
                }
            } else {
                j++;
            }
        }
        return false;
    }
}
