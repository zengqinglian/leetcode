package buildingH2o;

//14ms solution , beat 97%
public class H2O {
    private volatile int hcnt = 0;

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
	if (hcnt == 0) {
	    releaseHydrogen.run();
	    hcnt++;
	} else if (hcnt == 1) {
	    releaseHydrogen.run();
	    hcnt++;
	    synchronized (this) {
		notifyAll();
	    }
	} else {
	    synchronized (this) {
		wait();
	    }
	    hydrogen(releaseHydrogen);
	}
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
	if (hcnt == 2) {
	    releaseOxygen.run();
	    hcnt = 0;
	    synchronized (this) {
		notifyAll();
	    }
	} else {
	    if (hcnt != 2) {
		synchronized (this) {
		    wait();
		}
	    }
	    oxygen(releaseOxygen);
	}
    }
}
