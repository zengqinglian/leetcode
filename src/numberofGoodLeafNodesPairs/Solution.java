package numberofGoodLeafNodesPairs;
/*
Runtime: 4 ms, faster than 82.11% of Java online submissions for Number of Good Leaf Nodes Pairs.
Memory Usage: 49.7 MB, less than 28.07% of Java online submissions for Number of Good Leaf Nodes Pairs.
 */
public class Solution {
    int cnt = 0;
    public int countPairs(TreeNode root, int distance) {
        if(distance<=1) {
            return 0;
        }
        generateDistance(root ,distance);
        return cnt;
    }

    private int[] generateDistance(TreeNode root, int distance) {
        if(root.left == null && root.right==null) {
            int[] res = new int[11];
            res[0] = 1;
            return res;
        }
        int[] left=null;
        if(root.left != null) {
            left = generateDistance(root.left,distance);
        }
        int[] right=null;
        if(root.right!=null) {
            right = generateDistance(root.right, distance);
        }
        if(left==null && right==null){
            return null;
        }
        int[] res = new int[11];
        for(int i=0; i<11; i++) {
            if(i<10) {
                int newVal = 0;
                if(left!=null) {
                    newVal+=left[i];
                }
                if(right!=null){
                    newVal+=right[i];
                }
                res[i+1] = newVal;
            }
            if(left!=null && right!=null) {
                if(left[i]>0 && i+1<distance) {
                    for (int j = 0; j < 11; j++) {
                        if (right[j]>0) {
                            if(i+1 + j+1 <= distance)
                                cnt += (left[i] * right[j]);
                            else
                                break;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right=node7;
        s.countPairs(node1,3);
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
