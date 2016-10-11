package lexicographicalNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 450ms solution. speed is bottom 10%
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        temp.add(1);
        result.add(1);

        // init temp
        while (temp.get(temp.size() - 1) * 10 <= n) {
            temp.add(temp.get(temp.size() - 1) * 10);
            result.add(temp.get(temp.size() - 1));
        }

        int index = temp.size() - 1;
        while (result.size() < n) {
            if (result.size() == 14958) {
                System.out.println("test");
            }
            addValue(temp, index, result, n);
        }

        return result;

    }

    private void addValue(List<Integer> temp, int index, List<Integer> result, int target) {
        int val = temp.get(index);
        if ((val + 1) % 10 == 0) {
            if (index == 0) {
                return;
            } else {
                addValue(temp, index - 1, result, target);
                if (val + 1 < target) {
                    temp.set(index, val + 1);
                    result.add(val + 1);
                }
            }
        } else if (val + 1 <= target) {
            temp.set(index, val + 1);
            result.add(val + 1);
        } else {
            addValue(temp, index - 1, result, target);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.lexicalOrder(14959);
    }

}
