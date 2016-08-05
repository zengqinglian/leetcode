package combinationSumIV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//1st solution too slow.
public class Solution {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        List<Integer> totalList = new ArrayList<>();
        int total = 0;

        for (int i : nums) {

                if (i < target) {
                    totalList.add(i);
                } else if (i == target) {
                    total++;
                } else {
                    break;
                }

        }

        while (!totalList.isEmpty()) {
            List<Integer> newList = new ArrayList<>();
            for(int i:nums){
                if (i < target) {
                    for(int j=0; j<totalList.size() ; j++){
                        int val = totalList.get(j);
                        if(i+val<target){
                            newList.add(i + val);
                        } else if (i + val == target) {
                            total++;
                        }
                    }
                }
            }
            totalList = newList;
        }

        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 4, 2, 1 };
        s.combinationSum4(nums, 9);
    }


}
