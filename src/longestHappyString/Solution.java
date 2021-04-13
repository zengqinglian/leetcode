package longestHappyString;

import java.util.PriorityQueue;
/*
Runtime: 1 ms, faster than 70.96% of Java online submissions for Longest Happy String.
Memory Usage: 36 MB, less than 88.76% of Java online submissions for Longest Happy String.
 */
public class Solution {
    public String longestDiverseString(int a, int b, int c) {
        Node nodeA = new Node('a', a);
        Node nodeB = new Node('b', b);
        Node nodeC = new Node('c', c);
        PriorityQueue<Node> q = new PriorityQueue<Node>((x,y)->y.cnt-x.cnt);
        if(a>0){
            q.add(nodeA);
        }
        if(b>0){
            q.add(nodeB);
        }
        if(c>0){
            q.add(nodeC);
        }
        StringBuilder sb = new StringBuilder();
        int max_repeat = 0;
        char chr = ' ';
        while(!q.isEmpty()){
            Node node = q.poll();
            if(max_repeat == 0){
                chr = node.c;
                max_repeat++;
                node.cnt--;
                if(node.cnt > 0) {
                    q.add(node);
                }
                sb.append(node.c);
            }else if(max_repeat == 1){
                if(chr == node.c){
                    max_repeat++;
                }else{
                    max_repeat = 1;
                }
                chr = node.c;
                node.cnt--;
                if(node.cnt > 0) {
                    q.add(node);
                }
                sb.append(node.c);
            }else if(max_repeat == 2){
                if(chr != node.c){
                    chr = node.c;
                    max_repeat = 1;
                    node.cnt--;
                    if(node.cnt > 0) {
                        q.add(node);
                    }
                    sb.append(node.c);
                }else{
                    if(q.isEmpty()){
                        return sb.toString();
                    }else{
                        Node node2 = q.poll();
                        chr = node2.c;
                        max_repeat = 1;
                        node2.cnt--;
                        if(node2.cnt > 0) {
                            q.add(node2);
                        }
                        q.add(node);
                        sb.append(node2.c);
                    }
                }
            }
        }
        return sb.toString();
    }

    static class Node {
        char c;
        int cnt;
        Node(char c , int cnt){
            this.c = c;
            this.cnt = cnt;
        }


    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestDiverseString(1,1,7);
    }
}
