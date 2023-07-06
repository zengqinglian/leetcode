package basicCalculatorII;

import java.util.LinkedList;

public class Solution1 {
    public int calculate(String s) {
        String validateStr = s.replace(" ","");
        String[] array = validateStr.split("[+*/-]");
        String[] ops = validateStr.split("[0-9]+");
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i=1; i<ops.length; i++) {
            String op = ops[i].trim();
            if (op.equals("*")) {
                int newVal = Integer.parseInt(array[i-1].trim()) * Integer.parseInt(array[i].trim());
                ll.add(newVal);
            }else if (op.equals("/")) {
                int newVal = Integer.parseInt(array[i-1]) / Integer.parseInt(array[i]);
                ll.add(newVal);
            }else{

            }
        }

        if (counter==0) {
            return Integer.parseInt(array[array.length-1]);
        }
        int res = 0;
        for (int i=1; i<ops.length; i++) {
            String op = ops[i].trim();
            if (op.equals("+")) {
                int newVal = Integer.parseInt(array[i-1].trim()) + Integer.parseInt(array[i].trim());
                res+=newVal;
            }else if (op.equals("-")) {
                int newVal = Integer.parseInt(array[i-1]) - Integer.parseInt(array[i]);
                res+=newVal;
            }
        }
        return res;


    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.calculate(" 3+5 / 2*5-2  ");
    }
}
