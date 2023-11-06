package randomPickwithWeight;

import java.util.Arrays;
import java.util.Random;
/*
Runtime
22 ms
Beats
97.90%
Memory
47.8 MB
Beats
30.18%
 */
public class Solution {
    int[] array = null;
    Random ran = new Random();
    public Solution(int[] w) {
        for (int i=1; i<w.length; i++) {
            w[i] = w[i-1] + w[i];
        }
        this.array = w;
    }

    public int pickIndex() {
        int pickNumber = ran.nextInt(array[array.length-1]) +1;
        int idx = Arrays.binarySearch(array, pickNumber);
        if (idx>=0){
            return idx;
        }
        return -1- idx;

    }

    public static void main(String[] args) {
        int[] w = {3,14,1,7};
        Solution s = new Solution(w);
        s.pickIndex();
    }
}
