package findTwoNonOverlappingSubArraysEachWithTargetSum;

import java.util.Arrays;
import java.util.LinkedList;
/*

56 / 60 test cases passed.
Status: Time Limit Exceeded
 */
public class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int[] fromHead = new int[arr.length];
        int[] fromTail = new int[arr.length];
        Arrays.fill(fromHead, arr.length);
        Arrays.fill(fromTail, arr.length);
        LinkedList<int[]> qHead = new LinkedList<>();
        LinkedList<int[]> qTail = new LinkedList<>();
        for (int i=0; i<arr.length; i++) {
            if(i>0) {
                if(fromHead[i-1] == 1) {
                    fromHead[i] =1;
                    continue;
                }
            }
                int size = qHead.size();
                for(int j=0; j<size; j++) {
                    int[] pop = qHead.pop();
                    if (arr[i] + pop[0] < target) {
                        pop[0] = arr[i] + pop[0];
                        pop[1]++;
                        qHead.add(pop);
                        fromHead[i] =Math.min(fromHead[i],fromHead[i-1]);
                    } else if (arr[i] + pop[0] == target) {
                        pop[1]++;
                        if (i == 0) {
                            fromHead[i] = pop[1];
                        } else {
                            fromHead[i] = Math.min(pop[1], fromHead[i - 1]);
                        }
                    }else{
                        fromHead[i] =fromHead[i-1];
                    }
                }
                if(arr[i] == target){
                    fromHead[i] = 1;
                }else if(arr[i]<target){
                    int[] p = {arr[i], 1};
                    qHead.add(p);
                }

        }

        for (int i=arr.length-1; i>=0; i--) {
            if(i<arr.length-1) {
                if(fromTail[i+1] == 1) {
                    fromTail[i] =1;
                    continue;
                }
            }
                int size = qTail.size();
                for(int j=0; j<size; j++) {
                    int[] pop = qTail.pop();
                    if (arr[i] + pop[0] < target) {
                        pop[0] = arr[i] + pop[0];
                        pop[1]++;
                        qTail.add(pop);
                        fromTail[i] =Math.min(fromTail[i],fromTail[i+1]);
                    } else if (arr[i] + pop[0] == target) {
                        pop[1]++;
                        if (i ==arr.length-1) {
                            fromTail[i] = pop[1];
                        } else {
                            fromTail[i] = Math.min(pop[1], fromTail[i + 1]);
                        }
                    }else{
                        fromTail[i] = fromTail[i+1];
                    }
                }
                if(arr[i] == target){
                    fromTail[i] = 1;
                }else if(arr[i]<target){
                    int[] p = {arr[i], 1};
                    qTail.add(p);
                }

        }
        int res = arr.length + 1;
        for(int i=0; i<arr.length-1; i++ ){
            int total = fromHead[i] + fromTail[i+1];
            res = Math.min(res, total);
        }
        if(res>arr.length){
            return -1;
        }
        return res ;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,1,1,2,2,2,4,4};
        s.minSumOfLengths(arr, 6);

    }
}
