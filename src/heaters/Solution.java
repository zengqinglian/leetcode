package heaters;

import java.util.Arrays;
/*
Runtime
13 ms
Beats
83.40%
Memory
46.8 MB
Beats
24.44%
 */
public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        int indexHeater = 0;
        for (int i =0; i<houses.length; i++) {
            int house = houses[i];
            while( indexHeater<heaters.length && house>heaters[indexHeater]) {
                indexHeater++;
            }
            int minDistance = Integer.MAX_VALUE;
            if (indexHeater-1 >=0) {
                minDistance = Math.min(house-heaters[indexHeater-1], minDistance);
            }
            if (indexHeater<heaters.length) {
                minDistance = Math.min(heaters[indexHeater] - house, minDistance);
            }
            res = Math.max(res, minDistance);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        int[] houses = {1,2,3};
        int[] heaters = {2};
        s.findRadius(houses, heaters);
    }
}
