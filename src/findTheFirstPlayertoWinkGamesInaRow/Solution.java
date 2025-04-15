package findTheFirstPlayertoWinkGamesInaRow;

/*
Runtime
1ms
Beats
100.00%
Analyze Complexity
Memory
60.97 MB
Beats
39.36%
 */

public class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        if (k== 1) {
            if (skills[0]<skills[1]) {
                return 1;
            }else{
                return 0;
            }
        }
        int max = skills[0];
        int index = 0;
        int cnt = 0;
        for (int i=1; i<skills.length; ) {
            int loopIndex = i;
            while (loopIndex<skills.length && max > skills[loopIndex]) {
                cnt++;
                loopIndex++;
                if (cnt == k) {
                    return index;
                }
            }
            if (loopIndex<skills.length) {
                max = skills[loopIndex];
                cnt = 1;
                index = loopIndex;
                i = index + 1;
            }else{
                i = skills.length;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        int[] skills = {4,18,17,20,15,12,8,5};
        s.findWinningPlayer(skills, 1);
    }
}
