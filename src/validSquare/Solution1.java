package validSquare;

public class Solution1 {
  // beat 60% solution
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    int a1_x = p1[0] - p2[0];
    int a1_y = p1[1] - p2[1];

    int b1_x = p1[0] - p3[0];
    int b1_y = p1[1] - p3[1];

    int c1_x = p1[0] - p4[0];
    int c1_y = p1[1] - p4[1];

    if (a1_x * a1_x + a1_y * a1_y == b1_x * b1_x + b1_y * b1_y
        && a1_x * a1_x + a1_y * a1_y + b1_x * b1_x + b1_y * b1_y == c1_x * c1_x + c1_y * c1_y
        && a1_x * a1_x + a1_y * a1_y > 0 && p1[0] + p4[0] == p2[0] + p3[0]
        && p1[1] + p4[1] == p2[1] + p3[1]) {
      return true;
    }

    if (a1_x * a1_x + a1_y * a1_y == c1_x * c1_x + c1_y * c1_y
        && a1_x * a1_x + a1_y * a1_y + c1_x * c1_x + c1_y * c1_y == b1_x * b1_x + b1_y * b1_y
        && a1_x * a1_x + a1_y * a1_y > 0 && p1[0] + p3[0] == p2[0] + p4[0]
        && p1[1] + p3[1] == p2[1] + p4[1]) {
      return true;
    }

    if (c1_x * c1_x + c1_y * c1_y == b1_x * b1_x + b1_y * b1_y
        && c1_x * c1_x + c1_y * c1_y + b1_x * b1_x + b1_y * b1_y == a1_x * a1_x + a1_y * a1_y
        && c1_x * c1_x + c1_y * c1_y > 0 && p1[0] + p2[0] == p3[0] + p4[0]
        && p1[1] + p2[1] == p4[1] + p3[1]) {
      return true;
    }

    return false;

  }

  public static void main(String[] args) {

    int[] p1 = {0, 1};
    int[] p2 = {1, 2};
    int[] p3 = {0, 2};
    int[] p4 = {0, 0};

    Solution1 s = new Solution1();
    s.validSquare(p1, p2, p3, p4);
  }
}
