package minStack;

import java.util.ArrayList;
/*
Runtime
6 ms
Beats
61.25%
Memory
47.1 MB
Beats
78.90%
 */
public class MinStack {
    ArrayList<Integer> a = new ArrayList<>();
    ArrayList<Integer> b = new ArrayList<>();
    public MinStack() {

    }

    public void push(int val) {
        a.add(val);
        if( b.isEmpty()){
            b.add(val);
        }
        else if(val<b.get(b.size()-1)){
            b.add(val);
        }
    }

    public void pop() {
        if(a.isEmpty()){
            return;
        }
        int k= a.remove(a.size()-1);
        if(!a.contains(k) && b.contains(k)){
            b.remove(b.indexOf(k));
        }
    }

    public int top() {
        return a.get(a.size()-1);
    }

    public int getMin() {
        return b.get(b.size()-1);
    }

    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(-2);
        s.push(0);
        s.push(-3);
        s.getMin();
        s.pop();
        s.top();
        s.getMin();
    }
}
