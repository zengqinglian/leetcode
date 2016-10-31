package queueReconstructionbyHeight;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
    // over time limit
    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][2];
        Map<Integer, SortedSet<Integer>> map = new HashMap<>();

        for(int[] seq : people){
            int key = seq[1];
            int value = seq[0];
            if (map.containsKey(key)) {
                map.get(key).add(value);
            } else {

                SortedSet<Integer> set = new TreeSet<>();
                set.add(value);
                map.put(key, set);
            }

        }
        
        int index = 0;
        while (index < result.length) {
            if (index == 0) {
                result[index][1] = 0;
                result[index][0] = map.get(index).first();
                map.get(index).remove(map.get(index).first());
            } else {
                int loop = index;
                int[] min = new int[2];
                min[0] = Integer.MAX_VALUE;
                while (loop >= 0) {
                    if (map.containsKey(loop) && !map.get(loop).isEmpty()) {
                        int value = map.get(loop).first();
                        if (loop > 0) {
                            if (value < min[0] && getPreviousGreaterAndEquals(result, value, index) == loop) {
                                min[0] = value;
                                min[1] = loop;
                            }
                        } else if (value < min[0]) {
                            min[0] = value;
                            min[1] = loop;
                        }
                    }
                    loop--;
                }
                result[index][1] = min[1];
                result[index][0] = min[0];
                map.get(min[1]).remove(min[0]);
            }
            index++;
        }
        return result;
    }

    private int getPreviousGreaterAndEquals(int[][] result, int value, int index) {
        int count = 0;
        for (int i = 0; i < index; i++) {
            if (result[i][0] >= value) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] people={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        s.reconstructQueue(people);
    }
}
