package removeAllAdjacentDuplicatesinStringII;

import java.util.Stack;

public class Solution {
    //16ms solution , meet avg speed
    public String removeDuplicates(String s, int k) {
        Stack<Node> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(stack.isEmpty()){
                stack.push(new Node(c));
            }else{
                Node top = stack.peek();
                if(top.c == c){
                    top.count++;
                    if(top.count == k){
                        stack.pop();
                    }
                }else{
                    stack.push(new Node(c));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            Node node = stack.pop();
            for(int i=0; i<node.count; i++)
                sb.append(node.c);
        }
        return sb.reverse().toString();
    }
    private static class Node{
        char c ;
        int count;

        Node(char c ){
            this.c= c;
            count=1;
        }


    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.removeDuplicates("abcd", 2);
    }
}
