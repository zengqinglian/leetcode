package allElementsinTwoBinarySearchTrees;

import java.util.ArrayList;
import java.util.List;

//14ms solution, beat 80%
public class Solution {
    private List<Integer> res1 = new ArrayList<>();
    private List<Integer> res2 = new ArrayList<>();
    private List<Integer> res = new ArrayList<>();
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        help(root1, res1);
        help(root2, res2);
        int i=0;
        int j=0;
        while(i<res1.size() && j<res2.size()){
            if(res1.get(i) <= res2.get(j)){
                res.add(res1.get(i));
                i++;
            }else{
                res.add(res2.get(j));
                j++;
            }
        }
        if(i==res1.size()){
            for(int x=j; x<res2.size(); x++){
                res.add(res2.get(x));
            }
        }
        if(j==res2.size()){
            for(int x=i; x<res1.size(); x++){
                res.add(res1.get(x));
            }
        }
        return res;
    }

    public void help(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        if(root.left!=null){
            help(root.left,list);
        }
        list.add(root.val);
        if(root.right!=null){
            help(root.right, list);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root1 = new TreeNode(2);
        TreeNode t1_1 = new TreeNode(1);
        TreeNode t1_2 = new TreeNode(4);
        root1.left = t1_1;
        root1.right = t1_2;

        TreeNode root2 = new TreeNode(1);
        TreeNode t2_1 = new TreeNode(0);
        TreeNode t2_2 = new TreeNode(3);

        root2.left = t2_1;
        root2.right = t2_2;
        s.getAllElements(root1,root2);
    }


    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
