package jumpGameIII;

public class Solution2 {
    //someone's recursion solution ,beat 100%
    public boolean canReach(int[] arr, int start) {
        if (start >= 0 && start < arr.length && arr[start] >= 0) {
            if (arr[start] == 0) {
                return true;
            }
            arr[start] = -arr[start];
            return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
        }
        return false;
    }
}
