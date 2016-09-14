package cloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        if (node == null) {
            return null;
        }

        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        map.put(node.label, newHead);
        newHead.neighbors.addAll(clone(node, map));

        return newHead;
    }

    private List<UndirectedGraphNode> clone(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> map) {
        List<UndirectedGraphNode> list = new ArrayList<>();
        for (UndirectedGraphNode cnode : node.neighbors) {
            if (map.containsKey(cnode.label)) {
                list.add(map.get(cnode.label));
            } else {
                UndirectedGraphNode newNode = new UndirectedGraphNode(cnode.label);
                map.put(cnode.label, newNode);
                list.add(newNode);
                newNode.neighbors.addAll(clone(cnode, map));
            }
        }

        return list;
    }

    public static void main(String[] args) {
        UndirectedGraphNode head = new UndirectedGraphNode(-1);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        head.neighbors.add(node1);
        Solution s = new Solution();
        s.cloneGraph(head);
    }

    private static class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;

        public UndirectedGraphNode(int x) {
            label = x;
            neighbors = new ArrayList<UndirectedGraphNode>();
        }
    }
}
