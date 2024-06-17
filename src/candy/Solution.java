package candy;
/*
Runtime
4ms
Beats
36.38%
Analyze Complexity
Memory 45.72MB
Beats 19.46%
 */
public class Solution {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            if ((i-1<0 || ratings[i-1] >= ratings[i]) && ((i+1)>=ratings.length || ratings[i] <= ratings[i+1])) {
                candies[i] = 1;
            }
        }
        for(int i=0; i<candies.length; i++) {
            if(candies[i]==1) {
                setLeftValue (candies,ratings, i);
                setRightValue(candies, ratings, i);
            }
        }
        int total = 0;
        for(int i=0; i<candies.length; i++) {
            if (candies[i]>0){
                total += candies[i];
            }else{
                total++;
            }
        }
        return total;
    }
    private void setLeftValue(int[] candies,int[] ratings, int i) {
        int index = 1;
         while (i - index>=0 && ratings[i-index]>ratings[i-index+1]) {
            candies[i-index] = Math.max( candies[i-index],candies[i-index+1] +1);
            index++;
        }
    }
    private void setRightValue(int[] candies, int[] ratings, int i) {
        int index = 1;
        while (i + index<ratings.length && ratings[i+index]>ratings[i+index-1]) {
            candies[i+index] = Math.max( candies[i+index],candies[i+index-1] +1);
            index++;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] rating = {1,3,4,5,2};
        s.candy(rating);
    }
}
