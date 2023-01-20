package longestBinarySubsequenceLessThanorEqualtoK;
/*
1ms solution, beat 100
 */
public class Solution {
    public int longestSubsequence(String s, int k) {
        int w = 0;
        int total = 0;
        int zeroCnt = 0;
        int oneCnt = 0;
        for (int i=s.length()-1; i>=0; i--) {
            if (s.charAt(i) == '0') {
                zeroCnt++;
            }else{
                if (w<=30 && total < k) {
                    total = (int)Math.pow(2, w) + total;
                    if (total<=k){
                        oneCnt++;
                    }
                }
            }
            w++;
        }
        return zeroCnt+oneCnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestSubsequence("000101010011011001011101111000111111100001011000000100010000111100000011111001000111100111101001111001011101001011011101001011011001111111010011100011110111010000010000010111001001111101100001111",300429827);
    }
}
