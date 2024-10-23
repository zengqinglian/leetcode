package jumpGamevii;
/*
Runtime
2178 ms
Beats
5.16%
Analyze Complexity
Memory
45.61 MB
Beats
55.98%

 */
public class Solution1 {
    public boolean canReach(String s, int minJump, int maxJump) {
        if (s.charAt(s.length()-1)=='1'){
            return false;
        }
        if (maxJump == s.length()-1) {
            return true;
        }
        boolean[] jumps = new boolean[s.length()];
        jumps[0] = true;
        for (int i = 1 ; i<s.length(); i++) {
            if (s.charAt(i)=='1') {
                continue;
            }
            for (int j=minJump; j<=maxJump && i-j>=0; j++) {
                if (jumps[i-j]) {
                    jumps[i] = true;
                    break;
                }
            }
        }
        return jumps[s.length()-1];
    }
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        solution1.canReach("01",1,1);
    }
}
