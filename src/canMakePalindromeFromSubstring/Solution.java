package canMakePalindromeFromSubstring;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    //75ms solution , beat 40%
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int[][] counts = new int[s.length()][26];

        for(int i=0; i<s.length(); i++){
            counts[i][s.charAt(i)-'a']++;
        }
        for(int i=1; i<s.length(); i++){
            for(int j=0; j<26; j++){
                counts[i][j] = counts[i-1][j]+  counts[i][j];
            }
        }
        List<Boolean> res = new ArrayList();
        for(int[] q : queries){
            int[] letters = new int[26];
            int start = q[0];
            int end = q[1];
            if(start == end ){
                res.add(true);
                continue;
            }
            if(end - start ==1){
                if(s.charAt(end) == s.charAt(start)){
                    res.add(true);

                }else if(q[2]>0){
                    res.add(true);
                }else{
                    res.add(false);
                }
                continue;
            }
            letters[s.charAt(start)-'a'] =1;
            for(int i=0; i<26 ; i++){
                letters[i] += (counts[end][i]-counts[start][i]);
            }
            int replace = 0;
            for(int v : letters){
                replace += (v%2);
            }
            res.add(replace/2 <=q[2]);

        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] queries = {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}};
        s.canMakePaliQueries("abcda", queries);
    }
}
