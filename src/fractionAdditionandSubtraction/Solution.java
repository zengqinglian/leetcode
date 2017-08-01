package fractionAdditionandSubtraction;

import java.util.LinkedList;

public class Solution {
  // beat 65% solution
  public String fractionAddition(String expression) {
    LinkedList<String> f = new LinkedList<>();
    int index = 0;
    String temp = "";
    while (index < expression.length()) {

      if (expression.charAt(index) != '+' && expression.charAt(index) != '-' || temp.equals("")) {
        temp += expression.charAt(index);
      } else {
        f.add(temp);
        f.add(String.valueOf(expression.charAt(index)));
        temp = "";
      }
      index++;
    }

    f.add(temp);

    return calculate(f);
  }

  private String calculate(LinkedList<String> f) {
    String temp = "";
    if (f.size() == 1) {
      temp = f.get(0);
    } else {
      temp = getResult(f.get(0), f.get(1), f.get(2));
    }
    for (int i = 3; i < f.size(); i = i + 2) {
      temp = getResult(temp, f.get(i), f.get(i + 1));
    }
    if (temp.contains("/")) {
      return changeFormat(temp);
    }
    return temp + "/1";
  }

  private String changeFormat(String temp) {
    String[] s = temp.split("/");
    int u = Integer.valueOf(s[0]);
    int d = Integer.valueOf(s[1]);

    int gcd = GCD(Math.abs(u), Math.abs(d));

    return u / gcd + "/" + d / gcd;

  }

  private int GCD(int a, int b) {
    if (b == 0)
      return a;
    return GCD(b, a % b);
  }

  private String getResult(String s1, String op, String s2) {
    int u1 = 0;
    int d1 = 1;
    if (s1.contains("/")) {
      String[] s = s1.split("/");
      u1 = Integer.valueOf(s[0]);
      d1 = Integer.valueOf(s[1]);
    } else {
      u1 = Integer.valueOf(s1);
    }

    int u2 = 0;
    int d2 = 1;
    if (s2.contains("/")) {
      String[] s = s2.split("/");
      u2 = Integer.valueOf(s[0]);
      d2 = Integer.valueOf(s[1]);
    } else {
      u2 = Integer.valueOf(s2);
    }

    String result = "";
    if (d1 == d2) {
      if (op.equals("+"))
        result = (u1 + u2) + "/" + d1;
      else
        result = (u1 - u2) + "/" + d1;
    } else {
      int ru = 0;
      if (op.equals("+"))
        ru = u1 * d2 + u2 * d1;
      else
        ru = u1 * d2 - u2 * d1;
      int rd = d1 * d2;
      result = ru + "/" + rd;
    }
    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.fractionAddition("8/3+1/1-8/3");
  }
}
