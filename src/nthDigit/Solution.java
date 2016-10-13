package nthDigit;

public class Solution {
    // Math solution 5ms - meet avg
    public int findNthDigit(int n) {
        if(n<10){
            return n;
        }
        long total = 9;
        int digitPerNumber = 2;
        while (total <= n) {
            long totalNumber = (long) Math.pow(10, digitPerNumber) - (long) Math.pow(10, digitPerNumber - 1);
            total += (digitPerNumber * totalNumber);
            digitPerNumber++;
        }

        if (total == n) {
            return 9;
        }

        long diff = total - n;

        long div = diff / (digitPerNumber - 1);
        int remain = (int) (diff % (digitPerNumber - 1));

        long number = (int) Math.pow(10, digitPerNumber - 1) - 1 - div;

        if (remain == 0) {
            return (int) (number % 10);
        } else {
            return (int) findReturn(number, remain, digitPerNumber - 1);
        }
    }

    private long findReturn(long i, int remain, int digit) {
        long[] digits = new long[digit];
        long num = i;
        int index = digit - 1;
        while (num >= 10) {
            digits[index] = num % 10;
            num = num / 10;
            index--;
        }

        digits[0] = num;

        return digits[digit - remain - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findNthDigit(1000000000);

    }
}
