package maximumNumberofOccurrencesOfASubstring;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    //450ms solution , beat 15%
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Set<Character> set = new HashSet<>();
        Map<String, Integer> resMap = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int max = 0;
        for(int i=0; i<s.length(); i++){

            set.clear();
            set.add(s.charAt(i));
            sb.setLength(0);
            sb.append(s.charAt(i));
            if(sb.length()>=minSize){
                Integer v = resMap.get(sb.toString());
                if(v == null){
                    resMap.put(sb.toString(), 1);
                    max = Math.max(1, max);
                }else{
                    resMap.put(sb.toString(), 1+v);
                    max = Math.max(v+1, max);
                }
            }
            for(int j=i+1; j<s.length(); j++){
                sb.append(s.charAt(j));
                set.add(s.charAt(j));
                if(set.size() > maxLetters || sb.length()>maxSize){
                    break;
                }else{
                    if(sb.length()>=minSize){
                        Integer v = resMap.get(sb.toString());
                        if(v == null){
                            resMap.put(sb.toString(), 1);
                            max = Math.max(1, max);
                        }else{
                            resMap.put(sb.toString(), 1+v);
                            max = Math.max(v+1, max);
                        }
                    }
                }
            }
        }
        return max;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxFreq("abcde",2,3,3);
    }
}
