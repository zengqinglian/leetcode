package shoppingOffers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    // 19ms solution , beat 20%
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
	int[] sizes = new int[needs.size()];
	for(int i=0; i<sizes.length; i++) {
	    sizes[i] = needs.get(i);
	}
	Map<int[], Integer> result = new HashMap<>();
	result.put(sizes, 0);
	int returnVal = Integer.MAX_VALUE;
	while (!result.isEmpty()) {
	    Map<int[], Integer> temp = new HashMap<>();
	    for (int[] key : result.keySet()) {
		for (List<Integer> li : special) {
		    boolean valid = true;
		    int[] newKey = new int[sizes.length];
		    int individual = 0;
		    for (int i = 0; i < sizes.length; i++) {
			newKey[i] = key[i] - li.get(i);
			individual += price.get(i) * li.get(i);
			if (newKey[i] < 0) {
			    valid = false;
			    break;
			}

		    }
		    if (valid) {
			temp.put(newKey, Math.min(individual, li.get(sizes.length)) + result.get(key));
		    } else {
			int total = 0;
			for (int i = 0; i < sizes.length; i++) {
			    total += (key[i] * price.get(i));
			}
			returnVal = Math.min(returnVal, total + result.get(key));
		    }
		}
	    }
	    result = temp;
	}
	return returnVal;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] p = { 0, 0, 0 };
	int[][] sp = { { 1, 1, 0, 4 }, { 2, 2, 1, 9 } };
	int[] n = { 2, 2, 1 };

	List<Integer> price = convertList(p);
	List<Integer> needs = convertList(n);
	List<List<Integer>> special = convertList2(sp);

	s.shoppingOffers(price, special, needs);
    }

    private static List<Integer> convertList(int[] arr) {
	List<Integer> li = new ArrayList<>();
	for (int v : arr) {
	    li.add(v);
	}
	return li;
    }

    private static List<List<Integer>> convertList2(int[][] arr) {
	List<List<Integer>> speical = new ArrayList<>();
	for (int[] ar : arr) {
	    List<Integer> li = convertList(ar);
	    speical.add(li);
	}
	return speical;
    }

}
