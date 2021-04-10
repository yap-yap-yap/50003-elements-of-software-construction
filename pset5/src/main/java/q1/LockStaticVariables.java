package q1;

import java.util.concurrent.atomic.AtomicInteger;

public class LockStaticVariables {
    public static AtomicInteger saving = new AtomicInteger(5000);
    public static AtomicInteger cash = new AtomicInteger(0);
    public static Object xxx=new Object();
    // LOCK lock.

    //declare a new object.
    public static void main(String args[]) {
        int numberofThreads = 10000;
        WD[] threads = new WD[numberofThreads];

        for (int i = 0; i < numberofThreads; i++) {
            threads[i] = new WD();
            threads[i].start();
        }

        try {
            for (int i = 0; i < numberofThreads; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            System.out.println("some thread is not finished");
        }

        System.out.print("The result is: " + LockStaticVariables.cash);
    }
}

class WD extends Thread {

    public void run() {

        synchronized(LockStaticVariables.saving){
            synchronized ((LockStaticVariables.cash)){
                if (LockStaticVariables.saving.intValue() >= 1000) {
                    try {
                        System.out.println("I am doing something.");
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    LockStaticVariables.saving.addAndGet(-1000);
                    LockStaticVariables.cash.addAndGet(1000);

                }
            }
        }


    }
}

