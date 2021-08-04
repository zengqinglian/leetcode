package minimumTimetoCollectAllApplesinaTree;

import java.util.Arrays;
import java.util.List;

/*
Runtime: 4 ms, faster than 99.59% of Java online submissions for Minimum Time to Collect All Apples in a Tree.
Memory Usage: 73.5 MB, less than 99.19% of Java online submissions for Minimum Time to Collect All Apples in a Tree.
 */
public class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        boolean[] visited = new boolean[n];
        int[] parents = new int[n];
        Arrays.fill(parents,-1);
        for(int[] edge : edges) {
            if(parents[edge[1]]==-1)
                parents[edge[1]] = edge[0];
            if(parents[edge[0]]==-1)
                parents[edge[0]] = edge[1];
        }
        int cnt = 0;
        for(int i = hasApple.size()-1; i>=0; i--){
            if(hasApple.get(i)){
                cnt+=returnToZero(parents, visited,  i);
            }
        }
        return cnt;
    }

    private int returnToZero(int[] parents, boolean[] visited, int i) {
        if(i==0){
            return 0;
        }
        if(!visited[i]){
            visited[i] = true;
            return 2 + returnToZero(parents, visited, parents[i]);
        }else{
            return 0;
        }
    }
}
