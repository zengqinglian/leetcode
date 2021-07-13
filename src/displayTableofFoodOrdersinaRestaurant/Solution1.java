package displayTableofFoodOrdersinaRestaurant;

import java.util.*;
/*
Someone's solution

Runtime: 78 ms, faster than 18.70% of Java online submissions for Display Table of Food Orders in a Restaurant.
Memory Usage: 145.6 MB, less than 9.13% of Java online submissions for Display Table of Food Orders in a Restaurant.
 */
public class Solution1 {
    public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> items = new TreeSet<>();
        List<List<String>> ans = new ArrayList<>();
        Map<Integer, Map<String,Integer>> res = new TreeMap<>();
        for(int i=0;i<orders.size();i++){
            List<String> cur = orders.get(i);
            int tn = Integer.parseInt(cur.get(1));
            items.add(cur.get(2));
            if(res.containsKey(tn)){
                Map<String,Integer> kk = res.get(tn);
                kk.put(cur.get(2) , kk.getOrDefault(cur.get(2),0)+1);
            } else{
                Map<String,Integer> kk = new HashMap<>();
                kk.put(cur.get(2),1);
                res.put(tn,kk);
            }
        }
        List<String> oo = new ArrayList<>();
        oo.add("Table");
        for(String i : items){
            oo.add(i);
        }
        ans.add(oo);
        for(Map.Entry<Integer,Map<String,Integer>> pp : res.entrySet()){
            int tn = pp.getKey();
            List<String> med = new ArrayList<>();
            med.add(String.valueOf(tn));
            Map<String,Integer> pl = pp.getValue();
            for(String i:items){
                med.add(String.valueOf(pl.getOrDefault(i,0)));
            }
            ans.add(med);
        }
        return ans;
    }
}
