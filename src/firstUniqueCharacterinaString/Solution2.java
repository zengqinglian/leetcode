package firstUniqueCharacterinaString;

public class Solution2 {
    // array solution - much quicker.
    public int firstUniqChar(String s) {
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++)
            map[s.charAt(i)]++;
        for (int i = 0; i < s.length(); i++)
            if (map[s.charAt(i)] == 1)
                return i;
        return -1;
    }
}
