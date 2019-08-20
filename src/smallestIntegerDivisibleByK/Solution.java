package smallestIntegerDivisibleByK;

public class Solution {
    // 1ms solution , beat 100%
    private static int[][] table = new int[10][10];
    static {
	table[1][0] = 0;
	table[1][1] = 1;
	table[1][2] = 2;
	table[1][3] = 3;
	table[1][4] = 4;
	table[1][5] = 5;
	table[1][6] = 6;
	table[1][7] = 7;
	table[1][8] = 8;
	table[1][9] = 9;

	table[3][0] = 0;
	table[3][1] = 7;
	table[3][2] = 4;
	table[3][3] = 1;
	table[3][4] = 8;
	table[3][5] = 5;
	table[3][6] = 2;
	table[3][7] = 9;
	table[3][8] = 6;
	table[3][9] = 3;

	table[7][0] = 0;
	table[7][1] = 3;
	table[7][2] = 6;
	table[7][3] = 9;
	table[7][4] = 2;
	table[7][5] = 5;
	table[7][6] = 8;
	table[7][7] = 1;
	table[7][8] = 4;
	table[7][9] = 7;

	table[9][0] = 0;
	table[9][1] = 9;
	table[9][2] = 8;
	table[9][3] = 7;
	table[9][4] = 6;
	table[9][5] = 5;
	table[9][6] = 4;
	table[9][7] = 3;
	table[9][8] = 2;
	table[9][9] = 1;
    }
    public int smallestRepunitDivByK(int K) {
	if (K == 1) {
	    return 1;
	}
	int mod = K % 10;
	if (mod == 1 || mod == 3 || mod == 7 || mod == 9) {
	    int res = getResult(0, K, table[mod], 0);
	    return res;
	}

	return -1;
    }

    private int getResult(int base ,int K , int[] table, int cnt) {
	if (base == 1) {
	    return cnt + 1;
	}
	int mod = base % 10;
	int needed = 0;
	if(mod > 1) {
	    needed = 11 - mod;
	}else {
	    needed = 1 - mod;
	}
	int p2 = table[needed];
	int newBase = (p2 * K + base) /10;
	
	return getResult(newBase, K, table, cnt + 1);

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.smallestRepunitDivByK(1);
    }
}
