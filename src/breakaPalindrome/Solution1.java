package breakaPalindrome;

public class Solution1 {
    //using array char, improve permformance,  beat 50%
    public String breakPalindrome(String p) {
        if(p.length()==1)
            return "";
        char[] n = p.toCharArray();
        for(int i=0;i<p.length()/2;i++)
        {
            if(n[i]!='a')
            {
                n[i]='a';
                return String.valueOf(n);
            }
        }

        n[n.length-1]='b';
        return String.valueOf(n);

    }
}
