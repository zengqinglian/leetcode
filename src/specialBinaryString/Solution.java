package specialBinaryString;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    // 50ms solution beat 2%
    public String makeLargestSpecial(String S) {
	int i = 0;
	while (i < S.length()) {
	    int val = 0;
	    PriorityQueue<String> zeroIndex = new PriorityQueue<>((x, y) -> {
		return y.compareTo(x);
		
	    });
	    int startidx = i;

	    for (int j = i; j < S.length(); j++) {
		if (S.charAt(j) == '0') {
		    val--;

		    if (val < 0) {
			break;
		    }
		} else {

		    val++;
		}
		if (val == 0) {
		    String temp = S.substring(startidx, j + 1);
		    if (!S.equals(temp)) {
			String sorted = makeLargestSpecial(S.substring(startidx, j + 1));
			zeroIndex.add(sorted);
		    } else {
			zeroIndex.add(S);
		    }

		    startidx = j + 1;
		}
	    }
	    
	    if (zeroIndex.size() > 1) {
		StringBuilder sb = new StringBuilder();
		sb.append(S.substring(0, i));
		while (!zeroIndex.isEmpty()) {
		    String node = zeroIndex.poll();
		    sb.append(node);
		}

		sb.append(S.substring(startidx));
		S = sb.toString();
		i = startidx;
	    } else {
		i++;
	    }
	}
	return S;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.makeLargestSpecial("1101001110001101010110010010"); // "1110010101010011100011010010"
							      // "1110001110010101010011010010"
	String[] str = { "10", "1100", "110100" };
	Arrays.sort(str);
	System.out.println(str);
    }
}
