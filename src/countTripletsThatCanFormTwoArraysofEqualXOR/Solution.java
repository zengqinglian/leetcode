package countTripletsThatCanFormTwoArraysofEqualXOR;
/*
Runtime: 1 ms, faster than 99.64% of Java online submissions for Count Triplets That Can Form Two Arrays of Equal XOR.
Memory Usage: 36.6 MB, less than 54.18% of Java online submissions for Count Triplets That Can Form Two Arrays of Equal XOR.
 */
public class Solution {
    public int countTriplets(int[] arr) {
        int total = 0;
        for(int i=0; i<arr.length; i++){
            int v = arr[i];
            for(int j=i+1; j<arr.length; j++){
                v^=arr[j];
                if(v == 0){
                    total += (j-i);
                }
            }
        }
        return total;
    }
}
