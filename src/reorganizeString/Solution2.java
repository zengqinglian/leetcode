package reorganizeString;

import java.util.Arrays;
import java.util.Comparator;
/*
Runtime
3 ms
Beats
69.15%
Analyze Complexity
Memory
41.68 MB
Beats
74.27%
 */

public class Solution2 {
    Integer[] indexArray = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
    public String reorganizeString(String s) {
        int[] countArray = new int[26];
        for (int i=0; i<s.length(); i++) {
            countArray[s.charAt(i)-'a']++;
        }
        Arrays.sort(indexArray, Comparator.comparingInt(a -> countArray[a]));
        if (countArray[indexArray[25]]-(s.length() - countArray[indexArray[25]]) > 1 ) {
            return "";
        }

        StringBuilder[] sbArray = new StringBuilder[countArray[indexArray[25]]];
        for (int i=0; i< sbArray.length; i++) {
            sbArray[i] = new StringBuilder();
        }

        int loopIdx = 0;
        for (int j=25; j>=0; j-- ) {
            if (countArray[indexArray[25]] == 0) {
                break;
            }
            for (int i=0; i<countArray[indexArray[j]]; i++) {
                sbArray[loopIdx++].append((char)(indexArray[j]+'a'));
                if (loopIdx>=sbArray.length) {
                    loopIdx=0;
                }
            }
        }
        StringBuilder res= new StringBuilder();
        for (int i=0; i< sbArray.length; i++) {
            res.append(sbArray[i]);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.reorganizeString("vvvlo");
    }
}
