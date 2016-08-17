package insertDeleteGetRandomDuplicatesAllowed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//155 ms solution
public class RandomizedCollection {

    /** Initialize your data structure here. */
    private List<Integer> list = new ArrayList<>();
    private Map<Integer, List<Integer>> map = new HashMap<>();
    private java.util.Random rand = new java.util.Random();
    public RandomizedCollection() {

    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not
     * already contain the specified element.
     */
    public boolean insert(int val) {

        if (!map.containsKey(val)) {
            List<Integer> li = new ArrayList<>();
            li.add(list.size());
            map.put(val, li);
            list.add(val);
            return true;
        } else {
            List<Integer> li = map.get(val);
            li.add(list.size());
            list.add(val);
            return false;
        }
    }

    /**
     * Removes a value from the collection. Returns true if the collection
     * contained the specified element.
     */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            List<Integer> li = map.get(val);
            int index = li.get(0);
            int lastItem = list.get(list.size() - 1);
            List<Integer> lastItemList = map.get(lastItem);
            for (int i = 0; i < lastItemList.size(); i++) {
                if (lastItemList.get(i) == list.size() - 1) {
                    lastItemList.set(i, index);
                    break;
                }
            }
            list.set(index, lastItem);
            list.remove(list.size() - 1);
            if(li.size()==1){
                map.remove(val);
            } else {
                Iterator<Integer> ita = li.iterator();
                while (ita.hasNext()) {
                    if (ita.next() == index) {
                        ita.remove();
                        break;
                    }
                }

            }
            return true;
        }else{
            return false;
        }
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedCollection r = new RandomizedCollection();
        r.insert(1);
        r.remove(1);
        r.insert(1);
    }
}