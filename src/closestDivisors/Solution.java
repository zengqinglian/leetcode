package closestDivisors;

public class Solution {
    //9ms solution beat 20%
    public int[] closestDivisors(int num) {
        int[] arr = new int[2];
        if(num==1){
            arr[0] =1;
            arr[1] =2;
            return arr;
        }
        int min = num;
        int n1 = num+1;
        int n2 = num+2;
        for(int i=2; i<=Math.sqrt(num+2); i++){
            if(n1 % i ==0){
                int res = n1 / i;
                int newMin = Math.abs(res-i);
                if(newMin < min){
                    min = newMin;
                    arr[0] = i;
                    arr[1] = res;
                }
            }else if(n2 % i ==0){
                int res = n2 / i;
                int newMin = Math.abs(res-i);
                if(newMin < min){
                    min = newMin;
                    arr[0] = i;
                    arr[1] = res;
                }
            }
        }
        return arr;
    }
}
