package sequentialDigits;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //1ms solution , beat 90%
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        int total = 0;
        //find first
        int val = low;
        int start = 0;
        int len = 0;
        while(val>0){
            start = val % 10;
            val = val /10;
            len++;
        }

        while(total < 123456789){
            boolean over = false;
            total = 0;
            int pre = start;
            for(int i=0; i<len; i++){
                total = total*10 + pre;
                pre++;
                if(pre == 10 && i!=len-1){
                    over = true;
                    break;
                }
            }
            if(!over){
                if(total>=low && total<=high){
                    res.add(total);
                    start++;
                    if(total == 123456789 || total>high){
                        break;
                    }

                }else{
                    start++;
                }
            }else{
                start = 1;
                len++;
            }
        }
        return res;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.sequentialDigits(178546104, 812704742);
    }
}
