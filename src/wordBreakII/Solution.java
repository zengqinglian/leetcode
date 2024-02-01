package wordBreakII;

import java.util.*;

public class Solution {
    private Set<Integer> invalid = new HashSet<>();

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        helper(s, 0, wordDict, res, new StringBuilder());
        return res;
    }

    private boolean helper(String s, int index, List<String> wordDict, List<String> res, StringBuilder sb) {
        if (index >= s.length()) {
            res.add(sb.toString().trim());
            return true;
        }
        boolean hasTrue = false;
        for (String word : wordDict) {
            if (!invalid.contains(index) && word.length() + index <= s.length() && word.equals(s.substring(index, index + word.length()))) {
                if (helper(s, index + word.length(), wordDict, res, sb.append(word + " "))) {
                    sb.setLength(sb.length() - word.length() - 1);
                    hasTrue = true;
                }else{
                    sb.setLength(sb.length() - word.length() - 1);
                }
            }
        }
        if (!hasTrue) {
            invalid.add(index);
        }
        return hasTrue;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] dic = {"aaaa","aaa","aa"};
        s.wordBreak("aaaaaaaa", Arrays.asList(dic));
    }
}
