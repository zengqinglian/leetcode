package distinctPrimeFactorsofProductofArray;
/*
Runtime
17 ms
Beats
75.97%
Memory
44.9 MB
Beats
6.1%
 */
public class Solution {
    public int distinctPrimeFactors(int[] nums) {
        boolean[] numbers = new boolean[1001];

        for (int i=2; i<=500; i++) {
            if (numbers[i]) {
                continue;
            }
            for(int j=2; j<=1000/i; j++) {
                numbers[i * j] = true;
            }
        }


        int count = 0;
        for (int i=2; i<=1000; i++) {
            if (!numbers[i]) {
                for (int n : nums) {
                    if (n<i){
                        continue;
                    }
                    if (n % i == 0) {
                        count++;
                        break;
                    }
                }
            }
        }

        return count;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2,4,8,16};
        s.distinctPrimeFactors(nums);
    }
}
