package letterTilePossibilities;

public class Solution2 {
    // 1ms , beat 95%
    public int numTilePossibilities(String tiles) {
	int[] holder = new int[26];
	for (char c : tiles.toCharArray()) {
	    holder[c - 'A']++;
	}

	int res = check(holder, 0, tiles.length());
	return res;
    }

    private int check(int[] holder, int round, int length) {
	if (round == length) {
	    return 0;
	}
	int total = 0;
	for (int i = 0; i < holder.length; i++) {
	    int v = holder[i];
	    if (v > 0) {
		total += 1;
		holder[i]--;
		total += check(holder, round + 1, length);
		holder[i]++;
	    }
	}
	return total;
    }
}
