package serializeandDeserializeBST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
/*
Runtime
21 ms
Beats
11.74%
Memory
44.3 MB
Beats
63.41%
 */
public class Codec1 {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        List<String> preOrder = new ArrayList<>(10001);
        List<String> inOrder = new ArrayList<>(10001);
        updateArrayPreOrder(root, preOrder);
        updateArrayInOrder(root, inOrder);

        return preOrder.stream().collect(Collectors.joining(","))
                + "-"
                + inOrder.stream().collect(Collectors.joining(","));
    }

    private void updateArrayPreOrder(TreeNode node, List<String> list) {
        list.add(String.valueOf(node.val));
        if (node.left!=null) {
            updateArrayPreOrder(node.left, list);
        }
        if (node.right!=null) {
            updateArrayPreOrder(node.right, list);
        }
    }

    private void updateArrayInOrder(TreeNode node, List<String> list) {
        if (node.left!=null) {
            updateArrayInOrder(node.left, list);
        }
        list.add(String.valueOf(node.val));
        if (node.right!=null) {
            updateArrayInOrder(node.right, list);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data ==""){
            return null;
        }
        String[] orders = data.split("-");
        int[] preOrder = Arrays.stream(orders[0].split(",")).mapToInt(Integer::valueOf).toArray();
        int[] inOrder = Arrays.stream(orders[1].split(",")).mapToInt(Integer::valueOf).toArray();

        TreeNode root = convertToTree(preOrder, inOrder , 0, preOrder.length-1, 0, inOrder.length-1);
        return root;
    }

    private TreeNode convertToTree(int[] preOrder, int[] inOrder, int preOrderStartIndex, int preOrderEndIndex, int inOrderStartIndex, int inOrderEndIndex) {
        TreeNode node = new TreeNode(preOrder[preOrderStartIndex]);
        int inOrderRootIndex = Arrays.binarySearch(inOrder, inOrderStartIndex, inOrderEndIndex+1, preOrder[preOrderStartIndex]);
        int leftTreeNumber = inOrderRootIndex - inOrderStartIndex;
        if (leftTreeNumber>0) {
            node.left = convertToTree(preOrder, inOrder, preOrderStartIndex+1, preOrderStartIndex+leftTreeNumber, inOrderStartIndex, inOrderRootIndex-1);
        }
        int rightTreeNumber = inOrderEndIndex - inOrderRootIndex;
        if(rightTreeNumber >0 ){
            node.right = convertToTree(preOrder, inOrder, preOrderStartIndex+leftTreeNumber+1, preOrderEndIndex, inOrderRootIndex+1, inOrderEndIndex);
        }
        return node;
    }

    public static void main(String[] args) {
        Codec1 codec1 = new Codec1();
        TreeNode root = codec1.deserialize("41,37,24,1,0,2,4,3,9,7,6,5,8,11,10,16,15,12,13,14,19,18,17,20,22,21,23,35,30,29,26,25,27,28,32,31,34,33,36,39,38,40,44,42,43,48,46,45,47,49-0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49");
        String str = codec1.serialize(root);
        codec1.deserialize(str);
    }
}
