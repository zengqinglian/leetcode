package pathSumIII;

import java.util.HashMap;
/*
someone's prevfix map solution
 */
public class Solution2 {

    int result=0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)return 0;
        HashMap<Long,Integer>map=new HashMap<>();

        map.put(0l,1);
        long sum=0;
        find_Sum(root,sum,targetSum,map);
        return result;
    }
    public void find_Sum(TreeNode curr,long sum,int target, HashMap<Long,Integer> map){
        if(curr==null)return ;
        sum+=curr.val;

        if(map.containsKey(sum-target))
            result+=map.get(sum-target);

        map.put(sum,map.getOrDefault(sum,0)+1);
        find_Sum(curr.left,sum,target,map);
        find_Sum(curr.right,sum,target,map);
        map.put(sum,map.get(sum)-1);
        return ;

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node9 = new TreeNode(1);

        node1.left = node2;
        node1.right=node3;
        node2.left = node4;
        node2.right = node5;
        node5.right = node9;
        node4.left = node7;
        node4.right = node8;
        node3.right = node6;

        Solution2 s = new Solution2();
        s.pathSum(node1,8);


    }

    private static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
