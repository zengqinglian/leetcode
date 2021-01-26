package validateBinaryTreeNodes;


import java.util.Stack;

public class Solution {
    //7ms solution , meet avg speed.
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        if(n==1){
            return true;
        }
        int[] parents = new int[n];
        int[] children = new int[n];
        int rootIndex = -1;
        for(int i=0; i<n; i++){
            if(leftChild[i] != -1){
                parents[leftChild[i]]++;
                children[i]++;
            }
            if(rightChild[i] != -1){
                parents[rightChild[i]]++;
                children[i]++;
            }
        }

        int root = 0;
        for(int i=0;i<n;i++){
            if(parents[i]==0){
                root++;
                rootIndex=i;
            }else if(parents[i]>=2){
                return false;
            }
        }
        if(root != 1){
            return false;
        }
        for(int i=0; i<n;i++){
            if(children[i]>2){
                return false;
            }
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(rootIndex);
        int cnt = 1;
        boolean[] visited = new boolean[n];
        visited[rootIndex] = true;
        while(!stack.isEmpty()){
            int index = stack.pop();
            if(leftChild[index]!=-1){
                if(visited[leftChild[index]]){
                    return false;
                }else{
                    stack.push(leftChild[index]);
                    visited[leftChild[index]] = true;
                    cnt++;
                }
            }
            if(rightChild[index]!=-1){
                if(visited[rightChild[index]]){
                    return false;
                }else{
                    stack.push(rightChild[index]);
                    visited[rightChild[index]] = true;
                    cnt++;
                }
            }
        }
        if(cnt!=n){
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] lefts = {1,0,3,-1};
        int[] rights= {-1,-1,-1,-1};
        s.validateBinaryTreeNodes(4,lefts,rights);
    }
}
