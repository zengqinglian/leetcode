package shortestAndLexicographicallySmallestBeautifulString;
/*
2 ms
Beats
61.54%
Analyze Complexity
Memory
42.70 MB
Beats 76.92%

 */
public class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int startIndex = 0;
        int endIndex = startIndex;
        int cnt = 0;
        String res = "";
        while(startIndex<s.length() && endIndex<s.length()) {
            char c = s.charAt(endIndex++);
            if (c == '1') {
                cnt++;
                if (cnt == k) {
                   while(startIndex<endIndex) {
                       char c1 = s.charAt(startIndex++);
                       if (c1 == '1') {
                           String substring = s.substring(startIndex-1, endIndex);
                           if (res.isEmpty() || substring.length() < res.length() || (substring.length() == res.length() && substring.compareTo(res)<0)) {
                               res = substring;
                           }
                           cnt--;
                           break;
                       }
                   }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.shortestBeautifulSubstring("001110101101101111",10);
    }
}
