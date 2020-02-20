package countNumberofNiceSubarrays;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    //12ms solution , meet avg speed. beat 50%
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> q = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i]%2==1){
                q.add(i);
            }
        }
        if(q.size() < k){
            return 0;
        }

        int res = 0;
        int front = 0;
        int end = 0;
        for(int j = k-1, i=0; j<q.size(); j++,i++){
            if(i==0){
                front = q.get(i)+1;
            }else{
                front = q.get(i) - q.get(i-1);
            }
            if(j==q.size()-1){
                end = nums.length - q.get(j);
            }else{
                end = q.get(j+1)- q.get(j);
            }
            res += (front * end);
        }
        return res;
    }
}
