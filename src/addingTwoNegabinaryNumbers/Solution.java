package addingTwoNegabinaryNumbers;

import java.util.ArrayList;
import java.util.List;
/*
Runtime
2 ms
Beats
80%
Memory
44 MB
Beats
52%
 */
public class Solution {
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int loop = Math.max(arr1.length , arr2.length);
        List<Integer> resList = new ArrayList<>();
        int promo = 0;
        for(int i=0; i<loop; i++) {
            int idx1 = arr1.length-i-1;
            int idx2 = arr2.length-i-1;
            int total = 0;
            if (idx1>=0 && idx1<arr1.length) {
                if (i%2==0){
                    total = arr1[idx1];
                }else{
                    total = -arr1[idx1];
                }
            }
            if (idx2>=0 && idx2<arr2.length) {
                if (i%2==0) {
                    total = total + arr2[idx2];
                }else{
                    total = total - arr2[idx2];
                }
            }
            total = total + promo;
            if (promo!=0) {
                if ((total > 0 && i % 2 == 1) || (total<0 && i%2==0)) {
                    if (i%2==1) {
                        promo = 1;
                    }else{
                        promo = -1;
                    }
                    resList.add(1);
                }else {
                    int value = Math.abs(total) % 2;
                    resList.add(value);
                    promo = Math.abs(total) / 2;
                    if (i%2==1){
                        promo = promo * -1;
                    }
                }
            }else{
                int value = Math.abs(total) % 2;
                promo = Math.abs(total) / 2;
                if (i%2==1){
                    promo = promo * -1;
                }
                resList.add(value);
            }
        }
        if ((promo == 1 && resList.size() %2 == 1) || (promo==-1 && resList.size() %2==0)) {
            resList.add(1);
            resList.add(1);
        }else if (promo == 1){
            resList.add(1);
        }
        int startIndex = 0;
        for (int i=resList.size()-1; i>=0; i--) {
            if (resList.get(i)>0) {
                startIndex = i;
                break;
            }
        }
        int[] res = new int[startIndex+1];
        for (int i=0; i<res.length; i++) {
            res[i] = resList.get(startIndex--);
        }
        return res;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr1 = {1,0};
        int[] arr2 = {1,0};
        s.addNegabinary(arr1,arr2);
    }
}
