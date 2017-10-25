package solveTheEquation;

public class Solution {
  // solution beat 50%
  public String solveEquation(String equation) {
    int[] leftRecord = new int[2];
    int[] rightRecord = new int[2];

    int index = 1;

    boolean isLeft = true;
    StringBuilder sb = new StringBuilder();
    sb.append(equation.charAt(0));
    while (index < equation.length()) {
      if (equation.charAt(index) == '+' || equation.charAt(index) == '-') {
        if (isLeft) {
          update(leftRecord, sb.toString());
        } else {
          update(rightRecord, sb.toString());
        }
        sb.setLength(0);
        sb.append(equation.charAt(index));
      } else if (equation.charAt(index) == '=') {
        isLeft = false;
        update(leftRecord, sb.toString());
        index++;
        sb.setLength(0);
        sb.append(equation.charAt(index));
      } else {
        sb.append(equation.charAt(index));
      }
      index++;
    }
    update(rightRecord, sb.toString());

    int xVal = leftRecord[0] - rightRecord[0];
    int val = rightRecord[1] - leftRecord[1];

    if (xVal == 0) {
      if (val == 0) {
        return "Infinite solutions";
      } else {
        return "No solution";
      }
    } else {
      return "x" + "=" + (val / xVal);
    }

  }

  private void update(int[] record, String string) {
    boolean isX = false;
    boolean isMinus = false;
    if (string.charAt(0) == '-') {
      isMinus = true;
    }

    if (string.charAt(string.length() - 1) == 'x') {
      isX = true;
    }

    int number = 0;

    if (isX) {
      if (isMinus) {
        if (string.equals("-x")) {
          number = -1;
        } else {
          number = Integer.valueOf(string.substring(1, string.length() - 1)) * -1;
        }
      } else {
        if (string.equals("x") || string.equals("+x")) {
          number = 1;
        } else {
          number = Integer.valueOf(string.substring(0, string.length() - 1));
        }
      }
      record[0] = record[0] + number;
    } else {
      if (isMinus) {
        number = Integer.valueOf(string.substring(1, string.length())) * -1;
      } else {
        number = Integer.valueOf(string.substring(0, string.length()));
      }
      record[1] = record[1] + number;
    }

  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.solveEquation("x+5-3+x=6+x-2");
  }
}
