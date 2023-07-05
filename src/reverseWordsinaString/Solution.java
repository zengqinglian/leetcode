package reverseWordsinaString;
/*
Runtime
6 ms
Beats
80.35%
Memory
43.5 MB
Beats
51.44%
 */
public class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--) {
            String newStr = arr[i].trim();
            if (newStr.length() >0) {
                sb.append(arr[i].trim());
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.reverseWords("a good   example");
    }
}
