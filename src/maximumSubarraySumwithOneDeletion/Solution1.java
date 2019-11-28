package maximumSubarraySumwithOneDeletion;

import java.util.LinkedList;

public class Solution1 {
    //Still Overtime limited failed 30/32
    public int maximumSum(int[] arr) {
        LinkedList<Node> q = new LinkedList<>();
        int res = Integer.MIN_VALUE;
        int max_minus = 0;
        if(arr[0]>0) {
            q.add(new Node(arr[0]));
        }else{
            max_minus = arr[0];
        }
        for(int i=1; i<arr.length; i++){
            if(arr[i]>=0){
                int size = q.size();

                if(q.size() ==0){
                    q.add(new Node(arr[i]));
                }

                boolean newHead = false;
                for(int j=0; j<size; j++){
                    Node cur = q.removeFirst();
                    res = Math.max(res, cur.sum);
                    if(! cur.skipped ) {
                        cur.sum = cur.sum + arr[i];
                        q.add(cur);
                    }else{
                        cur.sum = cur.sum + arr[i];
                        q.add(cur);
                        if(!newHead) {
                            q.add(new Node(arr[i]));
                            newHead = true;
                        }
                    }
                }
            }else{
                max_minus = Math.max(max_minus, arr[i]);
                int size = q.size();
                for(int j=0; j<size; j++){
                    Node cur = q.removeFirst();
                    res = Math.max(res, cur.sum);
                    int newSum =cur.sum + arr[i];
                    if(newSum<=0){
                        if(!cur.skipped){
                            cur.skipped=true;
                            q.add(cur);
                        }
                    }else{
                        if(!cur.skipped){
                            cur.skipped=true;
                            q.add(cur);
                            Node newNode = new Node(newSum);
                            q.add(newNode);
                        } else{
                            cur.sum = newSum;
                            q.add(cur);
                        }
                    }
                }
            }
        }
        while(!q.isEmpty()){
            res = Math.max(res, q.removeFirst().sum);
        }
        if(res == Integer.MIN_VALUE){
            res=max_minus;
        }

        return res;
    }

    private static class Node {
        private int sum;
        private boolean skipped = false;

        Node(int sum ){
            this.sum = sum;
        }

    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] arr = {11,-10,-11,8,7,-6,9,4,11,6,5,0};
        s.maximumSum(arr);
    }
}
