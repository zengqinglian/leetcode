package movementofRobots;
/*
Time limit over solution

 */
public class Solution1 {
    public int sumDistance(int[] nums, String s, int d) {
        for (int i=0; i<nums.length; i++) {
            char direction = s.charAt(i);
            if (direction == 'R') {
                nums[i]+=d;
            }else{
                nums[i]-=d;
            }
        }
        int res = 0;
        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                res += Math.abs(nums[i]-nums[j]);
                res %= 1_000_000_007;
            }
        }
        return res;
    }
}
