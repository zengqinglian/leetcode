package constructQuadTree;

/*
 Runtime
 0 ms
 Beats
 100%
 Memory
 43.2 MB
 Beats
 62.98%
*/
public class Solution {
    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
    public Node construct(int[][] grid) {
        return helper(grid, 0,0, grid.length);
    }
    private Node helper(int[][] grid, int startH, int startL, int size) {
        if (size == 1 ) {
            return new Node(grid[startH][startL] == 1, true);
        }
        int base = grid[startH][startL];
        boolean allSame = true;
        for (int i=startH; i<startH+size; i++){
            for(int j = startL; j<startL+size; j++) {
                if (grid[i][j]!=base) {
                    allSame = false;
                    break;
                }
            }
            if (!allSame) {
                break;
            }
        }
        if (allSame) {
            return new Node(base == 1, true);
        }else{
            Node node = new Node(true, false);
            node.topLeft =  helper(grid, startH, startL, size/2);
            node.topRight =  helper(grid, startH, startL+size/2, size/2);
            node.bottomLeft =  helper(grid, startH+size/2, startL, size/2);
            node.bottomRight = helper(grid, startH+size/2,startL+size/2, size/2 );
            return node;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}};
        s.construct(grid);
    }
}
