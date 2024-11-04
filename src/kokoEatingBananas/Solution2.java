package kokoEatingBananas;
/*
Runtime
7 ms
Beats
89.34%
Analyze Complexity
Memory
44.96 MB
Beats
62.38%

 */
public class Solution2 {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles.length > h ) throw new IllegalArgumentException();
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
            min = Math.min(min, pile);
        }

        int div = h / piles.length;
        int upper = max / div + (max % div == 0 ? 0 : 1);
        int lower = min / div;
        if (lower == 0) lower =1;

        while (lower+1 < upper) {
            int mid = (lower + upper) / 2;
            int finishHours = checkHour (piles, mid);
            if (finishHours <= h) {
                upper = mid;
            }else {
                lower = mid;
            }
        }
        int checkAgain = checkHour (piles, lower);
        if (checkAgain <= h) {
            return lower;
        }
        return upper;
    }

    private int checkHour(int[] piles, int value) {
        int res = 0;
        for (int pile : piles) {
            res += (pile / value + (pile % value ==0? 0:1));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minEatingSpeed(new int[]{1,1,1,999999999}, 10);
    }
}
