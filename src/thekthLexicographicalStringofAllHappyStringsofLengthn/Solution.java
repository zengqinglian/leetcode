package thekthLexicographicalStringofAllHappyStringsofLengthn;

import java.util.LinkedList;
/*
Runtime: 47 ms, faster than 10.77% of Java online submissions for The k-th Lexicographical String of All Happy Strings of Length n.
Memory Usage: 51.5 MB, less than 5.71% of Java online submissions for The k-th Lexicographical String of All Happy Strings of Length n.
 */
public class Solution {
    char[] chars = {'a','b','c'};
    public String getHappyString(int n, int k) {
        if(n==1){
            if(k==1){
                return "a";
            }
            if(k==2){
                return "b";
            }
            if(k==3){
                return "c";
            }
            return "";
        }
        if(k>3*(Math.pow(2,n-1))){
            return "";
        }
        LinkedList<String> q = new LinkedList<>();
        q.add("a");
        q.add("b");
        q.add("c");
        int len = 1;
        while(len<n){
            int size = q.size();
            int cnt = 0;
            len++;
            for(int i=0; i<size; i++){
                String s = q.pollFirst();
                for(char c : chars){
                    if(c != s.charAt(s.length()-1)){
                        String newStr = s + c;
                        if(n==len){
                            cnt++;
                            if(cnt==k){
                                return newStr;
                            }
                        }
                        q.add(newStr);
                    }
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.getHappyString(3,9);
    }
}
