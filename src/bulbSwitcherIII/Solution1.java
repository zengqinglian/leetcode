package bulbSwitcherIII;

public class Solution1 {
    //1ms , meet avg 50%
    public int numTimesAllBlue(int[] light) {
        int max = 0;
        int cnt = 0;
        int res = 0;
        for(int i : light){
            max = Math.max(i,max);
            cnt++;
            if(max == cnt){
                res++;
            }
        }
        return res;
    }
}
