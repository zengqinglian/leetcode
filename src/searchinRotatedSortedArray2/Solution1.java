package searchinRotatedSortedArray2;

public class Solution1 {
    // Loop bi search 1ms.
    public boolean search(int[] nums, int target) {
        // note here end is initialized to len instead of (len-1)
        int start = 0, end = nums.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] > nums[start]) { // nums[start..mid] is sorted
                // check if target in left half
                if (target < nums[mid] && target >= nums[start])
                    end = mid;
                else
                    start = mid + 1;
            } else if (nums[mid] < nums[start]) { // nums[mid..end] is sorted
                // check if target in right half
                if (target > nums[mid] && target < nums[start])
                    start = mid + 1;
                else
                    end = mid;
            } else { // have no idea about the array, but we can exclude
                     // nums[start] because nums[start] == nums[mid]
                start++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = { 1, 1, 3, 1 };
        s.search(nums, 3);
    }
}
