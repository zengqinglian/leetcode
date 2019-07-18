package printFooBarAlternately;

//16ms solution, beat 80%
public class FooBar {
    private int n;

    private volatile boolean callFoo = true;

    public FooBar(int n) {
	this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {

	for (int i = 0; i < n; i++) {
	    if (callFoo) {
		// printFoo.run() outputs "foo". Do not change or remove this line.
		printFoo.run();
		callFoo = false;
		synchronized (this) {
		    notifyAll();
		}
	    } else {
		synchronized (this) {
		    wait();
		}
		i--;
	    }
	}
	synchronized (this) {
	    notifyAll();
	}
    }

    public void bar(Runnable printBar) throws InterruptedException {

	for (int i = 0; i < n; i++) {
	    if (!callFoo) {
		// printBar.run() outputs "bar". Do not change or remove this line.
		printBar.run();
		callFoo = true;
		synchronized (this) {
		    notifyAll();
		}

	    } else {
		synchronized (this) {
		    wait();
		}
		i--;
	    }
	}
	synchronized (this) {
	    notifyAll();
	}
    }
}
