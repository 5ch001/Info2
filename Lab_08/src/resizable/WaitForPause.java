package resizable;

import static resizable.Debug.print;

/**
 * WaitForPause takes an inactivity threshold (in ms)
 * and triggers the callback "action" as soon as
 * "setInProgress()" hasn't been called for that long.
 */
public class WaitForPause implements Runnable {

    long pause = 0;
    Runnable action;
    int sleep = 100;

    long lastCall = 0;
    boolean inProgress = false;
    Thread thread;
    boolean shouldRun = true;

    /**
     * Constructor for WaitForPause
     *
     * @param pause  in ms
     * @param action Runnable that will be called after pause
     */
    public WaitForPause(int pause, Runnable action) {
        this.pause = pause * 1000000;
        this.action = action;
        thread = new Thread(this);
        thread.setName("WaitForPause Thread");
    }

    /**
     * Constructor for WaitForPause
     *
     * @param pause  in ms
     * @param action Runnable that will be called after pause
     * @param sleep  in ms - time the action trigger thread sleeps
     */
    public WaitForPause(int pause, Runnable action, int sleep) {
        this(pause, action);
        this.sleep = sleep;
    }

    /**
     * call this method every time the action
     * happens. Resets the lastCall time to
     * the current time.
     */
    public void setInProgress() {
        inProgress = true;
        lastCall = System.nanoTime();
        print("resizeInProgress: " + inProgress);
    }

    @Override
    public void run() {
        while (shouldRun) {
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                //throw new RuntimeException(e);
            }
            if (inProgress && (System.nanoTime() - lastCall > pause)) {
                inProgress = false;
                lastCall = 0;
                print("resizeInProgress: " + inProgress);
                action.run();
            }
        }
        print("WaitForPause Thread done.");
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        shouldRun = false;
    }

    public boolean inProgress() {
        return inProgress;
    }

}
