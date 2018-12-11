package maximumFrequencyStack;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//135 ms solution. meet avg speed.
public class FreqStack1 {

    private PriorityQueue<Node> llist = new PriorityQueue<>();
    private int total = 0;
    Map<Integer, Integer> numToCount = new HashMap<>();

    public FreqStack1() {

    }

    public void push(int x) {
	total++;
	Integer count = numToCount.get(x);
	if(count==null) {
	    llist.add(new Node(x, 1, total));
	    numToCount.put(x, 1);
	}else {
	    numToCount.put(x, count + 1);
	    llist.add(new Node(x, count+1, total));
	}
    }

    public int pop() {
	Node node = llist.poll();
	numToCount.put(node.val, node.count - 1);
	return node.val;
    }

    private static class Node implements Comparable<Node> {
	private int val;
	private int count;
	private int total;

	Node(int val, int count, int total) {
	    this.val = val;
	    this.count = count;
	    this.total = total;
	}

	@Override
	public String toString() {
	    return "Node [val=" + val + ", count=" + count + "]";
	}

	@Override
	public int compareTo(Node o) {
	    if (count != o.count) {
		return Integer.compare(o.count, this.count);
	    } else {
		return Integer.compare(o.total, this.total);
	    }
	}

    }

    public static void main(String[] args) {
	FreqStack1 s = new FreqStack1();
	s.push(1);
	s.push(1);
	s.push(1);
	s.push(2);
	System.out.println(s.pop());
	System.out.println(s.pop());
	s.push(2);
	s.push(2);
	s.push(1);

	System.out.println(s.pop());

	System.out.println(s.pop());

	System.out.println(s.pop());
	// s.push(5);
	// System.out.println(s.pop());
	// s.push(6);
	//
	// System.out.println(s.pop());
	// System.out.println(s.pop());
	// System.out.println(s.pop());

    }
}
