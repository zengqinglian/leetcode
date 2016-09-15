package reverseString;

public class Solution {
    public String reverseString(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        int length = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = length - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
