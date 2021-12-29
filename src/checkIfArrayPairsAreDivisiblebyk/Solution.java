package checkIfArrayPairsAreDivisiblebyk;
/*
Runtime: 13 ms, faster than 60.10% of Java online submissions for Check If Array Pairs Are Divisible by k.
Memory Usage: 73.7 MB, less than 12.95% of Java online submissions for Check If Array Pairs Are Divisible by k.
 */
public class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] checkerPlus = new int[k];
        int[] checkerMinus = new int[k];
        for(int v : arr) {
            int mod = Math.abs(v) % k;
            int index = (mod == 0 ? 0: k-mod);
            if(v>=0) {
                if (checkerPlus[index] > 0) {
                    checkerPlus[index]--;
                } else {
                    checkerPlus[mod]++;
                }
            }else{
                if (checkerMinus[index] > 0) {
                    checkerMinus[index]--;
                } else {
                    checkerMinus[mod]++;
                }
            }
        }
        for(int i=0; i<k;i++){
            if(checkerMinus[i]!= checkerPlus[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {11,12,1,2,3,4,5,10,6,7,8,9};
        s.canArrange(arr, 5);
    }
}
