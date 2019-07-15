package printZeroEvenOdd;

import java.util.function.IntConsumer;

//4ms solution , beat 100%
public class ZeroEvenOdd {
    private int n;
    private volatile int cur = 1;

    public ZeroEvenOdd(int n) {
	this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
	while (cur <= 2 * n - 1) {
	    if (cur % 2 == 1) {
		printNumber.accept(0);
		cur++;
		synchronized (this) {
		    notifyAll();
		}
	    } else {
		synchronized (this) {
		    wait();
		}
	    }
	}
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
	while (cur <= 2 * n) {
	    int val = cur / 2;
	    if (cur % 2 == 0 && val % 2 == 0) {
		printNumber.accept((cur / 2));
		cur++;
		synchronized (this) {
		    notifyAll();
		}
	    } else {
		synchronized (this) {
		    wait();
		}
	    }
	}

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
	while (cur <= 2 * n) {
	    int val = cur / 2;
	    if (cur % 2 == 0 && val % 2 == 1) {
		printNumber.accept((cur / 2));
		cur++;
		synchronized (this) {
		    notifyAll();
		}
	    } else {
		synchronized (this) {
		    wait();
		}
	    }
	}

    }
}
