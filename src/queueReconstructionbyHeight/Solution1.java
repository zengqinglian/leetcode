package queueReconstructionbyHeight;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution1 {
    // Someone's 3nlogn solution.
    public int[][] reconstructQueue(int[][] people) {
        if (people.length == 0)
            return new int[][] {};

        // sort
        Arrays.sort(people, new SolutionComparator());

        // put in a list
        List<int[]> list = new LinkedList<>();
        list.add(people[0]);
        for (int i = 1; i < people.length; i++) {
            list.add(people[i][1], people[i]);
        }

        // return result
        Iterator<int[]> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            people[i++] = (int[]) iterator.next();
        }
        return people;
    }

    private static class SolutionComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] > o2[0])
                return -1;
            else if (o1[0] < o2[0])
                return 1;
            else {
                return o1[1] - o2[1];
            }
        }
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
        s.reconstructQueue(people);
    }
}
