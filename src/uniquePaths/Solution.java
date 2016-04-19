package uniquePaths;

import java.util.LinkedList;
import java.util.Queue;

public class Solution
{
    // Over time limit 23,12
    public int uniquePaths( int m, int n ) {
        Queue<Node> queue = new LinkedList<>();
        Node start = new Node( 0, 0 );
        queue.add( start );
        int total = 0;
        while( !queue.isEmpty() ) {
            Node node = queue.poll();
            if( node.m == m - 1 || node.n == n - 1 ) {
                total++;
            } else {
                if( node.m < m - 1 ) {
                    queue.add( new Node( node.m + 1, node.n ) );
                }

                if( node.n < n - 1 ) {
                    queue.add( new Node( node.m, node.n + 1 ) );
                }
            }
        }
        System.out.print( total );

        return total;
    }

    private static class Node
    {
        private int m;
        private int n;

        Node( int m, int n ) {
            this.m = m;
            this.n = n;
        }
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        s.uniquePaths( 4, 3 );
    }
}
