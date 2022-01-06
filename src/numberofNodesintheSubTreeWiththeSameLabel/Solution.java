package numberofNodesintheSubTreeWiththeSameLabel;

import java.util.ArrayList;
import java.util.List;
/*
Runtime: 60 ms, faster than 89.47% of Java online submissions for Number of Nodes in the Sub-Tree With the Same Label.
Memory Usage: 470.1 MB, less than 22.81% of Java online submissions for Number of Nodes in the Sub-Tree With the Same Label.
 */
public class Solution {
    int[] res;
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        res = new int[n];

        List<Integer>[] edgeList = new List[n];
        for(int[] edge : edges) {
            if(edgeList[edge[0]]==null){
                edgeList[edge[0]] = new ArrayList<>();
            }
            edgeList[edge[0]].add(edge[1]);

            if(edgeList[edge[1]]==null){
                edgeList[edge[1]] = new ArrayList<>();
            }
            edgeList[edge[1]].add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        updateResult (visited, 0, edgeList, labels);
        return res;
    }

    private int[] updateResult(boolean[] visited, int idx, List<Integer>[] edgeList, String label) {
        char c = label.charAt(idx);
        if(edgeList[idx] != null) {
            int[] currentCount = new int[26];
            boolean isLeaf = true;
            for(int nextId : edgeList[idx]) {
                if(!visited[nextId]) {
                    isLeaf = false;
                    visited[nextId] = true;
                    int[] nextCount = updateResult(visited, nextId, edgeList, label);
                    for(int i=0; i<26; i++) {
                        currentCount[i] += nextCount[i];
                    }
                }
            }
            if(isLeaf) {
                res[idx] = 1;
                int[] ret = new int[26];
                ret[c-'a']++;
                return ret;
            }else {
                currentCount[c-'a']++;
                res[idx] = currentCount[c-'a'];
                return currentCount;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] edges = {{1,0},{2,0},{3,1},{0,4}};
        s.countSubTrees(5, edges, "aabab");
    }
}
