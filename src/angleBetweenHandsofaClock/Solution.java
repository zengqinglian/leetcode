package angleBetweenHandsofaClock;

public class Solution {
  //0ms solution, meet avg 50%
  public double angleClock(int hour, int minutes) {
    double angle_per_min_Min = 6.0;
    double angle_per_min_Hour = 0.5;
    double res = Math.abs((angle_per_min_Min * minutes) - ((hour * 30.0)+ minutes * 0.5));
    if(res>180){
      return 360-res;
    }
    return res;
  }
}
