package stoneGamevi;

import java.util.PriorityQueue;
/*
134ms
Beats 10.71%
Analyze Complexity
Memory 59.82 MB
Beats 22.86%
 */
public class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        PriorityQueue<int[]> totalQ = new PriorityQueue<>((a,b)-> Integer.compare(b[0], a[0]));
        for (int i = 0; i < aliceValues.length; i++) {
            int total = aliceValues[i] + bobValues[i];
            int[] node = new int[]{total, i};
            totalQ.add(node);
        }
        int totalAlice = 0;
        int totalBob = 0;
        boolean aliceTurn = true;
        while (!totalQ.isEmpty()) {
            int[] node = totalQ.poll();
            if (aliceTurn) {
                totalAlice+=aliceValues[node[1]];
            }else{
                totalBob+=bobValues[node[1]];
            }
            aliceTurn = !aliceTurn;
        }
        if (totalAlice > totalBob) {
            return 1;
        }else if (totalBob > totalAlice) {
            return -1;
        }else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] aliceValues = {2,9,1,1,1,3,5,8,8,6,8,6,2,4};
        int[] bobValues = {1,9,7,8,3,4,2,7,8,10,1,7,10,4};
        solution.stoneGameVI(aliceValues, bobValues);
    }
}
