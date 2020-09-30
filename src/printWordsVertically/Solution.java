package printWordsVertically;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //0ms solution, beat 90%
    public List<String> printVertically(String s) {
        List<StringBuilder> res = new ArrayList<>();
        int cnt = 0;
        int idx = 0;
        for(char c : s.toCharArray()){
            if(c == ' '){
                idx = 0;
                cnt++;
            }else{
                if(idx == res.size()){
                    res.add(new StringBuilder());
                }
                for(int i=res.get(idx).length(); i<cnt; i++){
                    res.get(idx).append(' ');
                }
                res.get(idx).append(c);
                idx++;
            }
        }
        List<String> result = new ArrayList<>();
        for(StringBuilder sb : res){
            result.add(sb.toString());
        }

        return result;
    }
}
