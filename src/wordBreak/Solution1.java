package wordBreak;

import java.util.ArrayList;
import java.util.List;

//DP solution
public class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        
        dp[0] = true;
        
        
        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/
        
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
    }
        
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        wordDict.add("aaa");
        wordDict.add("aaaaa");

        s.wordBreak("aaaaaaaaaaaaaaab", wordDict);
    }
}
