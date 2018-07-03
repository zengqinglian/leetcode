package maxChunksToMakeSorted;

public class Solution {
    // 4ms solution, beat 100%
    public int maxChunksToSorted(int[] arr) {
	int index = 0;
	int result = 0;
	while (index < arr.length) {
	    if (arr[index] == index) {
		result++;
		index++;
	    } else {
		int endIndex = arr[index];
		while (index <= endIndex) {
		    if (arr[index] > endIndex) {
			endIndex = arr[index];
		    } else {
			if (index == endIndex) {
			    result++;
			}
		    }
		    index++;
		}
	    }

	}
	return result;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] arr = { 1, 2, 0, 3 };
	s.maxChunksToSorted(arr);
    }
}
