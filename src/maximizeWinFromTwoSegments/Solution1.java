package maximizeWinFromTwoSegments;
/*
Runtime
8 ms
Beats
25.25%
Memory
55.1 MB
Beats
39.39%
 */
public class Solution1 {
    public int maximizeWin(int[] prizePositions, int k) {
        if (prizePositions.length == 1) {
            return 1;
        }

        int[] countArrayLeft = new int[prizePositions.length];
        int firstIndex =0;
        int lastIndex = firstIndex;

        while(lastIndex < prizePositions.length) {
            int diff = prizePositions[lastIndex] - prizePositions[firstIndex];
            if (diff <= k) {
                int count = lastIndex - firstIndex +1;
                if (lastIndex -1>=0) {
                    countArrayLeft[lastIndex] = Math.max(countArrayLeft[lastIndex-1], count);
                }else{
                    countArrayLeft[lastIndex] = count;
                }
                lastIndex++;
            }else {
                firstIndex++;
            }
        }


        int[] countArrayRight = new int[prizePositions.length];
        firstIndex = prizePositions.length-1;
        lastIndex = firstIndex;

        while(lastIndex>=0) {
            int diff = prizePositions[firstIndex] - prizePositions[lastIndex];
            if (diff <= k) {
                int count = firstIndex - lastIndex +1;
                if (lastIndex+1<prizePositions.length) {
                    countArrayRight[lastIndex] = Math.max(countArrayRight[lastIndex+1], count);
                }else{
                    countArrayRight[lastIndex] = count;
                }
                lastIndex--;
            }else {
                firstIndex--;
            }
        }


        int res = 0;
        for (int i=-1; i<prizePositions.length; i++) {
            int val=0;
            if (i>=0){
                val = countArrayLeft[i];
            }
            if (i+1<prizePositions.length){
                val = val + countArrayRight[i+1];
            }
            res = Math.max(res, val);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] prizes = {1,1,2,2,3,3,5};
        s.maximizeWin(prizes, 2);
    }
}
