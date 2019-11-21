package smallestStringWithSwaps;

import java.util.*;

//someone's Union find solution, meet avg speed.
public class Solution1 {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        UnionFind uf = new UnionFind(s.length());
        for (List<Integer> pair : pairs) uf.union(pair.get(0), pair.get(1));

        // group node
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int root = uf.find(i);
            if (!map.containsKey(root)) map.put(root, new ArrayList<Integer>());
            map.get(root).add(i);
        }
        // sort corresponding string
        Map<Integer, String> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int root = uf.find(i);
            if (map2.containsKey(root)) continue;
            StringBuilder sb = new StringBuilder();
            for (int index : map.get(root)) sb.append(s.charAt(index));
            char[] arr = sb.toString().toCharArray();
            Arrays.sort(arr);
            String str = new String(arr);
            map2.put(root, str);
        }
        // place character
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int root = uf.find(i);
            String str = map2.get(root);
            sb.append(str.charAt(indexMap.getOrDefault(root, 0)));
            indexMap.put(root, indexMap.getOrDefault(root, 0) + 1);
        }
        return sb.toString();
    }
}

class UnionFind {
    int[] father;

    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }

    public int find(int x) {
        if (father[x] == x) return x;
        return father[x] = find(father[x]);
    }

    public void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            father[rootA] = rootB;
        }
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> p1 = createPairs(0,3);
        List<Integer> p2 = createPairs(1,2);
        pairs.add(p1);
        pairs.add(p2);
        s.smallestStringWithSwaps("dcab", pairs);
    }

    private static List<Integer> createPairs(int a, int b){
        List<Integer> p = new ArrayList<>();
        p.add(a);
        p.add(b);
        return p;
    }
}
