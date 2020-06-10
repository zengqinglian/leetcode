package groupthePeopleGiventheGroupSizeTheyBelongTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    //5ms solution, beat 70%
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        for(int i=0; i<groupSizes.length; i++){
            List<List<Integer>> li = map.get(groupSizes[i]);
            if(li == null){
                li = new ArrayList<>();
                map.put(groupSizes[i], li);
            }
            List<Integer> last = null;
            if(li.size()==0){
                last = new ArrayList<>();
            }else{
                last = li.get(li.size()-1);
            }
            if(last.size() == groupSizes[i]){
                last = new ArrayList<>();
            }
            if(last.size() ==0){
                li.add(last);
            }
            last.add(i);
        }
        List<List<Integer>> res = new ArrayList<>();
        for(List<List<Integer>> li : map.values()){
            res.addAll(li);
        }
        return res;
    }
}
