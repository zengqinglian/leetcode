package kDivisibleElementsSubarrays;

import java.util.*;
/*

78 / 152 test cases passed.
time limit over
 */
public class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        int[] counter = new int[nums.length];
        int cnt = 0;

        for (int i=0; i< nums.length; i++) {
            if (nums[i] %p == 0) {
                cnt++;
            }
            counter[i] = cnt;
        }
        List<int[]> list = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int[] subArray = Arrays.copyOfRange(nums, i, i+1);
            if (!contains(list, subArray)) {
                list.add(subArray);
            }
            for(int j=i+1; j<nums.length; j++) {
                if (i==0) {
                    if (counter[j]<=k) {
                        subArray = Arrays.copyOfRange(nums, i, j + 1);
                        if (!contains(list, subArray)) {
                            list.add(subArray);
                        }
                    }else{
                        break;
                    }
                }else {
                    if (counter[j] - counter[i-1] <= k) {
                        subArray = Arrays.copyOfRange(nums, i, j + 1);
                        if (!contains(list, subArray)) {
                            list.add(subArray);
                        }
                    }else{
                        break;
                    }
                }
            }
        }
        return list.size();
    }

    private boolean contains (List<int[]> list , int[] newArray) {
        for (int[] array : list) {
            if (Arrays.equals(array, newArray)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums={1,2,3,4};
        s.countDistinct(nums, 4,1);
    }

}
