package largestNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution {
    // sort solution - 130ms - beat 40-50%
    // N is the length of array
    // worst scenario NlogN*Max(length of String elements in nums)
    // Best scenario - NlogN
    public String largestNumber(int[] nums) {
        if (nums.length == 0) {
            return "";
        }
        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }
        List<char[]> list = new ArrayList<>();
        for(int i : nums){
            char[] charArray = String.valueOf(i).toCharArray();
            list.add(charArray);
        }

        Collections.sort(list, new Comparator<char[]>() {

            @Override
            public int compare(char[] o1, char[] o2) {
                int length = Math.min(o1.length, o2.length);
                for (int i = 0; i < length; i++) {                
                    if (o1[i] > o2[i]) {
                        return -1;
                    } else if (o1[i] < o2[i]) {
                        return 1;
                    } else {
                        continue;
                    }
                }

                if (o2.length == o1.length) {
                    return 0;
                } else if (o2.length > o1.length) {
                    for (int i = o1.length; i < o2.length; i++) {
                        for (int j = 0; j < o1.length; j++) {
                            if (o2[i] > o1[j]) {
                                return 1;
                            } else if (o2[i] < o1[j]) {
                                return -1;
                            } else {
                                continue;
                            }
                        }
                    }
                    return 0;
                } else {
                    for (int i = o2.length; i < o1.length; i++) {
                        for (int j = 0; j < o2.length; j++) {
                            if (o1[i] > o2[j]) {
                                return -1;
                            } else if (o1[i] < o2[j]) {
                                return 1;
                            } else {
                                continue;
                            }
                        }
                    }
                    return 0;
                }
            }
        });

        StringBuilder sb = new StringBuilder();
        for (char[] chars : list) {
            if (sb.length() == 0) {
                for (char c : chars) {
                    if (sb.length() == 0) {
                        if (c > '0')
                            sb.append(c);
                    } else {
                        sb.append(c);
                    }
                }
            } else {
                sb.append(String.copyValueOf(chars));
            }
        }

        return sb.toString().equals("") ? "0" : sb.toString();

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 12, 121 };
        s.largestNumber(nums);
    }
}
