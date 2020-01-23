package minimumRemovetoMakeValidParentheses;

import java.util.Stack;

public class Solution {
    //25ms solution , beat 50%
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] checks = new boolean[s.length()];

        for(int i= 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stack.push(i);
            }else if(c==')'){
                if(stack.isEmpty()){
                    checks[i] = true;
                }else{
                    stack.pop();
                }
            }
        }
        while(!stack.isEmpty()){
            checks[stack.pop()]=true;
        }
        StringBuilder sb = new StringBuilder(s.length());
        for(int i=0; i<checks.length; i++){
            if(!checks[i]){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
