package uglyNumber2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int nthUglyNumber(int n) {
        Set<Long> set = new HashSet<>();
        int[] factor = new int[3];
        factor[0]=2;
        factor[1]=3;
        factor[2]=5;
        int count = 1;
        int index = 0;
        set.add(1L);
        long[] result = new long[1];
        result[0] = 1;
        while (index < n) {
            long[] temp = new long[3];
            long[] noDuplicateTemp = null;
            int tempIndex = 0;
            for (int i : factor) {
                long newVal = i * result[index];
                if (set.add(newVal)) {
                    temp[tempIndex] = i * result[index];
                    tempIndex++;
                }
            }
            noDuplicateTemp = Arrays.copyOf(temp, tempIndex);
            result = mergeSort(result, noDuplicateTemp);
            count = count + noDuplicateTemp.length;
            index++;
        }
        return (int) result[n - 1];
    }

    private long[] mergeSort(long[] a, long[] b) {
        long result[] = new long[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[k++] = a[i];
                i++;
            } else {
                result[k++] = b[j];
                j++;
            }
        }
        System.arraycopy(a, i, result, k, (a.length - i));
        System.arraycopy(b, j, result, k, (b.length - j));
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.nthUglyNumber(4);
    }
}
