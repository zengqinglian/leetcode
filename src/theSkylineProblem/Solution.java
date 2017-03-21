package theSkylineProblem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Solution {
    // Over memory
    public List<int[]> getSkyline(int[][] buildings) {
        if (buildings.length == 0) {
            return new ArrayList<int[]>();
        }
        if (buildings.length == 1) {
            List<int[]> result = new ArrayList<>();
            int[] rt1 = { buildings[0][0], buildings[0][2] };
            result.add(rt1);
            int[] rt2 = { buildings[0][1], 0 };
            result.add(rt2);
            return result;
        }

        TreeSet<int[]> result = new TreeSet<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {              
                return o1[0]-o2[0];
            }
            
        });
        int lastIndex = buildings[buildings.length-1][1];
        int startIndex = buildings[0][0];
        
        int[] lines = new int[lastIndex-startIndex+1];

        for(int[] building : buildings){
            for(int i=building[0]; i<=building[1]; i++){
                lines[i-startIndex] = Math.max(lines[i-startIndex], building[2]);
            }
        }
        
        int[] rt1 = { startIndex, lines[0] };
        result.add(rt1);
        int[] rt2 = { lastIndex, 0 };
        result.add(rt2);

        for (int i = 1; i < lines.length - 1; i++) {
            if (lines[i - 1] < lines[i]) {
                int[] rt = { i + startIndex, lines[i] };
                result.add(rt);
            }

            if (lines[lines.length - 1 - i - 1] > lines[lines.length - 1 - i]) {
                int[] rt = { lines.length - 1 - i - 1 + startIndex, lines[lines.length - 1 - i] };
                result.add(rt);
            }
        }
        
        return new ArrayList<int[]>(result);

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] buildings = { { 1, 2, 1 }, { 13, 14, 14 } };
        s.getSkyline(buildings);
    }
}
