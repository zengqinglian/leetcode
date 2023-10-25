package reachaNumber;
/*
Runtime
2 ms
Beats
40.8%
Memory
39.3 MB
Beats
26.34%
 */
public class Solution1 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int total = 0;
        int index = 1;
        while(total < target) {
            total = total + index;
            if (total == target) {
                return index;
            }
            index++;
        }

        if ((total-target) %2==0) {
            return index-1;
        }else {
            while((total - target) %2 ==1 ) {
                total = total + index;
                index++;
            }
            return index-1;
        }

    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.reachNumber(2);
    }
}
