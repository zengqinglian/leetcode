package permutationInString;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    // improvement - beat 30%
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() == 0) {
            return false;
        }
        if (s2.length() < s1.length()) {
            return false;
        }
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }

        int i = 0;
        int j = 0;
        while (s2.length() - i >= s1.length()) {
            if (countMap.containsKey(s2.charAt(j))) {
                if (countMap.get(s2.charAt(j)) - 1 >= 0) {
                    countMap.put(s2.charAt(j), countMap.get(s2.charAt(j)) - 1);
                    j++;
                } else {
                    while (s2.charAt(i) != s2.charAt(j)) {
                        countMap.put(s2.charAt(i), countMap.get(s2.charAt(i)) + 1);
                        i++;
                    }

                    countMap.put(s2.charAt(i), countMap.get(s2.charAt(i)) + 1);
                    i++;
                }
            } else {
                while (i < j) {
                    countMap.put(s2.charAt(i), countMap.get(s2.charAt(i)) + 1);
                    i++;
                }
                j = j + 1;
                i = j;

            }
            if (j - i == s1.length()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.checkInclusion("ky", "ainwkckifykxlribaypk");
    }
}
