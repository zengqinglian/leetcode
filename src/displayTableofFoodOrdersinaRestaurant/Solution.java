package displayTableofFoodOrdersinaRestaurant;

import java.util.*;
/*
Runtime: 65 ms, faster than 22.17% of Java online submissions for Display Table of Food Orders in a Restaurant.
Memory Usage: 65 MB, less than 43.91% of Java online submissions for Display Table of Food Orders in a Restaurant.
 */
public class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        TreeSet<String> tables = new TreeSet<>(Comparator.comparingInt(Integer::valueOf));
        TreeMap<String, Map<String, Integer>> foodOrders = new TreeMap<>();
        for(List<String> order : orders){
            String tableNo = order.get(1);
            String foodName = order.get(2);
            tables.add(tableNo);
            Map<String, Integer> foodOrder = foodOrders.get(foodName);
            if(foodOrder==null){
                foodOrder = new HashMap<>();
                foodOrders.put(foodName, foodOrder);
            }
            Integer orderQty = foodOrder.get(tableNo);
            if(orderQty == null){
                foodOrder.put(tableNo, 1);
            }else{
                foodOrder.put(tableNo, 1+orderQty);
            }
        }
        List<List<String>> res = new ArrayList<>();
        List<String> firstRow = new ArrayList<>();
        firstRow.add("Table");
        for(String foodName:foodOrders.keySet()){
            firstRow.add(foodName);
        }
        res.add(firstRow);
        for(String tableNo : tables){
            List<String> tableRes = new ArrayList<>(foodOrders.size());
            tableRes.add(tableNo);
            for(int i=1; i<res.get(0).size(); i++){
                Integer orderTotal = foodOrders.get(res.get(0).get(i)).getOrDefault(tableNo,0);
                tableRes.add(String.valueOf(orderTotal));
            }
            res.add(tableRes);
        }
        return res;
    }
}
