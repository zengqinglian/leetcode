package numberofSubstringsWithOnly1s;
/*
Runtime: 7 ms, faster than 34.92% of Java online submissions for Number of Substrings With Only 1s.
Memory Usage: 43.5 MB, less than 5.76% of Java online submissions for Number of Substrings With Only 1s.
 */
public class Solution {
    public int numSub(String s) {
        int res = 0;
        int value = 0;
        for(char c : s.toCharArray()) {
            if(c == '1') {
                value++;
                res+=value;
                res%=1_000_000_007;
            }else{
                value = 0;
            }
        }
        return res;
    }
}
