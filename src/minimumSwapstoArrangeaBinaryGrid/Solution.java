package minimumSwapstoArrangeaBinaryGrid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Runtime: 2 ms, faster than 80.26% of Java online submissions for Minimum Swaps to Arrange a Binary Grid.
Memory Usage: 41.6 MB, less than 59.21% of Java online submissions for Minimum Swaps to Arrange a Binary Grid.
 */
public class Solution {
    public int minSwaps(int[][] grid) {
        Integer[] arr = new Integer[grid.length];
        for(int i = 0; i<grid.length; i++) {
            int zeroCnt = 0;
            for(int j=grid.length - 1; j>=1; j--) {
                if(grid[i][j] == 0) {
                    zeroCnt++;
                }else {
                    break;
                }
            }
            arr[i] = zeroCnt;
        }

        List<Integer> list = new ArrayList<>(Arrays.asList(arr));
        int ret = 0 ;
        for(int i=0; i<grid.length-1; i++) {
            int tailZeroRequirement = grid.length - 1 - i;
            int targetIndex= -1;
            for(int j = i; j<arr.length; j++) {
                if(arr[j] >= tailZeroRequirement ) {
                    targetIndex = j;
                    break;
                }
            }
            if(targetIndex == -1) {
                return -1;
            }
            if(targetIndex == i) {
                continue;
            }
            ret += (targetIndex - i);
            int value = arr[targetIndex];
            for(int x = targetIndex-1 ; x>=i; x--) {
                arr[x+1] = arr[x];
            }
            arr[i] = value;
        }
        return ret;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid =  {{0,0,1},{1,1,0},{1,0,0}};
        s.minSwaps(grid);
    }
}
