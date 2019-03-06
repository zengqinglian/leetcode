package minimumAreaRectangle;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
    // 256ms solution , beat 70%
    public int minAreaRect(int[][] points) {
	Map<Integer, TreeSet<Integer>> xKeyMap = new HashMap<>();
	Map<Integer, TreeSet<Integer>> yKeyMap = new HashMap<>();
	
	int min = Integer.MAX_VALUE;
	boolean found = false;
	for(int[] point : points) {
	    int x = point[0];
	    int y = point[1];
	    
	    if(xKeyMap.containsKey(x) && yKeyMap.containsKey(y)) {

		if (!yKeyMap.get(y).isEmpty() && !xKeyMap.get(x).isEmpty()) {
		    SortedSet<Integer> floorX = yKeyMap.get(y).headSet(x);
		    SortedSet<Integer> higherX = yKeyMap.get(y).tailSet(x);
		    SortedSet<Integer> floorY = xKeyMap.get(x).headSet(y);
		    SortedSet<Integer> higherY = xKeyMap.get(x).tailSet(y);

		    if (!floorX.isEmpty() && !floorY.isEmpty()) {

			for (int fx : floorX) {
			    for (int fy : floorY) {
				if (xKeyMap.containsKey(fx) && xKeyMap.get(fx).contains(fy)) {
				    min = Math.min(min, Math.abs(x - fx) * Math.abs(fy - y));
				    found = true;
				}
			    }
			}

		    }

		    if (!floorX.isEmpty() && !higherY.isEmpty()) {

			for (int fx : floorX) {
			    for (int fy : higherY) {
				if (xKeyMap.containsKey(fx) && xKeyMap.get(fx).contains(fy)) {
				    min = Math.min(min, Math.abs(x - fx) * Math.abs(fy - y));
				    found = true;
				}
			    }
			}

		    }

		    if (!higherX.isEmpty() && !floorY.isEmpty()) {

			for (int fx : higherX) {
			    for (int fy : floorY) {
				if (xKeyMap.containsKey(fx) && xKeyMap.get(fx).contains(fy)) {
				    min = Math.min(min, Math.abs(x - fx) * Math.abs(fy - y));
				    found = true;
				}
			    }
			}

		    }

		    if (!higherX.isEmpty() && !higherY.isEmpty()) {

			for (int fx : higherX) {
			    for (int fy : higherY) {
				if (xKeyMap.containsKey(fx) && xKeyMap.get(fx).contains(fy)) {
				    min = Math.min(min, Math.abs(x - fx) * Math.abs(fy - y));
				    found = true;
				}
			    }
			}

		    }

		}
	    }
	    
	    TreeSet<Integer> xSet = xKeyMap.get(x);

	    if (xSet == null) {
		xSet = new TreeSet<>();
		xKeyMap.put(x, xSet);
	    }

	    xSet.add(y);

	    TreeSet<Integer> ySet = yKeyMap.get(y);

	    if (ySet == null) {
		ySet = new TreeSet<>();
		yKeyMap.put(y, ySet);
	    }

	    ySet.add(x);

	}
	return found ? min : 0;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[][] points = 
		{ { 1, 3 }, { 2, 1 }, { 2, 0 }, { 4, 3 }, { 0, 4 }, { 4, 2 }, { 1, 0 }, { 3, 4 }, { 2, 4 }, { 4, 0 } };
	s.minAreaRect(points);
    }
}
