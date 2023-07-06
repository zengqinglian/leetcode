package basicCalculatorII;

import java.util.LinkedList;
/*
Runtime
55 ms
Beats
15.27%
Memory
80.3 MB
Beats
5.8%
 */
public class Solution {
    public int calculate(String s) {
        LinkedList<String> ll = new LinkedList<>();

        int num = 0;
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c=='+' || c=='-' || c=='*' || c=='/') {
                ll.add(String.valueOf(num));
                ll.add(String.valueOf(c));
                num = 0;
            }else if (c!=' ') {
                num = num * 10 + (c-'0');
            }
        }
        ll.add(String.valueOf(num));
        if (ll.size() == 1) {
            return Integer.parseInt(ll.pollFirst());
        }
        int size = ll.size();
        for (int i=0; i<size-1; i+=2) {
            String first = ll.pollFirst();
            String op = ll.pollFirst();
            int second = Integer.parseInt(ll.peekFirst());
            if (op.equals( "*")) {
                ll.pollFirst();
                ll.push(String.valueOf(Integer.parseInt(first)*second));

            }else if (op.equals( "/")) {
                ll.pollFirst();
                ll.push(String.valueOf(Integer.parseInt(first)/second));

            }else {
                ll.add(first);
                ll.add(op);
            }
        }
        if (ll.size()==1) {
            return Integer.parseInt(ll.pollFirst());
        }
        ll.add(ll.pollFirst());
        int res = 0;
        while(ll.size()>1) {
            int first = Integer.parseInt(ll.pollFirst());
            String op = ll.pollFirst();
            int second = Integer.parseInt(ll.pollFirst());
            if (op.equals( "+")){
                res = (first + second);
            }else {
                res = (first - second);
            }
            ll.push(String.valueOf(res));
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.calculate(" 3+5 / 2*5-2  ");
    }
}
