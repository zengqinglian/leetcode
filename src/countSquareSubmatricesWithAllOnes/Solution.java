package countSquareSubmatricesWithAllOnes;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //Timelimit over solution, failed 28/32
    public int countSquares(int[][] matrix) {
        int total = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                int squareSize = 0;
                boolean[][] visited = new boolean[matrix.length][matrix[0].length];
                Queue<Node> q = new LinkedList<>();
                if(!visited[i][j] && matrix[i][j]==1){
                    visited[i][j] = true;
                    Node node = new Node();
                    node.x = i;
                    node.y = j;
                    node.direction = 3;
                    q.add(node);
                    squareSize = 1;
                }
                boolean needBreak = false;
                while(!q.isEmpty()){
                    int size = q.size();
                    for(int n=0; n<size; n++){
                        Node old = q.poll();
                        int newX = old.x + 1;
                        int newY = old.y + 1;
                        if(newX >= matrix.length || newY >= matrix[0].length){
                            needBreak = true;
                            break;
                        }
                        if(old.direction == 1 || old.direction ==3){
                            if(newX < matrix.length){
                                if(!visited[newX][old.y]){
                                    if(matrix[newX][old.y] == 1) {
                                        Node newNode = new Node();
                                        newNode.x = newX;
                                        newNode.y = old.y;
                                        newNode.direction = 1;
                                        q.add(newNode);
                                        visited[newX][old.y] = true;
                                    }else{
                                        needBreak = true;
                                        break;
                                    }
                                }
                            }
                        }
                        if(old.direction == 2 || old.direction ==3){
                            if(newY < matrix[0].length){
                                if(!visited[old.x][newY]){
                                    if(matrix[old.x][newY] == 1) {
                                        Node newNode = new Node();
                                        newNode.x = old.x;
                                        newNode.y = newY;
                                        newNode.direction = 2;
                                        q.add(newNode);
                                        visited[old.x][newY] = true;
                                    }else{
                                        needBreak = true;
                                        break;
                                    }
                                }
                            }
                        }
                        if(old.direction == 3){
                            if(newY < matrix[0].length && newX < matrix.length){
                                if(!visited[newX][newY]){
                                    if(matrix[newX][newY] == 1) {
                                        Node newNode = new Node();
                                        newNode.x = newX;
                                        newNode.y = newY;
                                        newNode.direction = 3;
                                        q.add(newNode);
                                        visited[newX][newY] = true;
                                    }else{
                                        needBreak = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if(needBreak){
                        q.clear();
                        break;
                    }
                    squareSize++;
                }

                total += squareSize;

            }
        }
        return total;
    }

    private static class Node {
        private int x;
        private int y;
        private int direction;
    }
}
