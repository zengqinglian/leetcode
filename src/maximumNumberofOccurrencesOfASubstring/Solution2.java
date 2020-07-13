package maximumNumberofOccurrencesOfASubstring;

import java.util.*;

public class Solution2 {
    //105ms solution , meet avg 50%
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Set<Character> set = new HashSet<>();
        Map<String, Integer> resMap = new HashMap<>();
        int max = 0;
        for(int i=0; i<s.length(); i++){
            set.clear();
            set.add(s.charAt(i));
            if(1>=minSize){
                String str = s.substring(i,i+1);
                Integer v = resMap.get(str);
                if(v == null){
                    resMap.put(str, 1);
                    max = Math.max(1, max);
                }else{
                    resMap.put(str, 1+v);
                    max = Math.max(v+1, max);
                }
            }else {
                for (int j = i + 1; j < s.length(); j++) {
                    set.add(s.charAt(j));
                    if (set.size() > maxLetters || j - i + 1 > maxSize) {
                        break;
                    } else {
                        if (j - i + 1 >= minSize) {
                            String str = s.substring(i, j + 1);
                            Integer v = resMap.get(str);
                            if (v == null) {
                                resMap.put(str, 1);
                                max = Math.max(1, max);
                            } else {
                                resMap.put(str, 1 + v);
                                max = Math.max(v + 1, max);

                            }
                            break;
                        }
                    }
                }
            }
        }
        return max;

    }
}
