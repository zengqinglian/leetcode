package trappingRainWater;
/*
Runtime
1ms
Beats
70.09%
Analyze Complexity
Memory 46.52MB
Beats
12.75%
 */
public class Solution3 {
    public int trap(int[] height) {
        int[] walls = new int[height.length];
        int wallVal = 0;
        for(int i=0; i<height.length; i++){
            wallVal = Math.max(wallVal,height[i]);
            walls[i] = wallVal;
        }
        wallVal = 0;
        for(int i=height.length-1; i>=0; i--){
            wallVal = Math.max(wallVal,height[i]);
            walls[i] = Math.min(walls[i],wallVal) ;
        }
        int res = 0;
        for(int i=0; i<walls.length; i++){
            if (walls[i] > height[i]) {
                res += (walls[i] - height[i]);
            }
        }
        return res;
    }
}
