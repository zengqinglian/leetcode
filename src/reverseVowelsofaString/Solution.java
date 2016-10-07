package reverseVowelsofaString;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public String reverseVowels(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }

        char[] array = s.toCharArray();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');

        int length = s.length();
        int startIndex = 0;
        int endIndex = length - 1;

        while (startIndex < endIndex) {

            while (!vowels.contains(array[startIndex]) && startIndex < endIndex) {
                startIndex++;
            }
            if (startIndex >= endIndex) {
                break;
            }
            while (!vowels.contains(array[endIndex]) && startIndex < endIndex) {
                endIndex--;
            }
            if (startIndex >= endIndex) {
                break;
            }

            char temp = array[startIndex];

            array[startIndex] = array[endIndex];
            array[endIndex] = temp;
            startIndex++;
            endIndex--;
        }

        return new String(array);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.reverseVowels(".,");
    }
}
