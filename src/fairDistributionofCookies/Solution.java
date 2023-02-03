package fairDistributionofCookies;
/*
4ms solution beat 85%
 */
public class Solution {
    private int min = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        if (cookies.length <= k) {
            int max = 0;
            for (int c:cookies) {
                max = Math.max(max, c);
            }
            return max;
        }
        int[] kids = new int[k];
        kids[0] = cookies[0];
        distribuateHelper(kids, cookies, 1);
        return min;
    }

    private void distribuateHelper(int[] kids, int[] cookies, int idx) {
        for (int i=0; i<kids.length; i++) {
            kids[i] = kids[i] + cookies[idx];
            if(idx == cookies.length-1) {
                min=Math.min(min, getMaxCookiesNumber(kids));
            }else {
                distribuateHelper(kids, cookies, idx+1);
            }
            kids[i] = kids[i] - cookies[idx];
        }
    }

    private int getMaxCookiesNumber(int[] kids) {
        int max = 0;
        for (int v : kids) {
            max = Math.max(max, v);
        }
        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] cookies={6,1,3,2,2,4,1,2};
        s.distributeCookies(cookies, 3);
    }
}
