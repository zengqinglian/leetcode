package nextGreaterElementIII;

import java.util.Arrays;

public class Solution {
    public int nextGreaterElement(int n) {
        int i = 1;
        int[] array = new int[10];
        int maxIndex = 0;
        array[0] = n % 10;
        boolean found = false;
        n = n / 10;
        while (n > 0) {
            array[i] = n % 10;
            n = n / 10;
            if (array[maxIndex] > array[i]) {
                // find min > array[i]
                for (int j = i - 1; j >= 0; j--) {
                    if (array[j] > array[i] && array[j] < array[maxIndex]) {
                        maxIndex = j;
                    }
                }
                int temp = array[maxIndex];
                array[maxIndex] = array[i];
                array[i] = temp;
                found = true;
                break;
            } else {
                maxIndex = i;
                i++;
            }
        }

        if (found) {
            Arrays.sort(array, 0, i);
            long result = n * (long) Math.pow(10, i + 1) + array[i] * (long) Math.pow(10, i);
            for (int j = 0; j < i; j++) {
                result += array[j] * Math.pow(10, i - j - 1);
            }
            if (result > Integer.MAX_VALUE) {
                return -1;
            }
            return (int) result;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.nextGreaterElement(1999999999);
    }
}
