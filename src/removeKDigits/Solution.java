package removeKDigits;

public class Solution {

    // 110ms solution - slow beat 15% only
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }

        String newNum = num;
        while (k > 0) {
            newNum = removeHelp(newNum);
            k--;
        }

        return removeHeadZero(newNum);
    }

    private String removeHeadZero(String newNum) {
        int length = newNum.length();
        int index = 0;
        while (index < length && newNum.charAt(index) == '0') {
            index++;
        }

        if (index > length - 1) {
            return "0";
        } else {
            return newNum.substring(index);
        }
    }

    private String removeHelp(String num) {
        int length = num.length();
        if (length == 2) {
            if (num.charAt(0) >= num.charAt(1)) {
                return num.substring(1);
            } else {
                return num.substring(0, 1);
            }
        }
        int index = 0;

        while (index < length - 1) {
            if (num.charAt(index) > num.charAt(index + 1)) {
                if (index == 0) {
                    return num.substring(index + 1);
                } else {
                    return num.substring(0, index) + num.substring(index + 1);
                }
            } else {
                index++;
            }
        }

        return num.substring(0, length - 1);

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.removeKdigits("10200", 1);
    }
}
