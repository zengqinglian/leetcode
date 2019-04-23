package smallestStringStartingFromLeaf;

public class Solution {
    // 1ms solution, beat 99%

    String min = null;
    StringBuilder sb = new StringBuilder();
    public String smallestFromLeaf(TreeNode root) {
	smallestFromLeaf2(root);
	return min;
    }

    public void smallestFromLeaf2(TreeNode root) {
	sb.append((char) (root.val + 'a'));
	int len = sb.length();
	if (root.left == null && root.right == null) {
	    String str = sb.reverse().toString();
	    if (min == null) {
		min = str;
	    } else {
		if (min.compareTo(str) > 0) {
		    min = str;
		}
	    }
	    sb.reverse();
	}

	if (root.left != null) {
	    smallestFromLeaf2(root.left);
	}
	sb.setLength(len);
	if (root.right != null) {
	    smallestFromLeaf2(root.right);
	}


    }

    private static class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    public static void main(String[] args) {
	System.out.println("ba".compareTo("a"));
    }
}
