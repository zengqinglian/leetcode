package makingFileNamesUnique;

import java.util.HashMap;
import java.util.Map;
/*
Runtime: 51 ms, faster than 56.98% of Java online submissions for Making File Names Unique.
Memory Usage: 51.6 MB, less than 77.06% of Java online submissions for Making File Names Unique.
 */
public class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> map = new HashMap<>(names.length);
        for(int i=0; i<names.length; i++) {
            if(!map.containsKey(names[i])) {
                map.put(names[i],1);
            }else{
                int value = map.get(names[i]);
                while(true){
                    String newName = names[i] + "(" + value + ")";
                    if(map.containsKey(newName)){
                        value++;
                    }else{
                        map.put(names[i], value);
                        map.put(newName,1);
                        names[i] = newName;
                        break;
                    }
                }
            }
        }

        return names;
    }

    public static void main(String[] args) {
        String[] names = {"wano","wano(a)","wano","wano(1)"};
        Solution s = new Solution();
        s.getFolderNames(names);
    }
}
