package designaFoodRatingSystem;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/*
290 ms solution, beat 80%
 */
public class FoodRatings {

    private Map<String, String> foodCuisineMap = new HashMap<>();
    private Map<String, Integer> foodRatings = new HashMap<>();

    private Map<String, TreeMap<Integer,TreeSet<String>>> bestRating = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for(int i=0; i<foods.length; i++) {
            foodCuisineMap.put(foods[i], cuisines[i]);
            foodRatings.put(foods[i], ratings[i]);
            TreeMap<Integer, TreeSet<String>> treeMap = bestRating.get(cuisines[i]);
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                bestRating.put(cuisines[i], treeMap);
            }
            TreeSet<String> treeSet = treeMap.get(ratings[i]);
            if (treeSet==null) {
                treeSet=new TreeSet<>();
                treeMap.put(ratings[i],treeSet);
            }
            treeSet.add(foods[i]);
        }
    }

    public void changeRating(String food, int newRating) {
        int oldRating = foodRatings.get(food);
        String cursine = foodCuisineMap.get(food);

        TreeSet<String> oldset = bestRating.get(cursine).get(oldRating);
        if (oldset.size() == 1) {
            bestRating.get(cursine).remove(oldRating);
        }else{
            oldset.remove(food);
        }

        foodRatings.put(food, newRating);
        TreeSet<String> set = bestRating.get(cursine).get(newRating);
        if (set == null) {
            set = new TreeSet<>();
            bestRating.get(cursine).put(newRating, set);
        }
        set.add(food);
    }

    public String highestRated(String cuisine) {
        TreeMap<Integer, TreeSet<String>> treeMap = bestRating.get(cuisine);
        TreeSet<String> set =  treeMap.lastEntry().getValue();
        return set.first();
    }
}
