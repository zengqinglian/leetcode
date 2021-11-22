package reducingDishes;

import java.util.Arrays;
/*
Runtime: 2 ms, faster than 57.99% of Java online submissions for Reducing Dishes.
Memory Usage: 39.2 MB, less than 22.26% of Java online submissions for Reducing Dishes.
 */
public class Solution1 {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        if(satisfaction[satisfaction.length-1]<=0) {
            return 0;
        }
        if(satisfaction[0]>=0) {
            int res = 0;
            for(int i=1 ;i<=satisfaction.length; i++) {
                res+=(satisfaction[i-1]*i);
            }
            return res;
        }

        int firstPositiveIndex = -1;
        int total = 0;
        for(int i=0; i<satisfaction.length; i++) {
            if(firstPositiveIndex==-1 && satisfaction[i]>=0) {
                firstPositiveIndex = i;
            }
            if(firstPositiveIndex>=0){
                total += satisfaction[i];
            }
        }
        int startIndex = firstPositiveIndex;
        for(int i=firstPositiveIndex-1; i>=0; i--){
            total += satisfaction[i];
            if(total>=0){
                startIndex = i;
            }else{
                break;
            }
        }
        int j = 1;
        int res=0;
        for(int i=startIndex; i<satisfaction.length; i++) {
            res+=(satisfaction[i]*j++);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] satisfaction = {-2,5,-1,0,3,-3};
        s.maxSatisfaction(satisfaction);
    }
}
