package redundantConnection;

public class Solution2 {
  int MAX_EDGE_VAL = 2000;

  public int[] findRedundantConnection(int[][] edges) {
    DSU dsu = new DSU(MAX_EDGE_VAL + 1);
    for (int[] edge : edges) {
      if (!dsu.union(edge[0], edge[1]))
        return edge;
    }
    throw new AssertionError();
  }

  private static class DSU {
    int[] parent;
    int[] rank;

    public DSU(int size) {
      parent = new int[size];
      for (int i = 0; i < size; i++)
        parent[i] = i;
      rank = new int[size];
    }

    public int find(int x) {
      if (parent[x] != x)
        parent[x] = find(parent[x]);
      return parent[x];
    }

    public boolean union(int x, int y) {
      int xr = find(x), yr = find(y);
      if (xr == yr) {
        return false;
      } else if (rank[xr] < rank[yr]) {
        parent[xr] = yr;
      } else if (rank[xr] > rank[yr]) {
        parent[yr] = xr;
      } else {
        parent[yr] = xr;
        rank[xr]++;
      }
      return true;
    }
  }

  public static void main(String[] args) {
    Solution2 s = new Solution2();
    int[][] edges =
        { {3, 7}, {1, 4}, {2, 8}, {1, 6}, {7, 9}, {6, 10}, {1, 7}, {2, 3}, {8, 9}, {5, 9}};
    s.findRedundantConnection(edges);
  }
}
