package minimumSuffixFlips;
/*
Runtime: 13 ms, faster than 12.41% of Java online submissions for Minimum Suffix Flips.
Memory Usage: 43.9 MB, less than 17.29% of Java online submissions for Minimum Suffix Flips.
 */
public class Solution1 {
    public int minFlips(String target) {
        char c  = '0' ;
        int res = 0;
        for(int i= 0; i<target.length(); i++) {
            if(target.charAt(i) != c ) {
                res++;
                c=target.charAt(i);
            }
        }
        return res;
    }
}
