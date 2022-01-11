package numberofGoodWaystoSplitaString;
/*
Runtime: 18 ms, faster than 50.64% of Java online submissions for Number of Good Ways to Split a String.
Memory Usage: 45 MB, less than 16.96% of Java online submissions for Number of Good Ways to Split a String.
 */
public class Solution {
    public int numSplits(String s) {
        if(s.length() == 1) {
            return 0;
        }
        int[] cntStartLeft = new int[s.length()];
        int[] cntStartRight = new int[s.length()];
        int[] letterLeft = new int[26];
        int[] letterRight = new int[26];
        int cntLeft = 0;
        int cntRight = 0;
        for(int i=0; i<s.length() ;i++) {
            int indexLeft = s.charAt(i) - 'a';
            int indexRight = s.charAt(s.length()-i-1)-'a';
            if(letterLeft[indexLeft] == 0) {
                letterLeft[indexLeft]++;
                cntLeft++;
                cntStartLeft[i] = cntLeft;
            }else{
                cntStartLeft[i] = cntLeft;
            }
            if(letterRight[indexRight] == 0) {
                letterRight[indexRight]++;
                cntRight++;
                cntStartRight[s.length()-i-1] = cntRight;
            }else{
                cntStartRight[s.length()-i-1] = cntRight;
            }
        }
        int res = 0;
        for(int i=0; i<cntStartLeft.length-2; i++) {
            if(cntStartLeft[i] == cntStartRight[i+1]) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.numSplits("aacaba");
    }
}
