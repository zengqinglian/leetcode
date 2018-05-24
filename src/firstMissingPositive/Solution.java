package firstMissingPositive;

public class Solution {
// The key here is to use swapping to keep constant space and also make use of
// the length of the array, which means there can be at most n positive
// integers. So each time we encounter an valid integer, find its correct
// position and swap. Otherwise we continue.
public int firstMissingPositive(int[] nums) {
int i = 0;
while (i < nums.length) {
if (nums[i] == i + 1 || nums[i] <= 0 || nums[i] > nums.length)
i++;
else if (nums[nums[i] - 1] != nums[i])
swap(nums, i, nums[i] - 1);
else
i++;
}
i = 0;
while (i < nums.length && nums[i] == i + 1)
i++;
return i + 1;
}

private void swap(int[] A, int i, int j) {
int temp = A[i];
A[i] = A[j];
A[j] = temp;
}

public static void main(String[] args) {
int[] A = { 7, -1, 6, 5, -3, 3, 2, 1 };
Solution s = new Solution();
s.firstMissingPositive(A);
}
}

