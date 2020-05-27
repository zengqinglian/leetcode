package numberofBurgerswithNoWasteofIngredients;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    //1ms solution , beat 100%
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        if(tomatoSlices % 2 ==1){
            return Collections.emptyList();
        }
        if( cheeseSlices * 4 < tomatoSlices ){
            return Collections.emptyList();
        }
        int large = tomatoSlices / 2 - cheeseSlices;
        if(large<0){
            return Collections.emptyList();
        }
        int small = cheeseSlices - large;
        List<Integer> res = new ArrayList<>();
        res.add(large);
        res.add(small);
        return res;
    }
}
