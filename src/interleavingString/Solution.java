package interleavingString;
/*
Time Limit Exceeded  105/106
 */
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean res = check(s1, s2, s3, 0, 0, 0);
        return res;
    }

    private boolean check(String s1, String s2, String s3, int idx1, int idx2, int idx3) {
        if (idx3 == s3.length()) {
            return true;
        }
        boolean res = false;
        if (idx1 < s1.length() && s1.charAt(idx1) == s3.charAt(idx3)) {
            res = res || check(s1, s2, s3, idx1+1, idx2, idx3+1);
        }
        if (idx2<s2.length() && s2.charAt(idx2) == s3.charAt(idx3)) {
            res = res || check(s1, s2, s3, idx1, idx2+1, idx3+1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.isInterleave("aabd","abdc","aabdabcd");
    }
}
