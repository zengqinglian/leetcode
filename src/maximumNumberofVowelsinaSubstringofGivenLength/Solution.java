package maximumNumberofVowelsinaSubstringofGivenLength;

/*
Runtime: 11 ms, faster than 53.82% of Java online submissions for Maximum Number of Vowels in a Substring of Given Length.
Memory Usage: 39.4 MB, less than 77.44% of Java online submissions for Maximum Number of Vowels in a Substring of Given Length.
 */
public class Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        int length = 0;
        boolean[] records = new boolean[s.length()];
        for(int i=0; i<k;i++){
            if(s.charAt(i) == 'a' || s.charAt(i) == 'e'  ||
                    s.charAt(i) == 'i'|| s.charAt(i) == 'o' || s.charAt(i) == 'u'){
                length++;
                records[i] = true;
                max = Math.max(max, length);
            }
        }
        if(max == k) {
            return max;
        }
        int j = k;
        while(j<s.length()){
            if(records[j-k]){
                length--;
            }
            if(s.charAt(j) == 'a' || s.charAt(j) == 'e'  ||
                    s.charAt(j) == 'i'|| s.charAt(j) == 'o' || s.charAt(j) == 'u'){
                length++;
                records[j]=true;
                max = Math.max(max,length);
            }
            j++;
        }
        return max;
    }
}
