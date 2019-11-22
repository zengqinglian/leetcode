package reverseSubstringsBetweenEachPairofParentheses;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    //2ms solution , meet avg 50%
    public String reverseParentheses(String s) {
        LinkedList<String> list = new LinkedList<>();
        StringBuffer sb = new StringBuffer();

        for(char c:s.toCharArray()){
            if(c == '('){
                list.add(String.valueOf('('));
            }else if(c==')') {
                sb.setLength(0);
                while(!list.isEmpty()){
                    String popStr = list.pollLast();
                    if(popStr.equals("(")){
                        list.add(sb.toString());
                        break;
                    }else{
                        sb.append(new StringBuilder(popStr).reverse().toString());
                    }
                }
            }else{
                list.add(String.valueOf(c));
            }
        }
        sb.setLength(0);
        while(!list.isEmpty()){
            sb.append(list.pollFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.reverseParentheses("a(bcdefghijkl(mno)p)q");
    }
}
