package closestPrimeNumbersinRange;
/*
Runtime
353 ms
Beats
31.79%
Memory
43.9 MB
Beats
72.18%
 */
public class Solution {
    public int[] closestPrimes(int left, int right) {
        if (right - left <=1) {
            int[] res = {-1,-1};
            return res;
        }

        boolean[] notPrime = new boolean[right+1];
        notPrime[1]=true;
        for (int i=2; i<=right/2; i++) {
            if (!notPrime[i]) {
                for (int j=2; j<=right/i; j++) {
                    notPrime[i * j] = true;
                }
            }
        }
        int res1 = -1;
        int res2=-1;
        int found1 = -1;
        int diff = right - left +1;

        for(int i=left; i<=right; i++) {
            if (!notPrime[i]) {
                if (found1==-1) {
                    found1 = i;
                }else{
                    int newDiff = i - found1;
                    if (newDiff < diff) {
                        res1 = found1;
                        res2=i;
                        diff = newDiff;
                    }
                    found1 = i;
                }
            }
        }
        if (res2==-1) {
            int[] res = {-1,-1};
            return res;
        }
        int[] res = {res1, res2};
        return res;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.closestPrimes(999959,999961);
    }
}
