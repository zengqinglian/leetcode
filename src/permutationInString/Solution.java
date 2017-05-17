package permutationInString;

public class Solution {
    // correct but over time solution
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() == 0) {
            return false;
        }
        if (s2.length() < s1.length()) {
            return false;
        }

        int index = 0;
        while (s2.length() - index >= s1.length()) {
            char c = s2.charAt(index);
            int i = s1.indexOf(c);
            int loopIndex = index + 1;
            if (i >= 0) {
                String temp = s1.substring(0, i) + (i + 1 >= s1.length() ? "" : s1.substring(i + 1));
                while (temp.length() > 0) {
                    char ch = s2.charAt(loopIndex);
                    int i2 = temp.indexOf(ch);
                    if (i2 >= 0) {
                        temp = temp.substring(0, i2) + (i2 + 1 >= temp.length() ? "" : temp.substring(i2 + 1));
                    } else {
                        break;
                    }
                    if (temp.length() == 0) {
                        return true;
                    }
                    loopIndex++;
                }
                if (temp.length() == 0) {
                    return true;
                }

            }

            index++;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.checkInclusion("adc", "dcda");

    }
}
