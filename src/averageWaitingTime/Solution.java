package averageWaitingTime;
/*
Runtime 3ms
Beats
97.95%
of users with Java
Memory 72.35MB
Beats
89.74%
of users with Java
 */
public class Solution {
    public double averageWaitingTime(int[][] customers) {
        long totalWaitingTime = customers[0][1];
        long currentTime = customers[0][0] + customers[0][1];
        for (int i = 1; i < customers.length; i++) {
            if (currentTime <= customers[i][0]) {
                currentTime = customers[i][0] + customers[i][1];
                totalWaitingTime += customers[i][1];
            }else{
                currentTime = currentTime + customers[i][1];
                totalWaitingTime += (currentTime - customers[i][0]);
            }
        }
        return totalWaitingTime * 1.0/customers.length;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] customers = {{1,2},{2,5},{4,3}};
        s.averageWaitingTime(customers);
    }
}
