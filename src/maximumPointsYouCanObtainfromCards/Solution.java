package maximumPointsYouCanObtainfromCards;
/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximum Points You Can Obtain from Cards.
Memory Usage: 48.4 MB, less than 37.28% of Java online submissions for Maximum Points You Can Obtain from Cards.
 */
public class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int max = 0;
        for(int i=0; i<k; i++){
            sum+=cardPoints[i];
        }
        max = Math.max(max, sum);
        for(int i=0; i<k; i++){
            int toAdd = cardPoints.length-1-i;
            int toRemove = k-i-1;
            sum-=cardPoints[toRemove];
            sum+=cardPoints[toAdd];
            max=Math.max(max, sum);
        }
        return max;
    }
}
