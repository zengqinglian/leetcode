package kthSmallestNumberinMultiplicationTable;

public class Solution1 {
  // Proper solution from forum.
  // ** useful algo. o(N) solution to find number of result smaller than K in
  // multiplication table
  public int findKthNumber(int m, int n, int k) {
    int lo = 1, hi = m * n;
    int mid = 0;

    while (lo <= hi) {
      mid = (hi + lo) / 2;
      int cnt = countNumber(m, n, mid);
      if (cnt >= k) {
        hi = mid - 1;
      } else {
        lo = mid + 1;
      }
    }

    return lo;
  }

  // O(N) to find out number of digit smaller than K in multiplication table.
  // not O(m*n)
  private int countNumber(int m, int n, int val) {
    int count = 0;
    for (int i = 1; i <= m; i++) {
      count += Math.min(n, val / i);
    }
    return count;
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    s.findKthNumber(42, 34, 401);
  }
}
