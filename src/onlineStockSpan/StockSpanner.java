package onlineStockSpan;

import java.util.ArrayList;
import java.util.List;

class StockSpanner {
    // 137 solution , beat 60%
    private List<Node> list = new ArrayList<>();

    public StockSpanner() {
        
    }
    
    public int next(int price) {
	if (list.isEmpty()) {
	    Node node = new Node(price);
	    node.result = 1;
	    list.add(node);
	    return 1;
	}
	int result =1;
	Node newNode = new Node(price);
	for (int i = list.size() - 1; i >= 0;) {
	    Node nodeAtIndex = list.get(i);
	    if (nodeAtIndex.val > price) {
		break;
	    } else {
		result += nodeAtIndex.result;
		i = i - nodeAtIndex.result;
	    }
	}
	newNode.result = result;
	list.add(newNode);
	return newNode.result;
    }

    private static class Node {
	private int val;
	private int result;

	public Node(int val) {
	    this.val = val;
	}
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner(); int param_1 = obj.next(price);
 */
