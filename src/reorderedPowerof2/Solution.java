package reorderedPowerof2;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 14ms solution, meet avg speed.
    public boolean reorderedPowerOf2(int N) {
	if (N == 1) {
	    return true;
	}

	int cnt = 0;
	Map<Integer, Integer> nMap = new HashMap<>();

	while (N >= 10) {
	    int digi = N % 10;
	    if (nMap.containsKey(digi)) {
		nMap.put(digi, nMap.get(digi) + 1);
	    } else {
		nMap.put(digi, 1);
	    }
	    cnt++;
	    N = N / 10;
	}

	if (nMap.containsKey(N)) {
	    nMap.put(N, nMap.get(N) + 1);
	} else {
	    nMap.put(N, 1);
	}
	cnt++;

	if (!nMap.containsKey(2) && !nMap.containsKey(4) && !nMap.containsKey(6) && !nMap.containsKey(8)) {
	    return false;
	}

	int pow = (int) Math.pow(10, cnt - 1);
	pow = (int) (Math.log(pow) / Math.log(2));
	pow = (int) Math.pow(2, pow);
	while (pow < Math.pow(10, cnt)) {
	    if (pow > Math.pow(10, cnt - 1)) {
		if (checkNumber(pow, nMap)) {
		    return true;
		}

	    }
	    pow = pow * 2;
	}

	return false;

    }

    private boolean checkNumber(int pow, Map<Integer, Integer> nMap) {
	Map<Integer, Integer> cMap = new HashMap<>();
	while (pow >= 10) {
	    int digi = pow % 10;
	    if (cMap.containsKey(digi)) {
		cMap.put(digi, cMap.get(digi) + 1);
	    } else {
		cMap.put(digi, 1);
	    }
	    pow = pow / 10;
	}

	if (cMap.containsKey(pow)) {
	    cMap.put(pow, cMap.get(pow) + 1);
	} else {
	    cMap.put(pow, 1);
	}

	if (cMap.size() != nMap.size()) {
	    return false;
	} else {
	    for (int key : cMap.keySet()) {
		if (cMap.get(key) != nMap.get(key)) {
		    return false;
		}
	    }
	    return true;
	}

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.reorderedPowerOf2(38416);
    }
}
