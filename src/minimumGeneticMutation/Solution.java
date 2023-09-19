package minimumGeneticMutation;
/*
Runtime
0 ms
Beats
100%
Memory
40.2 MB
Beats
88.94%
 */
public class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (bank.length==0) {
            return -1;
        }
        int res= helper(startGene, endGene, bank, new boolean[bank.length]);
        if (res >8) {
            return -1;
        }
        return res;
    }
    public int helper(String startGene, String endGene, String[] bank, boolean[] used) {
        if (startGene.equals(endGene)) {
            return 0;
        }
        int min = 10;
        for(int i=0; i<bank.length; i++) {
            String str = bank[i];
            if (!used[i] && canMutate(startGene, str)) {
                used[i] = true;
                min = Math.min(min, 1 + helper(str, endGene, bank, used));
                used[i]=false;
            }
        }
        return min;
    }

    private boolean canMutate(String startGene, String str) {
        int diffcount = 0;
        for (int i=0; i<8; i++) {
            if (startGene.charAt(i) != str.charAt(i)) {
                diffcount++;
            }
            if (diffcount>1) {
                return false;
            }
        }
        if (diffcount == 1) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String startGene = "AACCGGTT";
        String endGene = "AAACGGTA";
        String[] bank = {"AACCGGTA","AACCGCTA","AAACGGTA"};
        s.minMutation(startGene, endGene, bank);
    }

}
