package interleavingString;
/*
Runtime
1 ms
Beats
94.47%
Memory
41.2 MB
Beats
28.20%
 */

//With Cache. improve performance
public class Solution1 {
    Boolean[][] cache;
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        cache = new Boolean[s1.length()+1][s2.length()+1];
        boolean res = check(s1, s2, s3, 0, 0, 0);
        return res;
    }

    private boolean check(String s1, String s2, String s3, int idx1, int idx2, int idx3) {
        if (idx3 == s3.length()) {
            return true;
        }
        if (cache[idx1][idx2]!=null) {
            return cache[idx1][idx2];
        }
        boolean res = false;
        if (idx1 < s1.length() && s1.charAt(idx1) == s3.charAt(idx3)) {
            res = res || check(s1, s2, s3, idx1+1, idx2, idx3+1);
        }
        if (idx2<s2.length() && s2.charAt(idx2) == s3.charAt(idx3)) {
            res = res || check(s1, s2, s3, idx1, idx2+1, idx3+1);
        }
        cache[idx1][idx2] = res;
        return res;
    }
}
