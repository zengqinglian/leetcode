package partitionStringIntoSubstringsWithValuesatMostK;
/*
Runtime
6 ms
Beats
84.2%
Memory
43.9 MB
Beats
39.5%
 */
public class Solution {
    public int minimumPartition(String s, int k) {

        long total = 0;
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            int v = s.charAt(i)-'0';
            if (v > k) {
                return -1;
            }

            long newTotal = total*10 +v;
            if (newTotal > k) {
                count++;
                total = v;
            }else {
                total = newTotal;
            }
        }
        return count+1;
     }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minimumPartition("165462",60));
    }
}
