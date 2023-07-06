package bitwiseANDofNumbersRange;
/*
Runtime
7 ms
Beats
15.81%
Memory
43.4 MB
Beats
9.92%
 */
public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if (left == right) {
            return left;
        }
        String leftStr = Integer.toBinaryString(left);
        String rightStr = Integer.toBinaryString(right);

        if (leftStr.length() != rightStr.length()) {
            return 0;
        }

        int value = 0;
        boolean flag = true;
        for (int i=0; i<rightStr.length(); i++) {
            if (flag && rightStr.charAt(i) == leftStr.charAt(i)) {
                value = value << 1;
                if (rightStr.charAt(i)=='1') {
                    value++;
                }
            }else{
                value = value << 1;
                flag = false;
            }
        }
        return value;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        s.rangeBitwiseAnd(10, 11);
    }
}
