package breakaPalindrome;

public class Solution {
    //4ms solution, beat 10%
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()<=1){
            return "";
        }
        int len = palindrome.length() / 2;
        for(int i=0; i<len; i++){
            if(palindrome.charAt(i) != 'a'){
                if(i==0){
                    return "a" + palindrome.substring(1);
                }else{
                    return palindrome.substring(0,i) + "a" + palindrome.substring(i+1);
                }
            }
        }
        return palindrome.substring(0,palindrome.length()-1) + "b";
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        s.breakPalindrome("aba");
    }
}
