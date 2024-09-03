package longestPalindromicSubstring;
/*
Runtime
7
ms
Beats
97.88%
Analyze Complexity
Memory
44.44
MB
Beats
64.59%
 */
public class Solution4 {
    public String longestPalindrome(String s) {
        int max = 1;
        String res = s.substring(0, 1);
        int i = 0;
        while (i<s.length()) {
            char c = s.charAt(i);
            int endIndex = i;
            for (int j=i+1;  j<s.length(); j++) {
                if (c != s.charAt(j)) {
                    break;
                }else{
                    endIndex++;
                }
            }
            int[] checked = checkPalindrome(i, endIndex, s);
            if (checked[0] > max) {
                max = checked[0];
                res = s.substring(checked[1], checked[2]+1);
            }
            i = endIndex+1;
        }
        return res;
    }

    private int[] checkPalindrome(int i, int endIndex, String s) {
        int[] res = new int[3];
        res[0] = endIndex-i +1;
        res[1] = i;
        res[2] = endIndex;
        int shift = 1;
        while (i-shift>=0 && endIndex+shift<s.length()){
            if (s.charAt(i-shift) == s.charAt(endIndex+shift)){
                res[0] = endIndex+shift-i+shift +1;
                res[1] = i-shift;
                res[2] = endIndex+shift;
                shift++;
            }else{
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestPalindrome("cbbd");
    }
}
