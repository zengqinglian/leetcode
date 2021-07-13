package thekthLexicographicalStringofAllHappyStringsofLengthn;


/*
Runtime: 13 ms, faster than 53.41% of Java online submissions for The k-th Lexicographical String of All Happy Strings of Length n.
Memory Usage: 39.4 MB, less than 27.69% of Java online submissions for The k-th Lexicographical String of All Happy Strings of Length n.
 */
public class Solution1 {
    int cnt = 0;
    char[] chars = {'a','b','c'};
    public String getHappyString(int n, int k) {
        if(k>3*(Math.pow(2,n-1))){
            return "";
        }
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
        String str = generateString("a", n,k);
        if(!str.isEmpty()){
            return str;
        }
        str = generateString("b",n,k);
        if(!str.isEmpty()){
            return str;
        }
        str = generateString("c", n,k);
        return str;
    }

    private String generateString(String s, int n, int k) {
        for(char c : chars) {
            if(s.charAt(s.length()-1) != c){
                String newStr = s + c;
                if(newStr.length() == n){
                    cnt++;
                    if(cnt==k){
                        return newStr;
                    }
                }else{
                    String str = generateString(newStr, n, k);
                    if(!str.isEmpty()){
                        return str;
                    }
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        s.getHappyString(3,9);
    }
}
