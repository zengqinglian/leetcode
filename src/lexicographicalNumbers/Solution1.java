package lexicographicalNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    // improved solution 235ms , beat 35%
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(1);
        while (result.get(result.size() - 1) * 10 <= n) {
            result.add(result.get(result.size() - 1) * 10);
        }

        while (result.size() < n) {
            int val = result.get(result.size() - 1);
            addValue(val, result, n);
        }

        return result;
    }

    private void addValue(int val, List<Integer> result, int target) {
        if (val + 1 < 10) {
            if (val + 1 <= target) {
                result.add(val + 1);
            }
        } else {
            if ((val % 10) == 9 || val + 1 > target) {
                addValue(val / 10, result, target);
            }
            if (val + 1 <= target) {
                result.add(val + 1);
            }

        }

    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.lexicalOrder(49999);
    }
}
