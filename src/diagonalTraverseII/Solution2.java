package diagonalTraverseII;

import java.util.List;
//over memory limit
public class Solution2 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int[] resHolder = new int[100000 * 100000];
        int total = 0;
        for(int i=0; i<nums.size();i++){
            for(int j=0; j<nums.get(i).size(); j++){
                total++;
                int idx = (1+i+j) * (i+j) /2 + j;
                resHolder[idx] = nums.get(i).get(j);
            }
        }
        int[] res = new int[total];
        int idx=0;
        for(int v : resHolder){
            if(v!=0){
                res[idx++]=v;
            }
        }
        return res;
    }
}
