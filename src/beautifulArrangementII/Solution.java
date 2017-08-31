package beautifulArrangementII;

public class Solution {
  public int[] constructArray(int n, int k) {
    // Solution beat 75%
    int[] result = new int[n];

    result[0] = 1;

    int index = 1;
    int i = 2, j = n;

    while (k > 1) {
      if (result[index - 1] <= n / 2) {
        result[index] = j;
        j--;
      } else {
        result[index] = i;
        i++;
      }
      index++;
      k--;
    }

    if (result[index - 1] <= n / 2) {
      for (int m = index; m < n; m++) {
        result[m] = i;
        i++;
      }
    } else {
      for (int m = index; m < n; m++) {
        result[m] = j;
        j--;
      }
    }

    return result;

  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.constructArray(6, 1);
  }

}
