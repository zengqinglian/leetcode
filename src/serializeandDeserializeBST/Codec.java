package serializeandDeserializeBST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
/*
Runtime
24 ms
Beats
10.59%
Memory
46.9 MB
Beats
6.21%
 */
public class Codec {
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        List<String> list = new ArrayList<>(10001);
        updateArray(root, list, 0);

        return list.stream().collect(Collectors.joining(","));
    }

    private void updateArray(TreeNode node, List<String> list, int pos) {
        list.add(node.val + "-" + pos);
        if (node.left!=null) {
            updateArray(node.left, list, pos*2+1);
        }
        if (node.right != null) {
            updateArray(node.right, list, pos*2+2);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data ==""){
            return null;
        }
        String[] array = data.split(",");
        Map<Integer, Integer> map = Arrays.stream(array).map(str->str.split("-"))
                .collect(Collectors.toMap(pair-> Integer.valueOf(pair[1]), pair-> Integer.valueOf(pair[0])));
        TreeNode root = convertToTree(map, 0);
        return root;
    }

    private TreeNode convertToTree(Map<Integer, Integer> map, int idx) {
        if (map.get(idx)==null) {
            return null;
        }
        TreeNode node = new TreeNode(map.get(idx));
        node.left = convertToTree(map, idx*2+1);
        node.right = convertToTree(map, idx*2+2);
        return node;
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        TreeNode root = codec.deserialize("2,1,3");
        String str = codec.serialize(root);
        codec.deserialize(str);
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
