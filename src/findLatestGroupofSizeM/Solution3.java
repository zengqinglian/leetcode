package findLatestGroupofSizeM;
/*

Someone's Union Find solution

Runtime: 27 ms, faster than 68.64% of Java online submissions for Find Latest Group of Size M.
Memory Usage: 85.2 MB, less than 59.32% of Java online submissions for Find Latest Group of Size M.
 */
public class Solution3 {
  public int findLatestStep(int[] arr, int m) {
    DSU dsu = new DSU(arr.length);

    int[] state = new int[arr.length];
    int step = -1;

    int countMGroups = 0;
    for(int i = 0; i < arr.length; i++) {
      int e = arr[i];
      int idx = e - 1;

      if(idx > 0 && state[idx - 1] == 1) {
        if(dsu.size[dsu.find(idx - 1)] == m)
          countMGroups--;

        dsu.union(idx, idx - 1);
      }

      if(idx < arr.length - 1 && state[idx + 1] == 1) {
        if(dsu.size[dsu.find(idx + 1)] == m)
          countMGroups--;

        dsu.union(idx, idx + 1);
      }

      if(dsu.size[dsu.find(idx)] == m) {
        countMGroups++;
      }

      if(countMGroups > 0) {
        step = i + 1;
      }

      state[idx] = 1;
    }

    return step;
  }
}

class DSU {
  int[] par = null;
  int[] size = null;
  int cnt = 0;

  public DSU(int len) {
    this.par = new int[len];
    this.size = new int[len];
    for (int i = 0; i < len; ++i) {
      this.par[i] = i;
      this.size[i] = 1;
    }
    this.cnt = len;
  }

  public int find(int x) { // Recursive = Path Compression
    if (this.par[x] != x) this.par[x] = this.find(this.par[x]);
    return this.par[x];
  }

  public boolean union(int x, int y) {
    int a = find(x);
    int b = find(y);
    if (a != b) {
      if (size[a] < size[b]) {
        int tmp = a;
        a = b;
        b = tmp;
      }
      par[b] = a;
      size[a] += size[b];

      cnt--;

      return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Solution3 s = new Solution3();
    int[] arr = {3,5,1,2,4};
    s.findLatestStep(arr, 1);
  }
}
