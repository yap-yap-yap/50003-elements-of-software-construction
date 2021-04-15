package q1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Question of Cohort Exercise 1
 */

//hint 2: we must ensure this class to be thread-safe. why? and how?
public class MyCyclicBarrierAnswer {
    private final int parties;
    private int count = 0;
    private Runnable torun;//hint 3: when should we call this runable task?
    public ReentrantLock lock = new ReentrantLock();

    public MyCyclicBarrierAnswer(int count, Runnable torun) {
        this.count = count;
        this.torun = torun;
        parties = count;
    }

    public MyCyclicBarrierAnswer(int count) {
        this.count = count;
        parties = count;
    }

    //TODO: complete the implementation below.
    //hint 1: use wait(), notifyAll()
    //precondition:
    //postcondition:
    public void await() throws InterruptedException {
        synchronized (lock){
            count--;
            //System.out.println(count);
            if(count > 0){
                lock.wait();
            }
            if(count == 0){
                torun.run();
                count = parties;
            }
            lock.notifyAll();


        }
    }
}
