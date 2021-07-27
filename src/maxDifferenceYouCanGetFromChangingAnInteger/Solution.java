package maxDifferenceYouCanGetFromChangingAnInteger;
/*
Runtime: 0 ms, faster than 100.00% of Java online submissions for Max Difference You Can Get From Changing an Integer.
Memory Usage: 35.8 MB, less than 64.22% of Java online submissions for Max Difference You Can Get From Changing an Integer.
 */
public class Solution {
    public int maxDiff(int num) {
        int[] digit = new int[9];
        int idx =0;
        while(num>=10){
            digit[idx++] = num%10;
            num/=10;
        }
        digit[idx] = num;
        int a = 0;
        int first = -1;
        int b = 0;
        int second = -1;
        int newVal = -1;
        for(int i=idx ; i>=0; i--){
            if(first == -1){
                if(digit[i] !=9){
                    first = digit[i];
                }
                a= a * 10 + 9;
            }else{
                if(first == digit[i]){
                    a= a * 10 + 9;
                }else{
                    a= a * 10 + digit[i];
                }
            }
            if(second == -1){
                if(idx == i){
                    if(digit[i] !=1){
                        b = b * 10 + 1;
                        newVal =1;
                        second = digit[i];
                    }else{
                        b = b * 10 + digit[i];
                    }
                }else{
                    if(digit[i] !=0 && digit[i]!=1){
                        b = b * 10 + 0;
                        newVal =0;
                        second = digit[i];
                    }else{
                        b = b * 10 + digit[i];
                    }
                }
            }else{
                if(second == digit[i]){
                    b= b*10 + newVal;
                }else{
                    b = b*10+digit[i];
                }
            }
        }
        return a-b;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxDiff(123456);
    }
}
