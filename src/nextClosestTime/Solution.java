package nextClosestTime;

import java.util.Arrays;

public class Solution {
  // 6ms solution. not sure how quick it is when compare to others
  // the question is too new
  public String nextClosestTime(String time) {
    int[] numbers = new int[4];
    numbers[0] = Integer.valueOf(time.charAt(0) - '0');
    numbers[1] = Integer.valueOf(time.charAt(1) - '0');
    numbers[2] = Integer.valueOf(time.charAt(3) - '0');
    numbers[3] = Integer.valueOf(time.charAt(4) - '0');

    int[] digits = numbers.clone();

    Arrays.sort(numbers);

    int[] base = {2, 4, 5, 9};
    int replaceIndex = 0;
    for (int i = digits.length - 1; i >= 0; i--) {
      int digit = digits[i];
      for (int j = 0; j < numbers.length; j++) {
        if (i != 1 && numbers[j] <= base[i] && numbers[j] > digit) {
          digits[i] = numbers[j];
          replaceIndex = i;
          break;
        }
        if (i == 1 && numbers[j] > digit && digits[0] * 10 + numbers[j] <= 24) {
          digits[i] = numbers[j];
          replaceIndex = i;
          break;
        }
      }
      if (replaceIndex != 0) {
        break;
      }
    }

    for (int i = replaceIndex + 1; i < digits.length; i++) {
      int digit = digits[i];
      for (int j = 0; j < numbers.length; j++) {
        if (numbers[j] < digit) {
          digits[i] = numbers[j];
          break;
        }
      }
    }

    int hour = digits[0] * 10 + digits[1];
    while (hour >= 24) {
      hour -= 24;
    }

    StringBuilder sb = new StringBuilder();
    if (hour < 10) {
      sb.append("0" + hour + ":");
    } else {
      sb.append(hour + ":");
    }

    sb.append(digits[2]).append(digits[3]);

    return sb.toString();
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.nextClosestTime("13:55");
  }
}
