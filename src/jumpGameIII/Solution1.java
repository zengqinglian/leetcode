package jumpGameIII;

public class Solution1 {

    //recursion,  3m solution, beat 7%
    public boolean canReach(int[] arr, int start) {
        if(arr[start]==0){
            return true;
        }
        boolean[] marker = new boolean[arr.length];

        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                marker[i] = true;
                if( canReachHelper(arr, i, marker, start)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean canReachHelper(int[] arr, int target, boolean[] marker, int start){
        for(int i=0; i<arr.length; i++){
            if(marker[i]){
                continue;
            }
            int indexRight = i + arr[i];
            int indexLeft = i-arr[i];
            if(indexLeft>=0 && indexLeft == target){
                marker[i]=true;
                if(i == start){
                    return true;
                }else{
                    boolean res = canReachHelper(arr, i, marker, start);
                    marker[i]=false;
                    if(res){
                        return res;
                    }
                }
            }

            if(indexRight<arr.length && indexRight == target){
                marker[i]=true;
                if(i == start){
                    return true;
                }else{
                    boolean res = canReachHelper(arr, i, marker, start);
                    marker[i]=false;
                    if(res){
                        return res;
                    }
                }
            }
        }
        return false;

    }


    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] arr = {4,2,3,0,3,1,2};
        s.canReach(arr, 0);
    }
}
