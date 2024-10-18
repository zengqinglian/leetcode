package fairDistributionofCookies;
/*
Runtime
0ms
Beats 100.00%
Analyze Complexity
Memory
40.92 MB
Beats
41.06%
 */
public class Solution1 {
    private int res = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int[] distributes = new int[k];
        helper(cookies, 0, distributes );
        return res;
    }

    private void helper(int[] cookies, int cookieIndex, int[] distributes) {
        if (cookieIndex == cookies.length-1) {
            for (int i = 0; i < distributes.length; i++) {
                if (distributes[i] >0) {
                    distributes[i]+=cookies[cookieIndex];
                    res = calculateRes(distributes);
                    distributes[i]-=cookies[cookieIndex];
                }else{
                    distributes[i]+=cookies[cookieIndex];
                    res = calculateRes(distributes);
                    distributes[i]-=cookies[cookieIndex];
                    break;
                }
            }
        }else{
            for (int i = 0; i < distributes.length; i++) {
                if (distributes[i] >0) {
                    distributes[i]+=cookies[cookieIndex];
                    helper(cookies, cookieIndex+1, distributes);
                    distributes[i]-=cookies[cookieIndex];
                }else{
                    distributes[i]+=cookies[cookieIndex];
                    helper(cookies, cookieIndex+1, distributes);
                    distributes[i]-=cookies[cookieIndex];
                    break;
                }
            }

        }

    }

    private int calculateRes(int[] distributes) {
        int r = 0;
        for (int i = 0; i < distributes.length; i++) {
            r= Math.max(r, distributes[i]);
        }
        return Math.min(r, res);
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        solution.distributeCookies(new int[]{8,15,10,20,8}, 2);
    }
}
