package minimumSwapstoMakeStringsEqual;

public class Solution {
    //1ms solution , meet avg speed.
    public int minimumSwap(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        int cnt = 0;
        for(int i=0; i<s1.length(); i++){
            char c1 = arr1[i];
            char c2 = arr2[i];

            if(c1 == c2){
                continue;
            }else{
                boolean found = false;
                int indexTwoSwap = -1;
                for(int j=i+1; j<arr1.length; j++){
                    if(arr1[j]!=arr2[j]){
                        if(arr2[j] == c2){
                            found = true;
                            cnt++;
                            arr1[i] = c2;
                            arr2[j] = c1;
                            break;
                        }else{
                            if(indexTwoSwap == -1){
                                indexTwoSwap = j;
                            }
                        }
                    }
                }
                if(!found){
                    if(indexTwoSwap==-1){
                        return -1;
                    }else{
                        cnt+=2;
                        arr2[indexTwoSwap] = arr2[i];
                    }
                }
            }
        }
        return cnt;

    }

    public static void main(String[] args) {
        Solution s= new Solution();
        s.minimumSwap("xxyyxyxyxx","xyyxyxxxyx");
    }
}
