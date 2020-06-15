package removeCoveredIntervals;

import java.util.*;

public class Solution {
    //27ms solution , beat 7%
    public int removeCoveredIntervals(int[][] intervals) {
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        for(int[] interval : intervals){
            TreeSet<Integer> set =  map.get(interval[0]);
            if(set == null){
                set = new TreeSet<>();
                map.put(interval[0], set);
            }
            set.add(interval[1]);
        }
        int count = 0;
        for(int[] interval : intervals){
            TreeSet<Integer> set1 = map.get(interval[0]);
            if(!set1.tailSet(interval[1],false).isEmpty()){
                continue;
            }else{
                Map<Integer, TreeSet<Integer>> map1 = map.headMap(interval[0]);
                if(map1.isEmpty()){
                    count++;
                    continue;
                }else{
                    boolean found = false;
                    for(TreeSet<Integer> treeSet : map1.values()){
                        if(!treeSet.tailSet(interval[1]).isEmpty()){
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] intervals = {{1,4},{3,6},{2,8},{4,8},{3,4}};
        s.removeCoveredIntervals(intervals);
    }
}
