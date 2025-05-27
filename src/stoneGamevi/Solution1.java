package stoneGamevi;

import java.util.Arrays;
/*
Runtime
85 ms
Beats
41.22%
Analyze Complexity
Memory
56.54 MB
Beats
95.27%
 */
public class Solution1 {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        Integer[] indexValues = new Integer[bobValues.length];
        for (int i = 0; i < aliceValues.length; i++) {
            indexValues[i] = i;
        }
        Arrays.sort(indexValues, (a,b)-> Integer.compare(aliceValues[b]+bobValues[b], aliceValues[a]+bobValues[a]));
        int aliceSum = 0;
        int bobSum = 0;
        boolean aliceTurn = true;
        for (int i = 0; i < indexValues.length; i++) {
            if (aliceTurn) {
                aliceSum += aliceValues[indexValues[i]];
            }else{
                bobSum += bobValues[indexValues[i]];
            }
            aliceTurn = !aliceTurn;
        }
        if (aliceSum > bobSum) {
            return 1;
        }else if (bobSum > aliceSum) {
            return -1;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.stoneGameVI(new int[]{1,2},new int[]{3,1});
    }
}
