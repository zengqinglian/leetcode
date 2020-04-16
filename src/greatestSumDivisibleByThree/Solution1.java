package greatestSumDivisibleByThree;

import java.util.*;

//9ms solution, beat 50%
public class Solution1 {
    public int maxSumDivThree(int[] nums) {
        int total = 0;
        PriorityQueue<Integer> remainOf1 = new PriorityQueue<>();
        PriorityQueue<Integer> remainOf2 = new PriorityQueue<>();

        for (int n : nums) {
            int remain = n % 3;
            if (remain == 1) {
                remainOf1.add(n);
            } else if (remain == 2) {
                remainOf2.add(n);
            }
            total += n;
        }

        if (remainOf1.size() < 3 && remainOf2.size() < 3) {
            if(remainOf1.size() ==0 || remainOf2.size() ==0){
                return 0;
            }else if (remainOf1.size() == remainOf2.size()) {
                return total;
            } else if (remainOf1.size() == 1) {
                return total - remainOf2.poll();
            } else {
                return total - remainOf1.poll();
            }
        }


        int remain_1 = remainOf1.size() % 3;
        int remain_2 = remainOf2.size() % 3;

        if(remainOf1.size()==0){
            if(remain_2==0){
                return total;
            }else if(remain_2==1){
                return total - remainOf2.poll();
            }else{
                return total - remainOf2.poll()- remainOf2.poll();
            }
        }

        if(remainOf2.size()==0){
            if(remain_1==0){
                return total;
            }else if(remain_1==1){
                return total - remainOf1.poll();
            }else{
                return total - remainOf1.poll()- remainOf1.poll();
            }
        }

        if (remain_1 == remain_2) {
            return total;
        } else {
            if (remain_1 - remain_2 == 1) {
                return Math.max(total - remainOf1.poll(), total-remainOf2.poll()-remainOf2.poll());
            }
            if (remain_2 - remain_1 == 1) {
                return Math.max(total - remainOf2.poll(), total-remainOf1.poll()-remainOf1.poll());
            }
            if (remain_1 - remain_2 == 2) {
                return Math.max(total - remainOf1.poll() - remainOf1.poll(),total-remainOf2.poll());
            }
            if (remain_2 - remain_1 == 2) {
                return Math.max(total - remainOf2.poll() - remainOf2.poll(), total-remainOf1.poll());
            }
            return 0;
        }
    }
}
