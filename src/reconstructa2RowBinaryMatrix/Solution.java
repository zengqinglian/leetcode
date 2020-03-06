package reconstructa2RowBinaryMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //15ms solution , meet avg speed.
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> res = new ArrayList<>(2);
        res.add(new ArrayList<>(colsum.length));
        res.add(new ArrayList<>(colsum.length));

        for(int i=0; i<colsum.length; i++){
            if(colsum[i] ==2){
                if(upper == 0 || lower == 0){
                    return new ArrayList<>();
                }
                res.get(0).add(1);
                res.get(1).add(1);
                upper--;
                lower--;
            }else if (colsum[i] == 0){
                res.get(0).add(0);
                res.get(1).add(0);
            }else{
                if(upper>=lower){
                    if(upper == 0){
                        return new ArrayList<>();
                    }
                    res.get(0).add(1);
                    res.get(1).add(0);
                    upper--;
                }else{
                    if(lower ==0){
                        return new ArrayList<>();
                    }
                    res.get(0).add(0);
                    res.get(1).add(1);
                    lower--;
                }
            }
        }
        if(upper!=0 || lower!=0){
            return new ArrayList<>();
        }
        return res;
    }
}
