package medianofTwoSortedArrays;

public class Solution
{
    public double findMedianSortedArrays( int[] nums1, int[] nums2 ) {
        int index1 = 0;
        int index2 = 0;
        int length1 = nums1.length;
        int length2 = nums2.length;
        int[] result = new int[length1 + length2];
        int resultIndex = 0;
        while( resultIndex < length1 + length2 ) {
            if( index1 < length1 && index2 < length2 ) {
                if( nums1[index1] <= nums2[index2] ) {
                    result[resultIndex] = nums1[index1];
                    index1++;
                    resultIndex++;
                } else {
                    result[resultIndex] = nums2[index2];
                    index2++;
                    resultIndex++;
                }
            } else {
                if( index1 >= length1 && index2 < length2 ) {
                    result[resultIndex] = nums2[index2];
                    index2++;
                    resultIndex++;
                }

                if( index2 >= length2 && index1 < length1 ) {
                    result[resultIndex] = nums1[index1];
                    index1++;
                    resultIndex++;
                }
            }
        }
        double retVal = 0.0;
        int mid = result.length / 2;

        if( (result.length % 2) == 0 ) {
            retVal = (result[mid] + result[mid - 1]) / 2.0;
        } else {
            retVal = result[mid];
        }

        return retVal;
    }

    public static void main( String[] args ) {
        int[] nums1 = new int[] {};
        int[] nums2 = new int[] { 2, 3 };
        Solution s = new Solution();
        double test = s.findMedianSortedArrays( nums1, nums2 );
    }

}
