package evaluateDivision;

import java.util.*;
/*
Runtime
1 ms
Beats
94.55%
Memory
41.3 MB
Beats
20.42%
 */
public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> equationMap = new HashMap<>();
        for (int i=0; i<equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            Map<String, Double> mapA = equationMap.get(a);
            if (mapA == null) {
                mapA = new HashMap<>();
                equationMap.put(a, mapA);
            }
            mapA.put(b, values[i]);


            Map<String, Double> mapB = equationMap.get(b);
            if (mapB == null) {
                mapB = new HashMap<>();
                equationMap.put(b, mapB);
            }
            mapB.put(a, 1/values[i]);
        }
        double[] res = new double[queries.size()];
        for (int idx =0; idx<queries.size(); idx++) {
            String x = queries.get(idx).get(0);
            String y = queries.get(idx).get(1);
            if (!equationMap.containsKey(x) || !equationMap.containsKey(y)) {
                res[idx] = -1d;
                continue;
            }
            if (x.equals(y)) {
                res[idx] = 1d;
                continue;
            }
            Queue<Node> q= new LinkedList<>();
            q.add(new Node(x, 1));
            Set<String> visited = new HashSet<>();
            visited.add(x);
            boolean found = false;
            while (!q.isEmpty()){
                int size = q.size();
                for (int i=0; i<size; i++) {
                    Node cur = q.poll();
                    Map<String, Double> map = equationMap.get(cur.str);
                    if (map.containsKey(y)) {
                        res[idx] = map.get(y) * cur.val;
                        found = true;
                        break;
                    }else{
                        for (String key : map.keySet()) {
                            if (!visited.contains(key)) {
                                q.add(new Node(key, cur.val * map.get(key)));
                                visited.add(key);
                            }
                        }
                    }
                }
                if (found) {
                    break;
                }else{
                    res[idx] = -1d;
                }
            }
        }
        return res;
    }
    private static class Node {
        String str;
        double val;

        Node(String str , double val) {
            this.str = str;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> e1 = Arrays.asList("a", "b");
        List<String> e2 = Arrays.asList("b", "c");
        List<List<String>> equations = Arrays.asList(e1, e2);
        double[] values = {2.0,3.0};
        List<List<String>> queries =
                Arrays.asList(Arrays.asList("a","c"), Arrays.asList("b","a"), Arrays.asList("a","e"),Arrays.asList("a","a"));
        s.calcEquation(equations,values,queries);
    }
}
