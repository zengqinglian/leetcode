package fallingSquares;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
  // Someone's Segment tree solution, beat 90%
  public List<Integer> fallingSquares(int[][] positions) {
    List<Integer> ans = new ArrayList<>();
    int left = 0;
    int right = 1000000000;
    if (positions.length == 0) {
      return ans;
    }
    SegNode root = new SegNode(left, right, 0);
    int oldPeek = 0;
    for (int[] rec : positions) {
      int curMax = root.query(rec[0], rec[0] + rec[1] - 1);
      // log.info("curMax on ({},{}): {}", rec[0], rec[0]+rec[1]-1,
      // curMax);

      int newMax = curMax + rec[1];
      oldPeek = Math.max(oldPeek, newMax);
      ans.add(oldPeek);
      root.insert(rec[0], rec[0] + rec[1] - 1, newMax);
    }
    return ans;
  }

  class SegNode {
    int left, mid, right;
    int max;
    boolean modified;
    SegNode leftChild, rightChild;

    SegNode(int left, int right, int max) {
      this.left = left;
      this.right = right;
      this.mid = left + (right - left) / 2;
      this.max = max;
    }

    int query(int left, int right) {
      int ans;
      if ((left <= this.left && right >= this.right) || this.leftChild == null) {
        ans = this.max;
      } else {
        pushdown();
        ans = Integer.MIN_VALUE;
        if (left <= this.mid && this.leftChild != null)
          ans = Math.max(ans, leftChild.query(left, Math.min(this.mid, right)));
        if (right > this.mid && this.rightChild != null)
          ans = Math.max(ans, rightChild.query(Math.max(this.mid + 1, left), right));
      }
      // log.info("query on ({},{}) is {}, this.left, right, max: ({}, {},
      // {})", left, right, ans, this.left,this.right,this.max);
      return ans;
    }

    void pushdown() {
      if (this.leftChild != null) {
        if (this.modified) {
          this.leftChild.modified = true;
          this.leftChild.max = max;
          this.rightChild.modified = true;
          this.rightChild.max = max;
        }
      } else {
        this.leftChild = new SegNode(left, mid, max);
        this.rightChild = new SegNode(mid + 1, right, max);

      }
    }

    void insert(int left, int right, int value) {

      // log.info("insert {}, {}, {} on ({}, {})", left, right, value,
      // this.left, this.right);
      if (left <= this.left && right >= this.right) {
        if (value > this.max) {
          this.max = Math.max(this.max, value);
          modified = true;
        }

      } else {
        pushdown();
        if (left <= mid)
          this.leftChild.insert(left, Math.min(mid, right), value);
        if (right > mid)
          this.rightChild.insert(Math.max(mid + 1, left), right, value);
        this.max = Math.max(this.leftChild.max, this.rightChild.max);
        modified = false;
      }
    }
  }

}
