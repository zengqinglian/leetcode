Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].




EXPLAINATION:

Thinking of the 'nums' array [1, 2, 3, 4, 5, 6], and the 'result' array [1, 1, 1, 1, 1, 1]. Every number in 'nums' will be multiplied in 'result' array except itself, then we will get the map below:

  1 2 3 4 5 6
  -----------
1|  1 1 1 1 1
2|2   2 2 2 2
3|3 3   3 3 3
4|4 4 4   4 4
5|5 5 5 5   5
6|6 6 6 6 6

(horizontal axis is nums array, vertical axis is multiplied times)
Noticed the regular pattern of the upper triangular and lower triangular. Using integers to store the products of the lower and upper triangulars, then we can do it in one pass:

i : left index of the nums array
j : right index of the nums array
left : left products multiplied from nums[0] to nums[i].
right : right products multiplied from nums[j] to nums[nums.length - 1].
We multiply left to result[i + 1] ((i, i + 1) in the uppper triangular),

and multiply right to result[j - 1] ((j, j - 1) in the lower triangular),

finally we have calculated the products of the nums except current.