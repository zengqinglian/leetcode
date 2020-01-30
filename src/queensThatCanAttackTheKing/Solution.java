package queensThatCanAttackTheKing;

import java.util.*;
//2m solution , beat 50%
public class Solution {
    int[] X = {1,1,0,-1,-1,-1,0,1};
    int[] Y = {0,1,1,1,0,-1,-1,-1};
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] board = new int[8][8];
        for(int[] q : queens){
            board[q[0]][q[1]] = 1;
        }
        Queue<int[]> q = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0; i<8; i++){
            int newX = king[0] + X[i];
            int newY = king[1] + Y[i];
            if(newX>=0 && newX<8 && newY>=0 && newY<8){
                if(board[newX][newY] ==0) {
                    int[] pos = {newX, newY};
                    q.add(pos);
                }else{
                    q.add(null);
                    res.add(Arrays.asList(newX, newY));
                }
            }else{
                q.add(null);
            }
        }

        while(true){
            boolean allNull = true;
            for(int i=0; i<8; i++){
                int[] pos = q.poll();
                if(pos == null){
                    q.add(null);
                }else{
                    int newX = pos[0] + X[i];
                    int newY = pos[1] + Y[i];
                    if(newX>=0 && newX<8 && newY>=0 && newY<8){
                        if(board[newX][newY] ==0) {
                            int[] newPos = {newX, newY};
                            q.add(newPos);
                            allNull = false;
                        }else{
                            q.add(null);
                            res.add(Arrays.asList(newX, newY));
                        }
                    }else{
                        q.add(null);
                    }
                }
            }
            if(allNull){
                return res;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] queues = {{0,1},{1,0},{4,0},{0,4},{3,3},{2,4}};
        int[] king = {0,0};
        s.queensAttacktheKing(queues,king);
    }
}
