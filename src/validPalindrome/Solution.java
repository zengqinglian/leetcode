package validPalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0 || s.length() == 1) {
            return true;
        }

        int length = s.length();
        int i = 0;
        int j = length - 1;
        while (j - i >= 1) {
            if (((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                    || (s.charAt(i) >= '0' && s.charAt(i) <= '9'))
                    && ((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z')
                            || (s.charAt(j) >= '0' && s.charAt(j) <= '9'))) {
                if (((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'))
                        && ((s.charAt(j) >= 'a' && s.charAt(j) <= 'z') || (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z'))) {

                    if (s.charAt(i) - s.charAt(j) != 0 && Math.abs(s.charAt(i) - s.charAt(j)) != 32) {
                        return false;
                    }
                } else {
                    if (s.charAt(i) - s.charAt(j) != 0) {
                        return false;
                    }
                }
                i++;
                j--;
            } else {
                if ((s.charAt(i) < 'a' || s.charAt(i) > 'z') && (s.charAt(i) < 'A' || s.charAt(i) > 'Z')
                        && (s.charAt(i) < '0' || s.charAt(i) > '9'))
                    i++;
                if ((s.charAt(j) < 'a' || s.charAt(i) > 'z') && (s.charAt(j) < 'A' || s.charAt(j) > 'Z')
                        && (s.charAt(j) < '0' || s.charAt(j) > '9'))
                    j--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isPalindrome("v' 5:UxU:5 v'");
    }
}
