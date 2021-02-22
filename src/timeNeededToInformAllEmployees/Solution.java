package timeNeededToInformAllEmployees;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //46 ms, faster than 89.87%
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List[] arr = new List[n+1];
        for(int i=0; i<manager.length; i++){
            if(i==headID){
                continue;
            }
            List<Integer> li = arr[manager[i]];
            if(li==null){
                li = new ArrayList<>();
                arr[manager[i]] = li;
            }
            li.add(i);
        }
        return calculate(headID, informTime, arr);
    }

    private int calculate(int managerId, int[] informTime, List[] arr) {
        List<Integer> childrens = arr[managerId];
        if(childrens == null){
            return 0;
        }
        int res = informTime[managerId];
        int childrenRes =0;
        for(int newManagerId : childrens){
            childrenRes = Math.max(childrenRes, calculate(newManagerId, informTime, arr));
        }
        return res+childrenRes;
    }
}
