package q2;

import java.util.concurrent.atomic.AtomicInteger;

public class Experiment2 {
    private static AtomicInteger MY_INT = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        new ChangeListener().start();
        System.out.println("Waiting two seconds so the JIT will probably optimize ChangeListener");
        Thread.sleep(2000);

        new ChangeMaker().start();
    }

    static class ChangeListener extends Thread {
        public void run() {
            int local_value = MY_INT.intValue();
            while (local_value < 5) {
                synchronized (MY_INT){
                    if (local_value != MY_INT.intValue()) {
                        System.out.println("Got Change for MY_INT : " + MY_INT.intValue());
                        local_value = MY_INT.intValue();
                    }
                }

            }
        }
    }

    static class ChangeMaker extends Thread {
        public void run() {

            int local_value = MY_INT.intValue();
            while (MY_INT.intValue() < 5) {
                synchronized (MY_INT) {
                    System.out.println("Incrementing MY_INT to " + (local_value + 1));
                    MY_INT.set(++local_value);
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();

                }

            }
        }
    }
}