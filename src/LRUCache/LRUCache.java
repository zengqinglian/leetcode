package LRUCache;

import java.util.HashMap;
import java.util.Map;

//63ms, beat 50%
public class LRUCache {

    private int capacity;
    private Map<Integer, Node> map = new HashMap<>();
    private Node tail = null;
    private Node head = null;

    public LRUCache(int capacity) {
	this.capacity = capacity;
    }

    public int get(int key) {
	Node res = map.get(key);
	
	if (res == null) {
	    return -1;
	}
	
	if (map.size() == 1) {
	    return res.value;
	}

	if (head.key == res.key) {
	    return res.value;
	}

	if (tail.key == res.key) {
	    tail = tail.pre;
	    tail.next = null;
	} else {
	    res.next.pre = res.pre;
	}

	res.pre.next = res.next;

	res.next = head;
	res.pre = null;
	head.pre = res;
	head = res;


	if (map.size() == 2) {
	    tail.pre = head;
	}

	return res.value;
    }

    public void put(int key, int value) {
	Node node = map.get(key);
	if (node != null) {
	    node.value = value;
	    if (node == head) {
		return;
	    } else {
		node.pre.next = node.next;
		if (node == tail) {
		    tail = tail.pre;
		    tail.next = null;
		} else {
		    node.next.pre = node.pre;
		}
		node.next = head;
		head.pre = node;
		head = node;
	    }
	    return;

	}

	if (capacity == map.size()) {
	    map.remove(tail.key);
	    if (map.size() == 0) {
		head = null;
		tail = null;
	    } else if (map.size() == 1) {
		tail = head;
		tail.pre = null;
		head.next = null;
	    }else {
		tail = tail.pre;
		tail.next = null;
	    }
	}

	Node newNode = new Node(key, value);
	map.put(key, newNode);

	if (map.size() == 1) {
	    head = newNode;
	    tail = newNode;
	} else {
	    newNode.next = head;
	    head.pre = newNode;
	    head = newNode;
	    if(map.size()==2) {
		tail = head.next;
		tail.next = null;
		tail.pre = head;
	    }

	}
    }

    private static class Node {
	private int key;
	private int value;
	private Node pre;
	private Node next;

	Node(int key, int value) {
	    this.value = value;
	    this.key = key;
	}

    }

    public static void main(String[] args) {
	LRUCache cache = new LRUCache(2);
	cache.get(2);
	cache.put(2, 6);
	cache.get(1);
	cache.put(1, 5);
	cache.put(1, 2);
	cache.get(1);
	cache.get(2);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
