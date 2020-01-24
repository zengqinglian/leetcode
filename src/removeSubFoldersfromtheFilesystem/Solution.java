package removeSubFoldersfromtheFilesystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    //99ms solution , beat 20%
    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        String cur = folder[0]+"/";
        result.add(folder[0]);
        for(int i=1; i<folder.length; i++){
            if(!folder[i].startsWith(cur)){
                result.add(folder[i]);
                cur = folder[i]+"/";
            }
        }
        return result;
    }
}
