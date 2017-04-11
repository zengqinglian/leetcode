package superWashingMachines;

public class Solution {
    public int findMinMoves(int[] machines) {
        /*
         * Some one is o(N) solution
         * 
         * Let me use an example to briefly explain this. For example, your
         * machines[] is [0,0,11,5]. So your total is 16 and the target value
         * for each machine is 4. Convert the machines array to a kind of
         * gain/lose array, we get: [-4,-4,7,1]. Now what we want to do is go
         * from the first one and try to make all of them 0. To make the 1st
         * machines 0, you need to give all its "load" to the 2nd machines. So
         * we get: [0,-8,7,1] then: [0,0,-1,1] lastly: [0,0,0,0], done. You
         * don't have to worry about the details about how these machines give
         * load to each other. In this process, the least steps we need to
         * eventually finish this process is determined by the peak of abs(cnt)
         * and the max of "gain/lose" array. In this case, the peak of abs(cnt)
         * is 8 and the max of gain/lose array is 7. So the result is 8.
         * 
         * Some other example: machines: [0,3,0]; gain/lose array: [-1,2,-1];
         * max = 2, cnt = 0, -1, 1, 0, its abs peak is 1. So result is 2.
         * machines: [1,0,5]; gain/lose array: [-1,-2,3]; max = 3, cnt = 0, -1,
         * -3, 0, its abs peak is 3. So result is 3.
         */
        if (machines.length == 1) {
            return 0;
        }
        int total = 0;
        for (int m : machines) {
            total += m;
        }

        if (total % machines.length != 0) {
            return -1;
        }

        int avg = total / machines.length, cnt = 0, max = 0;
        for (int load : machines) {
            cnt += load - avg; // load-avg is "gain/lose"
            max = Math.max(Math.max(max, Math.abs(cnt)), load - avg);
        }

        return max;
    }
}
