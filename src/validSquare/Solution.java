package validSquare;

import java.util.Arrays;

public class Solution {
  // two group of point - p1.x + p2.x == p3.x+p4.x p1.y+p2.y==3.y+p4.y.
  // 90 degree angle
  // slow solution beat 5% only
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    int[][] arr = new int[4][];
    arr[0] = p1;
    arr[1] = p2;
    arr[2] = p3;
    arr[3] = p4;

    Arrays.sort(arr, (x, y) -> {
      if (x[0] - y[0] != 0) {
        return x[0] - y[0];
      } else {
        return x[1] - y[1];
      }
    });

    if (arr[0][0] + arr[3][0] != arr[1][0] + arr[2][0]
        || arr[0][1] + arr[3][1] != arr[1][1] + arr[2][1]) {
      return false;
    }

    // 90 degree angle
    int a0 = Math.abs(arr[0][0] - arr[1][0]);
    int a1 = Math.abs(arr[0][1] - arr[1][1]);

    int b0 = Math.abs(arr[0][0] - arr[2][0]);
    int b1 = Math.abs(arr[0][1] - arr[2][1]);

    int c0 = Math.abs(arr[1][0] - arr[2][0]);
    int c1 = Math.abs(arr[1][1] - arr[2][1]);

    if (a0 * a0 + a1 * a1 + b0 * b0 + b1 * b1 == c0 * c0 + c1 * c1
        && a0 * a0 + a1 * a1 == b0 * b0 + b1 * b1 && a0 * a0 + a1 * a1 > 0) {
      return true;
    } else {
      return false;
    }

  }

  public static void main(String[] args) {

    int[] p1 = {0, 1};
    int[] p2 = {1, 2};
    int[] p3 = {0, 2};
    int[] p4 = {0, 0};

    Solution s = new Solution();
    s.validSquare(p1, p2, p3, p4);
  }
}
