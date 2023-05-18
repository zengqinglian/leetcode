package largestPalindromicNumber;

import java.util.Comparator;
import java.util.PriorityQueue;

/*
Runtime 163 ms
Beats 20.81%
Memory 42.9 MB
Beats 98.7%
 */
public class Solution {
    public String largestPalindromic(String num) {
        int[] array = new int[10];
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (char c : num.toCharArray()) {
            if (array[c - '0'] == 0) {
                q.add(c - '0');
            }
            array[c - '0']++;
        }
        if (q.size() == 1 && q.peek() == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        boolean onlyZero = true;
        int midNumber = -1;
        while (!q.isEmpty()) {
            int i = q.poll();
            if (array[i] >= 2) {
                if (i > 0) {
                    onlyZero = false;
                }
                int loop = array[i] / 2;
                for (int j = 0; j < loop; j++) {
                    sb.append((char) (i + '0'));
                    sb.insert(0, (char) (i + '0'));
                }
            }
            if (array[i] % 2 == 1) {
                midNumber = i;
            }
        }


        if (midNumber >= 0) {
            if (onlyZero) {
                return String.valueOf((char) (midNumber + '0'));
            }
            sb.insert(sb.length() / 2, (char) (midNumber + '0'));
            return sb.toString();
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.largestPalindromic("00011");
    }
}
