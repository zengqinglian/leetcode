package uTF8Validation;

public class Solution {
    public boolean validUtf8(int[] data) {
        if (data.length == 0) {
            return false;
        }

        int index = 0;
        while (index < data.length) {
            int findLength = checkLength(data[index]);
            if (findLength == -1) {
                return false;
            } else if (findLength == 0 && index == data.length - 1) {
                return true;
            } else if (index + findLength > data.length - 1) {
                return false;
            } else {
                for (int i = 1; i <= findLength; i++) {
                    if (!checkNumber(data[index + i])) {
                        return false;
                    }
                }

            }
            index += findLength + 1;
        }
        return true;
    }

    private boolean checkNumber(int i) {
        if ((i & 192) == 128) {
            return true;
        }
        return false;
    }

    private int checkLength(int i) {
        if (i <= 0x7F) {
            return 0;
        } else if (i >= 192 && i <= 223) {
            return 1;
        } else if (i >= 0xE0 && i <= 0xEF) {
            return 2;
        } else if (i >= 0xF0 && i <= 0xF7) {
            return 3;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 39, 89, 227, 83, 132, 95, 10, 0 };
        s.validUtf8(nums);

    }
}
