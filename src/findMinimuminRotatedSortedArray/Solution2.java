package findMinimuminRotatedSortedArray;
/*
0 ms
Beats
100.00%
Analyze Complexity
Memory
42.60 MB
Beats 6.97%
 */
public class Solution2 {
    public int findMin(int[] nums) {
        int res = findMin(nums, 0, nums.length - 1);
        return res;
    }

    private int findMin(int[] nums, int start, int end) {
        if (start == end) {
            return nums[start];
        }
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        int mid = (start + end) / 2;
        if (mid == start) {
            return Math.min(nums[mid], nums[end]);
        }
        if (nums[mid] > nums[start]) {
            return findMin(nums, mid+1, end);
        }else{
            return findMin(nums, start, mid);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findMin(new int[]{2,1});
    }
}
