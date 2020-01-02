package airplaneSeatAssignmentProbability;

public class Solution {
    public double nthPersonGetsNthSeat(int n) {
        if(n==1){
            return 1.0;
        }

        return 0.5;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.nthPersonGetsNthSeat(4);
    }
}
