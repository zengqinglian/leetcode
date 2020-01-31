package circularPermutationinBinaryRepresentation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
//5ms solution  , beat 90%
    public List<Integer> circularPermutation(int n, int start) {

        int startIndex = -1;
        Integer[] holder = new Integer[(int)Math.pow(2, n)];
        holder[0]=0;
        holder[1]=1;
        if(start ==1){
            startIndex = 1;
        }
        if(start ==0){
            startIndex = 0;
        }

        for(int i=2; i<=n; i++){
            int size = (int)Math.pow(2, i-1);
            int addVal = size;
            for(int j=size-1 ; j>=0; j--){
                int newVal = holder[j]+addVal;
                holder[size+(size-1-j)] = newVal;
                if(newVal == start){
                    startIndex = size+(size-1-j);
                }
            }
        }
        Integer[] p1 = Arrays.copyOfRange(holder, startIndex, holder.length);
        Integer[] p2 = Arrays.copyOfRange(holder, 0, startIndex);
        List<Integer> res = new ArrayList<>(Arrays.asList(p1));
        res.addAll(Arrays.asList(p2));


        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.circularPermutation(3,2);
    }


}
