package maximumSideLength;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //200ms solution. beat 3%
    public int maxSideLength(int[][] mat, int threshold) {
        int len = 0;
        for(int x = 0; x<mat.length; x++){
            for(int y=0; y<mat[0].length; y++){
                int initX = x + len + 1;
                int initY = y + len + 1;
                Queue<int[]>  q = new LinkedList<>();
                int total = 0;
                if(initX<mat.length && initY<mat[0].length){
                    for(int i=x; i<initX; i++){
                        for(int j=y; j<initY; j++){
                            if(i==initX-1 && j!= initY-1){
                                int[] p = {i, j, 1};
                                q.add(p);
                            }
                            if(i != initX-1 && j == initY-1){
                                int[] p = {i, j, 2};
                                q.add(p);
                            }
                            if(i == initX-1 && j == initY-1){
                                int[] p = {i, j, 3};
                                q.add(p);
                            }
                            total += mat[i][j];
                            if(total>threshold){
                                q.clear();
                                break;
                            }
                        }
                    }
                    if(!q.isEmpty()){
                        len = len+1;
                        while(!q.isEmpty()){
                            int size = q.size();
                            int newTotal = 0;
                            boolean breakout = false;
                            for(int i=0;i<size; i++){
                                int[] p = q.poll();
                                if(p[2] == 1){
                                    p[0] = p[0]+1;
                                    if(p[0] >= mat.length){
                                        breakout = true;
                                        break;
                                    }
                                    newTotal+=mat[p[0]][p[1]];
                                    q.add(p);
                                }
                                if(p[2] == 2){
                                    p[1] = p[1]+1;
                                    if(p[1] >= mat[0].length){
                                        breakout = true;
                                        break;
                                    }
                                    newTotal+=mat[p[0]][p[1]];
                                    q.add(p);
                                }
                                if(p[2] == 3){
                                    int[] newP1 = {p[0]+1, p[1], 1};
                                    newTotal += mat[newP1[0]][newP1[1]];
                                    if(newP1[0] >= mat.length){
                                        breakout = true;
                                        break;
                                    }
                                    q.add(newP1);
                                    int[] newP2 = {p[0], p[1]+1, 2};
                                    if(newP2[1] >= mat[0].length){
                                        breakout = true;
                                        break;
                                    }
                                    newTotal += mat[newP2[0]][newP2[1]];
                                    q.add(newP2);
                                    p[0] = p[0] +1;
                                    p[1] = p[1] +1;
                                    q.add(p);
                                    newTotal += mat[p[0]][p[1]];
                                }
                            }
                            if( breakout ){
                                q.clear();
                                break;
                            }
                            if(total + newTotal < threshold){
                                len++;
                                total = total+newTotal;
                            }
                            if(total + newTotal == threshold){
                                len++;
                                break;
                            }
                            if(total + newTotal > threshold){
                                break;
                            }
                        }
                    }
                }
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] mat ={{18,70},{61,1},{25,85},{14,40},{11,96},{97,96},{63,45}};
        s.maxSideLength(mat, 40184);
    }
}
