package filterRestaurantsByVeganFriendlyPriceAndDistance;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
  //6ms solution, beat 50%
  public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
    List<int[]> restaurantsList = new ArrayList<>();
    for(int[] re : restaurants){
      if(((veganFriendly ==1 && re[2] == veganFriendly) || (veganFriendly==0)) && re[3]<= maxPrice && re[4]<=maxDistance){
        restaurantsList.add(re);
      }
    }
    restaurantsList.sort((a,b)->{
      if(b[1]==a[1]){
        return Integer.compare(b[0], a[0]);
      }
      return Integer.compare(b[1], a[1]);
    });

    return restaurantsList.stream().map(re->re[0]).collect(Collectors.toList());
  }
}
