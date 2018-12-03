package fruitIntoBaskets;

public class Solution {
    // 12ms solution , beat 80%
    public int totalFruit(int[] tree) {
	int val1 = tree[0];
	int val2 = -1;
	int count = 1;
	int max = 1;
	int cCnt = 1;
	
	for (int i = 1; i < tree.length; i++) {
	    if (tree[i] == val1 || tree[i] == val2) {
		count++;
		if (tree[i] == tree[i - 1]) {
		    cCnt++;
		} else {
		    cCnt = 1;
		    val1 = tree[i - 1];
		    val2 = tree[i];
		}
	    } else {
		if (val2 < 0) {
		    count++;
		    val2 = tree[i];
		    cCnt = 1;
		} else {
		    val1 = val2;
		    val2 = tree[i];
		    max = Math.max(max, count);
		    count++;
		    count = cCnt + 1;
		    cCnt = 1;
		}
	    }
	}

	return Math.max(max, count);

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] tree = { 1, 0, 1, 4, 1, 4, 1, 2, 3 };
	s.totalFruit(tree);
    }
}
