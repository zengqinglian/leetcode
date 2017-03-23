package numberofDigitOne;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 2ms solution
    public int countDigitOne(int n) {
        if (n <= 0) {
            return 0;
        }
        
        if(n<10){
            return 1;
        }

        int mod = n % 10;
        n = n / 10;
        int currentTotal = mod == 0 ? 0 : 1;
        int remain = mod;
        int index = 2;

        List<Integer> maxOnesArray = new ArrayList<>(20);

        maxOnesArray.add(0); // 0 position.

        maxOnesArray.add(1);
        
        while (n >= 10) {
            mod = n % 10;
            currentTotal = getTotalOnes(n % 10, index, maxOnesArray, remain, currentTotal);
            remain += (n % 10) * (int) Math.pow(10, index - 1);
            index++;
            n = n / 10;
        }
        
        return getTotalOnes(n % 10, index, maxOnesArray, remain, currentTotal);
    }

    private int getTotalOnes(int digit, int index, List<Integer> maxOnesArray, int remain,
            int currentTotal) {
        // update maxOneArrays
        int max = (int) Math.pow(10, index - 1);
        max += 10 * maxOnesArray.get(index - 1);
        maxOnesArray.add(max);
        if (digit == 0) {
            return currentTotal;
        }
        int total = 0;
        if (digit == 1) {
            total = remain + 1 + maxOnesArray.get(index - 1) + currentTotal;
        } else {
            total = (int) Math.pow(10, index - 1);// 1
            total += digit * maxOnesArray.get(index - 1);
            total += currentTotal;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.countDigitOne(2080);
    }
}
