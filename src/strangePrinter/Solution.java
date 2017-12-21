package strangePrinter;


public class Solution {
  // very slow solution - over time limit on test case 51/108
  public int strangePrinter(String s) {
    if (s == "" || s.length() == 0) {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }

    char[] cArr = new char[s.length()];
    int result = getMinPrint(cArr, 0, s, 0);
    return result;
  }

  private int getMinPrint(char[] cArr, int startIndex, String orgStr, int curTotal) {
    if (startIndex >= orgStr.length()) {
      return curTotal;
    }
    if (cArr[startIndex] == orgStr.charAt(startIndex)) {
      return getMinPrint(cArr, startIndex + 1, orgStr, curTotal);
    }
    int total = Integer.MAX_VALUE;
    char newChar = orgStr.charAt(startIndex);
    cArr[startIndex] = newChar;

    for (int i = startIndex + 1; i < orgStr.length(); i++) {
      if (cArr[i] != orgStr.charAt(i)) {
        cArr[i] = newChar;
      } else {
        int newTotal = getMinPrint(cArr.clone(), startIndex + 1, orgStr, curTotal + 1);
        total = Math.min(total, newTotal);
        cArr[i] = newChar;
      }
    }
    return Math.min(total, getMinPrint(cArr, startIndex + 1, orgStr, curTotal + 1));
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.strangePrinter("abababaabababaabababa");
  }
}
