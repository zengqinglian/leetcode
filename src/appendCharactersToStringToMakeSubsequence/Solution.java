package appendCharactersToStringToMakeSubsequence;
/*
Runtime
4ms
Beats
93.30%
Analyze Complexity
Memory
45.20MB
Beats
76.83%

 */
public class Solution {
    public int appendCharacters(String s, String t) {
        int indexS = 0;
        for (int i=0; i<t.length(); i++) {
            char c = t.charAt(i);
            boolean found = false;
            while (indexS < s.length()) {
                if (s.charAt(indexS) == c) {
                    found = true;
                    indexS++;
                    break;
                }else{
                    indexS++;
                }
            }
            if (!found) {
                return t.length()  - i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.appendCharacters("coaching", "coding");
    }
}
