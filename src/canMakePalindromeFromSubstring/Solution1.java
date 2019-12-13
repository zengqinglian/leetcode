package canMakePalindromeFromSubstring;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    //someone's 8ms solution , beat 90%.  We do not need to know total number of char appearence . only need to know it has odds or even number.
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int str_len = s.length();
        int j = 0;
        List<Boolean> results = new ArrayList<>();
        int[] masks = new int[str_len + 1];

        int mask = 0;
        for(int i = 0 ; i < str_len; i++){
            mask ^= (1 << (s.charAt(i) - 'a'));
            masks[++j] = mask;
        }

        for(int [] query : queries){
            if(query[2] >= 13){
                results.add(true);
            }else{
                results.add(Integer.bitCount(masks[query[1] + 1] ^ masks[query[0]]) /2 <= query[2]);
            }
        }

        return results;
    }
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[][] queries = {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
        s.canMakePaliQueries("abcda", queries);
    }
}
