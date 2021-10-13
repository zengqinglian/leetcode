package checkIfaStringContainsAllBinaryCodesofSizeK;


public class Solution1 {
    /*
    Someone bit hash solution
    Runtime: 23 ms, faster than 85.47% of Java online submissions for Check If a String Contains All Binary Codes of Size K.
Memory Usage: 60.8 MB, less than 29.48% of Java online submissions for Check If a String Contains All Binary Codes of Size K.
     */
    public static boolean hasAllCodes(String s, int k) {
        int need = 1 << k;
        boolean[] got = new boolean[need];
        int allOne = need - 1;
        int hashVal = 0;

        for (int i = 0; i < s.length(); i++) {
            // calculate hash for s.substr(i-k+1,i+1)
            hashVal = ((hashVal << 1) & allOne) | (s.charAt(i) - '0');
            // hash only available when i-k+1 > 0
            if (i >= k - 1 && !got[hashVal]) {
                got[hashVal] = true;
                need--;
                if (need == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}

