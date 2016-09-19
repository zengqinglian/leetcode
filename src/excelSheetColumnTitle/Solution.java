package excelSheetColumnTitle;

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        int result = n;
        int mod = n % 26;
        if (n < 26) {
            if (mod == 0) {
                sb.append((char) (90));
            } else {
                sb.append((char) (mod + 64));
            }
            result = 0;
        }

        while (result >= 26) {
            mod = result % 26;
            result = result / 26;
            if (mod == 0) {
                sb.append((char) (90));
                result = result - 1;
            } else {
                sb.append((char) (mod + 64));
            }
        }
        if (result > 0) {
                sb.append((char) (result + 64));
            }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        s.convertToTitle(701);
    }
}
