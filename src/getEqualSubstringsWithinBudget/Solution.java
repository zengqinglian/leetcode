package getEqualSubstringsWithinBudget;

public class Solution {
    //5ms solution , meet avg speed.
    public int equalSubstring(String s, String t, int maxCost) {
        int[] diffAbs = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            diffAbs[i] = Math.abs(s.charAt(i)-t.charAt(i));

        }

        int res = 0;
        int total = 0;
        int idx = 0;
        for(int i=0; i<diffAbs.length; i++){
            total += diffAbs[i];
            if(total <= maxCost){
                res = Math.max(res, i-idx+1);
            }else{
                while(idx<i && total > maxCost){
                    total -= diffAbs[idx];
                    idx++;
                }
                if(total <= maxCost) {
                    res = Math.max(res, i - idx + 1);
                }
            }
        }
        if(total <= maxCost)
            res = Math.max(res, s.length()-idx);

        return res;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.equalSubstring("abcd","cdef",1);
    }
}
