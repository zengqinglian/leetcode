package minimumSuffixFlips;
/*
Runtime: 9 ms, faster than 30.45% of Java online submissions for Minimum Suffix Flips.
Memory Usage: 43.4 MB, less than 35.34% of Java online submissions for Minimum Suffix Flips.
 */
public class Solution {
    public int minFlips(String target) {
        int res = 0;
        boolean zeroFlag = true;
        for(int i= 0; i<target.length(); i++) {
            if(zeroFlag) {
                if(target.charAt(i) == '1' ) {
                    res++;
                    zeroFlag = false;
                }
            }else {
                if(target.charAt(i) == '0' ) {
                    res++;
                    zeroFlag = true;
                }
            }

        }
        return res;
    }
}
