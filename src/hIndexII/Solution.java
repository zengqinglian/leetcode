package hIndexII;

public class Solution {
    // solution meet O(logn) and beat 50%
    public int hIndex(int[] citations) {
        if (citations.length == 0) {
            return 0;
        }
        if (citations.length == 1) {
            if (citations[0] == 0) {
                return 0;
            }
            return 1;
        }

        int left = 0;
        int right = citations.length - 1;
        int result = 0;

        do {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= citations.length - mid) {
                result = (citations.length - mid);
                right = mid;
            } else if (citations[mid] < citations.length - mid) {
                left = mid;
            }
        } while (right - left > 1);

        if (citations[right] >= citations.length - right) {
            result = Math.max(result, (citations.length - right));
        }
        if (citations[left] >= citations.length - left) {
            result = Math.max(result, (citations.length - left));
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] citations = { 7, 7, 7, 7, 7, 7, 7 };

        s.hIndex(citations);
    }
}
