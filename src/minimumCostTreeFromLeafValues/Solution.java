package minimumCostTreeFromLeafValues;

public class Solution {
    //1ms solution , beat 80%
    public int mctFromLeafValues(int[] arr) {
         if(arr.length ==2){
             return arr[0] * arr[1];
         }
         int min = Integer.MAX_VALUE;
         int[] newArr = new int[arr.length-1];
         int idx =  -1;
         for(int i=1; i<arr.length; i++){
             if(min>Math.max(arr[i-1],arr[i])){
                 idx = i;
                 min =Math.max(arr[i-1],arr[i]);
             }
         }
         int prod = arr[idx-1] * arr[idx];
         int index = 0;
         for(int i=0;i<arr.length; i++){
             if(i==idx-1){
                 newArr[index++]=Math.max(arr[idx-1] , arr[idx]);
             }else if(i==idx){

             }else{
                 newArr[index++]=arr[i];
             }
         }
         int res = prod + mctFromLeafValues(newArr) ;
         return res;
    }



    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,2,4,6,1,2};
        int res = s.mctFromLeafValues(arr);
        System.out.print(res);
    }
}
