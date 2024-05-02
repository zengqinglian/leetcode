package palindromePartitioning;

import java.util.*;

/*
Runtime 16ms
Beats
11.34%
of users with Java
Memory 56.42MB
Beats
75.58%
of users with Java
 */
public class Solution2 {
    public List<List<String>> partition(String s) {
        List<List<String>> res =  helper(s, 0);
        return res;
    }

    private List<List<String>> helper (String str, int s) {
        if (s >= str.length())
            return Collections.emptyList();
        if (s == str.length()-1){
            List<String> p = new LinkedList<>();
            p.add(str.substring(s, s+1));
            List<List<String>> result = new ArrayList<>();
            result.add(p);
            return result;
        }
        List<List<String>> result = new ArrayList<>();
        for (int i=s+1; i<=str.length(); i++) {
            if (isPalindrome(str, s, i)) {
                String sub = str.substring(s, i);
                List<List<String>> nextList = helper(str, i);
                if (!nextList.isEmpty()){
                    for (List<String> next : nextList) {
                        next.add(sub);
                    }
                    result.addAll(nextList);
                }
                if (i==str.length()){
                    List<String> subList = new LinkedList<>();
                    subList.add(sub);
                    result.add(subList);
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String str, int s, int e) {
        if (e-s==1) {
            return true;
        }
        int i=s;
        int j=e-1;
        while(i<j) {
            if (str.charAt(i)!=str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.partition("cdd");
    }
}
