package checkIfSStringCanBreakAnotherString;
/*
Runtime: 8 ms, faster than 80.41% of Java online submissions for Check If a String Can Break Another String.
Memory Usage: 39.5 MB, less than 93.56% of Java online submissions for Check If a String Can Break Another String.
 */
public class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] c1 = new int[26];
        int[] c2 = new int[26];

        for(int i=0; i<s1.length(); i++){
            c1[s1.charAt(i)-'a']++;
            c2[s2.charAt(i)-'a']++;
        }
        int status = 0;
        int diff = 0;
        for(int i=0; i<26;i++){
            if(status == 0){
                if(c1[i] > c2[i]){
                    status =1;
                    diff = c1[i] - c2[i];
                }
                if(c1[i] < c2[i]){
                    status = -1;
                    diff = c2[i] - c1[i];
                }
            }else if(status == 1){
                if(c1[i] + diff < c2[i] ){
                    return false;
                }
                diff += (c1[i]-c2[i]);
            }else{
                if(c2[i] + diff < c1[i] ){
                    return false;
                }
                diff += (c2[i]-c1[i]);
            }
        }
        return true;
    }
}
