package insertDeleteGetrandomO1;

import java.util.*;

public class RandomizedSet3 {
    private List<Integer> list;
    private Map<Integer, Integer> map;

    private int size;

    private Random ran;

    public RandomizedSet() {
        list = new ArrayList<>();
        for (int i=0; i<=2* 100000;i++){
            list.add(0);
        }
        map = new HashMap<>();
        size = 0;
        ran = new Random();
    }

    public boolean insert(int val) {
        if(map.containsKey(val)) {
            return false;
        }
        list.set(size, val);
        map.put(val, size);
        size++;
        return true;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int idx = map.remove(val);
            if (idx == size -1) {
                size--;
                map.remove(val);
                return true;
            }else {
                int lastVal = list.get( size -1);
                list.set(idx, lastVal);
                map.put(lastVal, idx);
                size--;
                return true;
            }
        }
        return false;
    }

    public int getRandom() {
        int randomIdx = ran.nextInt(size);
        return list.get(randomIdx);
    }
}
