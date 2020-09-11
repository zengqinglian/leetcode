package minimumFlipstoMakeaORbEqualtoc;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //1m Solution , meet avg.
    public int minFlips(int a, int b, int c) {
        Queue<Integer> stackA = new LinkedList<>();
        Queue<Integer> stackB = new LinkedList<>();
        Queue<Integer> stackC = new LinkedList<>();
        while(a>0){
            stackA.add(a%2);
            a=a/2;
        }
        while(b>0){
            stackB.add(b%2);
            b=b/2;
        }
        while(c>0){
            stackC.add(c%2);
            c=c/2;
        }
        int flip = 0;
        while(!stackA.isEmpty() || !stackB.isEmpty() || !stackC.isEmpty()){
            int bita = 0;
            int bitb = 0;
            int bitc = 0;
            if(!stackA.isEmpty()){
                bita = stackA.poll();
            }
            if(!stackB.isEmpty()){
                bitb = stackB.poll();
            }
            if(!stackC.isEmpty()){
                bitc = stackC.poll();
            }
            if(bitc == 0){
                flip = flip + bita + bitb;
            }else{
                if(bitb==0 && bita==0){
                    flip=flip+1;
                }
            }
        }
        return flip;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minFlips(2,6,5);
    }

}
