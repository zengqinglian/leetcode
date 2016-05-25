package searchinRotatedSortedArray;

public class Solution
{
    public int search( int[] nums, int target ) {
        if( nums == null || nums.length == 0 ) {
            return -1;
        }

        if( nums.length == 1 ) {
            if( nums[0] == target ) {
                return 0;

            } else {
                return -1;
            }
        }

        if( nums.length == 2 ) {
            if( nums[0] == target ) {
                return 0;
            } else if( nums[1] == target ) {
                return 1;
            } else {
                return -1;
            }
        }

        int length = nums.length;

        int left = 0;
        int right = length - 1;
        while( right - left >= 2 ) {
            if( nums[left] == target ) {
                return left;
            } else if( nums[right] == target ) {
                return right;
            } else if( nums[left] > nums[right] ) {
                if( target < nums[left] && target > nums[right] ) {
                    return -1;
                } else {
                    int mid = (right - left) / 2;
                    if( nums[left + mid] == target ) {
                        return left + mid;
                    } else {
                        if( nums[left + mid] > nums[left] ) {
                            if( target > nums[left] && target < nums[left + mid] ) {
                                right = left + mid;
                            } else {
                                left = left + mid;
                            }
                        } else {
                            if( target > nums[left + mid] && target < nums[right] ) {
                                left = left + mid;
                            } else {
                                right = left + mid;
                            }
                        }
                    }
                }
            } else {
                // the array in this range is sorted
                if( target < nums[left] ) {
                    return -1;
                } else if( target > nums[right] ) {
                    return -1;
                } else {

                    int mid = (right - left) / 2;
                    if( nums[left + mid] == target ) {
                        return left + mid;
                    } else if( nums[left + mid] > target ) {
                        right = left + mid;
                    } else {
                        left = left + mid;
                    }
                }

            }
        }

        if( nums[left] == target ) {
            return left;
        }

        if( nums[right] == target ) {
            return right;
        }

        return -1;

    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] nums = { 4, 5, 6, 7, 8, 1, 2, 3 };
        s.search( nums, 2 );
    }
}
