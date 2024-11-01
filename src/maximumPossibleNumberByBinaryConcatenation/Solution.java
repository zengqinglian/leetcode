package maximumPossibleNumberByBinaryConcatenation;

import java.util.ArrayList;
import java.util.List;
/*
Runtime
11 ms
Beats
31.46%
Analyze Complexity
Memory
43.86 MB
Beats
14.06%

 */
public class Solution {
    public int maxGoodNumber(int[] nums) {
        String num1Str1 = Integer.toBinaryString(nums[0]);
        String num1Str2 = Integer.toBinaryString(nums[1]);
        String num1Str3 = Integer.toBinaryString(nums[2]);
        String[] res = new String[6];

        res[0]= num1Str1 + num1Str2 + num1Str3;
        res[1]= num1Str1 + num1Str3 + num1Str2;
        res[2]= num1Str2 + num1Str1 + num1Str3;
        res[3]= num1Str2 + num1Str3 + num1Str1;
        res[4]= num1Str3 + num1Str1 + num1Str2;
        res[5]= num1Str3 + num1Str2 + num1Str1;
        int max = 0;
        for (String str : res) {
            max = Math.max(max, Integer.parseInt(str,2));
        }
        return max;
    }
}
