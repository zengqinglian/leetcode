package combinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();

        getCombinations(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
        
    }

    private void getCombinations(int[] candidates, int index, int target, List<Integer> temp,
            List<List<Integer>> result) {
        if (index >= candidates.length) {
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[index] < target) {
                List<Integer> newTemp = new ArrayList<>(temp);
                newTemp.add(candidates[i]);
                getCombinations(candidates, i, target - candidates[i], newTemp, result);
            }
            if (candidates[i] == target) {
                temp.add(candidates[i]);
                result.add(temp);
                return;
            }
            if (candidates[i] > target) {
                return;
            }
        }
        
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] candidates = { 2, 3, 6, 7 };
        s.combinationSum(candidates, 7);
    }

}
