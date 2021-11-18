package reorderRoutestoMakeAllPathsLeadtotheCityZero;

import java.util.*;

/*
Runtime: 28 ms, faster than 83.73% of Java online submissions for Reorder Routes to Make All Paths Lead to the City Zero.
Memory Usage: 62.7 MB, less than 69.62% of Java online submissions for Reorder Routes to Make All Paths Lead to the City Zero.
 */
public class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] group = new List[n];
        for(int[] c : connections) {
            if(group[c[0]]==null){
                group[c[0]] = new ArrayList<>();
            }
            group[c[0]].add(c);
            if(group[c[1]]==null){
                group[c[1]] = new ArrayList<>();
            }
            group[c[1]].add(c);
        }
        int res = 0;
        boolean[] arriveZero = new boolean[n];
        arriveZero[0] = true;
        LinkedList<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()) {
            int idx = q.pop();
            List<int[]> linked = group[idx];
            for(int[] arr : linked) {
                if(arriveZero[arr[0]] && arriveZero[arr[1]]){
                    continue;
                }else if(arriveZero[arr[0]] || arriveZero[arr[1]]){
                    if (!arriveZero[arr[1]]) {
                        res++;
                    }
                    if(!arriveZero[arr[0]]) {
                        q.push(arr[0]);
                        arriveZero[arr[0]] = true;
                    }
                    if(!arriveZero[arr[1]]) {
                        q.push(arr[1]);
                        arriveZero[arr[1]] = true;
                    }
                }else{
                    System.out.println("error");
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        s.minReorder(6,connections);
    }
}
