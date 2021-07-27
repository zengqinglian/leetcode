package diagonalTraverseII;

import java.util.Arrays;
import java.util.List;
/*
Over time limit solution
53 / 56 test cases passed.
 */
public class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int[] resHolder = new int[100000];
        int idx = 0;
        int maxCol = 0;
        for(int i=0; i<nums.size(); i++){
            int row = i;
            int col = 0;
            maxCol = Math.max(maxCol, nums.get(row).size());
            while(row>=0) {
                if(col<nums.get(row).size()) {
                    resHolder[idx++] = nums.get(row--).get(col++);
                }else{
                    row--;
                    col++;
                }
            }
        }
        for(int i=1; i<maxCol;i++){
            int col = i;
            int row = nums.size()-1;
            while(row>=0){
                if(col<nums.get(row).size()){
                    resHolder[idx++] = nums.get(row--).get(col++);
                }else{
                    row--;
                    col++;
                }
            }
        }
        return Arrays.copyOf(resHolder,idx);
    }
}
