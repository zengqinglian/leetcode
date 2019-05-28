package designCircularQueue;

//46ms solution , beat 80%
public class MyCircularQueue {
    /** Initialize your data structure here. Set the size of the queue to be k. */
    private int capacity;
    private int start;
    private int end;
    private int[] q;
    private int total = 0;

    public MyCircularQueue(int k) {
	q = new int[k];
	this.capacity = k;
	this.start = -1;
	this.end = -1;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is
     * successful.
     */
    public boolean enQueue(int value) {
	if (isFull()) {
	    return false;
	}
	if (end == capacity - 1) {
	    end = 0;
	} else {
	    end++;
	}
	q[end] = value;
	total++;
	if (total == 1) {
	    start = end;
	}

	return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is
     * successful.
     */
    public boolean deQueue() {
	if (isEmpty()) {
	    return false;
	}

	if (start == capacity - 1) {
	    start = 0;
	} else {
	    start++;
	}
	total--;
	if (total == 0) {
	    this.start = -1;
	    this.end = -1;
	}
	return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
	if (this.isEmpty()) {
	    return -1;
	}
	return q[start];
    }

    /** Get the last item from the queue. */
    public int Rear() {
	if (this.isEmpty()) {
	    return -1;
	}
	return q[end];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
	if (total == 0) {
	    return true;
	}
	return false;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
	if (total == capacity) {
	    return true;
	}

	return false;
    }

    public static void main(String[] args) {
	MyCircularQueue cq = new MyCircularQueue(3);
	cq.enQueue(2);
	cq.Rear();
	cq.Front();
	cq.deQueue();
	cq.Front();
	cq.deQueue();
	cq.Front();

    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k); boolean param_1 =
 * obj.enQueue(value); boolean param_2 = obj.deQueue(); int param_3 =
 * obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
