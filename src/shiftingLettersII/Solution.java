package shiftingLettersII;
/*
Runtime: 13 ms, faster than 51.91% of Java online submissions for Shifting Letters II.
Memory Usage: 103.5 MB, less than 80.30% of Java online submissions for Shifting Letters II.
 */
public class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int[] values = new int[s.length()];
        for (int[] shift : shifts) {
            if (shift[2] == 0) {
                values[shift[0]]--;
                if(shift[1] < s.length() -1) {
                    values[shift[1]+1]++;
                }
            }else{
                values[shift[0]]++;
                if(shift[1] < s.length() -1) {
                    values[shift[1]+1]--;
                }
            }
        }
        int total = 0;
        char[] charArray = s.toCharArray();
        for (int i=0; i<values.length; i++) {
            total+= values[i];
            values[i] = total;
            int v = charArray[i] - 'a';
            int realShift = v + values[i];
            if (realShift <0) {
                realShift=realShift%26+26;
            }
            if (realShift >25) {
                realShift=realShift % 26;
            }
            charArray[i] = (char)(realShift + 'a');
        }
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] shifts = {{0,0,0},{1,1,1}};
        s.shiftingLetters("dztz", shifts);
    }
}
