package checkIfaStringContainsAllBinaryCodesofSizeK;

import java.util.HashSet;
import java.util.Set;

/*
Runtime: 201 ms, faster than 24.78% of Java online submissions for Check If a String Contains All Binary Codes of Size K.
Memory Usage: 149 MB, less than 5.12% of Java online submissions for Check If a String Contains All Binary Codes of Size K.
*/
public class Solution {
    public boolean hasAllCodes(String s, int k) {
        int total = (int)Math.pow(2,k);
        Set<String> allStrings = new HashSet<>(total);
        for(int i=0; i+k<=s.length(); i++){
            allStrings.add(s.substring(i, i+k));
            if(allStrings.size()==total){
                return true;
            }
        }
        return false;
    }
}
