package successfulPairsofSpellsandPotions;

import java.util.Arrays;
/*

72ms solution, beat 85%
 */
public class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for (int i=0; i<spells.length ; i++) {
            int pos = getPosition(spells[i], potions, success);
            if (pos<0){
                res[i] = 0;
            }else {
                res[i] = potions.length - pos;
            }
        }
        return res;
    }

    private int getPosition(int v, int[] potions, long success) {
        int s = 0;
        int e = potions.length-1;
        while (s<=e) {
            if (s == e) {
                if ((long)v * (long)potions[s] >= success) {
                    return s;
                } else {
                    return s+1;
                }
            }else {
                int m = (s+e)/2;
                long total = (long)v * (long)potions[m];
                if (total >= success) {
                    e = m;
                }else {
                    s=m+1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] spells = {5,1,3};
        int[] potions = {1,2,3,4,5};
        Solution s = new Solution();
        s.successfulPairs(spells, potions, 7);
    }
}
