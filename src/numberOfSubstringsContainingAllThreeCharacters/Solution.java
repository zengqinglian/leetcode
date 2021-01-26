package numberOfSubstringsContainingAllThreeCharacters;

public class Solution {
    //11ms solution, beat 33%
    public int numberOfSubstrings(String s) {
        int[] count = new int[3];
        int res = 0;
        boolean hasZero = false;
        int i = 0;
        int j = i;

        while(j<s.length()){
            count[s.charAt(j)-'a']++;
            hasZero = false;
            for(int v: count){
                if(v==0){
                    hasZero = true;
                    break;
                }
            }
            if(!hasZero){
               res+= (s.length() - j);
            }
            while(!hasZero){
                count[s.charAt(i)-'a']--;
                i++;
                for(int v: count){
                    if(v==0){
                        hasZero = true;
                        break;
                    }
                }
                if(hasZero){
                    break;
                }else{
                    res+= (s.length() - j);
                }
            }
            j++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.numberOfSubstrings("aaabc");
    }
}
