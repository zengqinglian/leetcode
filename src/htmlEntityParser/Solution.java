package htmlEntityParser;

import java.util.HashMap;
import java.util.Map;
/*
Runtime: 28 ms, faster than 68.77% of Java online submissions for HTML Entity Parser.
Memory Usage: 39.4 MB, less than 89.59% of Java online submissions for HTML Entity Parser.
 */
public class Solution {
    Map<String, String> map = new HashMap(){{
        put("&quot;","\"");
        put("&apos;","'");
        put("&amp;","&");
        put("&gt;",">");
        put("&lt;","<");
        put("&frasl;","/");
    }};
    public String entityParser(String text) {
        boolean checkTargetOn = false;
        StringBuilder sb = new StringBuilder();
        StringBuilder subSb = new StringBuilder();
        for(char c : text.toCharArray()){
            if(!checkTargetOn){
                if(c=='&'){
                    checkTargetOn = true;
                    subSb.append(c);
                }else {
                    sb.append(c);
                }
            }else{
                if(c=='&'){
                    sb.append(subSb.toString());
                    subSb.setLength(0);
                    subSb.append('&');
                }else {
                    subSb.append(c);
                    if (c == ';') {
                        if (map.containsKey(subSb.toString())) {
                            sb.append(map.get(subSb.toString()));
                        } else {
                            sb.append(subSb.toString());
                        }
                        subSb.setLength(0);
                        checkTargetOn = false;
                    }
                }
            }
        }
        return sb.toString()+subSb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.entityParser("&amp; is an HTML entity but &ambassador; is not.");
    }
}
