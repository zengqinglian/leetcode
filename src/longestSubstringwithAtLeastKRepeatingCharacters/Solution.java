package longestSubstringwithAtLeastKRepeatingCharacters;
/*
Runtime
128 ms
Beats
17.23%
Memory
41.5 MB
Beats
38.2%
 */
public class Solution {
    public int longestSubstring(String s, int k) {
        int ret = 0;
        for(int j=0; j<s.length();j++) {
            int[] chars = new int[26];
            int res = 0;
            int charCount = 0;
            int matchCount = 0;
            if (ret >= s.length()-j){
                return ret;
            }
            for (int i = j; i < s.length(); i++) {
                char c = s.charAt(i);
                if ( chars[c - 'a'] ==0) {
                    charCount++;
                }
                chars[c - 'a']++;
                if (chars[c - 'a'] == k) {
                    matchCount++;
                    if (matchCount == charCount) {
                        res = Math.max(res, i -j +1);
                    }
                } else if (chars[c - 'a'] > k) {
                    if (matchCount == charCount) {
                        res = Math.max(res, i -j+ 1);
                    }
                }
            }
            ret = Math.max(ret, res);
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestSubstring("aaabbccccddddeeeee", 3);
    }


}
