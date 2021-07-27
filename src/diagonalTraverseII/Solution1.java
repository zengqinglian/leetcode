package diagonalTraverseII;

import java.util.List;
import java.util.TreeSet;

/*
Runtime: 71 ms, faster than 25.04% of Java online submissions for Diagonal Traverse II.
Memory Usage: 71 MB, less than 43.59% of Java online submissions for Diagonal Traverse II.
 */
public class Solution1 {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        TreeSet<Node> set = new TreeSet<>((a,b)->{
            int res = Integer.compare(a.rank, b.rank);
            if(res!=0){
                return res;
            }
            return Integer.compare(a.col, b.col);
        });
        for(int i=0; i<nums.size();i++){
            for(int j=0; j<nums.get(i).size(); j++){
                set.add(new Node(i,j,nums.get(i).get(j)));
            }
        }
        int[] res = new int[set.size()];
        int idx=0;
        for(Node node : set){
            res[idx++] = node.val;
        }
        return res;
    }
    private static class Node{
        int row;
        int col;
        int val;
        int rank;
        Node(int row, int col, int val){
            this.row = row;;
            this.col = col;
            this.rank = row+col;
            this.val = val;

        }
    }
}
