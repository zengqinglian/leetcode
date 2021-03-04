package cinemaSeatAllocation;

import java.util.Arrays;
// time over limit solution , 50 / 53 test cases passed.
public class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats, (a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        int case1 = (1 << 8) + (1<<7) + (1<<6) + (1<<5) + (1<<4) + (1<<3) + (1<<2) + (1<<1);
        int case2 = (1 << 8) + (1<<7) + (1<<6) + (1<<5);
        int case3 = (1<<6) + (1<<5) + (1<<4) + (1<<3);
        int case4 = (1<<4) + (1<<3) + (1<<2) + (1<<1);

        int index = 0;
        int cnt = 0;
        for(int i=1; i<=n; i++){
            int value = 0;
            if(index<reservedSeats.length && reservedSeats[index][0] > i){
                cnt+=2;
                continue;
            }else {
                while (index<reservedSeats.length && reservedSeats[index][0] == i) {
                    value += (1 << (reservedSeats[index][1] - 1));
                    index++;
                }
                if ((value & case1) == 0) {
                    cnt += 2;
                } else if ((value & case2) == 0 || (value & case3) == 0 || (value & case4) == 0) {
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        //int[][] reservedSeats = {{1,2},{1,3},{1,8},{2,6},{3,1},{3,10}};
        int[][] reservedSeats = {{2,3}};
        s.maxNumberOfFamilies(3,reservedSeats);
    }
}
