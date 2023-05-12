package minimumPenaltyForaShop;
/*
Runtime 18 ms Beats 21.8%
Memory 43.3 MB Beats 50.76%
 */
public class Solution {
    public int bestClosingTime(String customers) {
        int[] openCount = new int[customers.length()];

        int open = 0;
        for (int i=0; i<customers.length(); i++) {
            int lastIndex = customers.length()-1-i;
            if (customers.charAt(lastIndex)== 'Y') {
                openCount[lastIndex] = ++open;
            }else{
                openCount[lastIndex] = open;
            }
        }

        int min = customers.length();
        int index = 0;
        int closeCount = 0;
        for (int i=0; i<customers.length(); i++) {
            char c = customers.charAt(i);
            int penalty;
            penalty = openCount[i] + (i==0 ? 0 : closeCount);
            if (penalty < min) {
                min = penalty;
                index = i;
            }
            if (c =='N') {
                closeCount++;
            }
        }
        if (customers.charAt(customers.length()-1) == 'Y') {
            if (closeCount < min) {
                return customers.length();
            }
        }

        return index;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.bestClosingTime("Y");
    }
}
