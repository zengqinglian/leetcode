package superPow;

public class Solution {
    public int superPow(int a, int[] b) {
        long result = 1;
        for (int i = 0; i < b[b.length - 1]; i++) {
            result = (result * a) % 1337;
        }
        long help = a;

        for (int i = b.length - 2; i >= 0; i--) {
            long tmp = help;
            for (int j = 0; j < 9; j++) {
                help = (help * tmp) % 1337;
            }
            tmp = help; // this is the remain for a pow 10 % 1337
            for (int j = 0; j < b[i] - 1; j++) {
                tmp = (help * tmp) % 1337;
            }
            if (b[i] != 0) {
                result = (result * tmp) % 1337;
            }
        }
        return (int) result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[] b = { 9, 7, 3 };
        s.superPow(2, b);
    }


}
