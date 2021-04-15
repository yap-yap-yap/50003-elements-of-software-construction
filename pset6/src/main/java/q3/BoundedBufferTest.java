package q3;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * Question for Cohort Exercise 3.
 */

public class BoundedBufferTest {
    private static final long LOCKUP_DETECT_TIMEOUT = 1000;

    @Test
    public void testIsEmptyWhenConstructed() {
        BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(10);
        assertTrue(bb.isEmpty());
        assertFalse(bb.isFull());
    }

    @Test
    public void testIsFullAfterPuts() throws InterruptedException {
        final BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(10);

        Runnable task = new Runnable() {
            public void run() {
                try {
                    bb.put((new Random()).nextInt());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < 10; i++) {
            threads[i].join();
        }

        assertTrue(bb.isFull());
        assertFalse(bb.isEmpty());
    }

    /**
     * TODO: implement this test
     * Initialize a buffer with #items inside.
     * Initialize multiple threads that concurrently removes item from the buffer.
     * Make sure the total remove() = #items in buffer.
     * What should be the postcondition?
     */
    @Test
    public void testIsEmptyAfterTakesAll() throws InterruptedException {
        final int capacity = 10;
        final BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(capacity);

        for(int i = 0; i < capacity; i++){
            bb.put((new Random()).nextInt());
        }
        assertTrue(bb.isFull());

        Runnable task = new Runnable() {
            public void run() {
                try {
                    bb.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread[] threads = new Thread[capacity];

        for (int i = 0; i < capacity; i++) {
            threads[i] = new Thread(task);
            threads[i].start();
        }

        for (int i = 0; i < capacity; i++) {
            threads[i].join();
        }

        //postcondition: buffer is empty
        assertTrue(bb.isEmpty());
        assertFalse(bb.isFull());

    }

    /**
     * TODO: implement this test
     * Initialize a buffer with 0 item inside.
     * Initialize a threads removes item from the buffer.
     * What should be the postcondition?
     */
    @Test
    public void testTakeBlocksWhenEmpty() throws InterruptedException {
        final int capacity = 10;
        final BoundedBuffer<Integer> bb = new BoundedBuffer<Integer>(capacity);

        Runnable task = new Runnable() {
            public void run() {
                try {
                    bb.take();
                } catch (InterruptedException e) {
                    assertEquals(InterruptedException.class, e.getClass());
                    //e.printStackTrace();
                }
            }
        };

        Thread thread = new Thread(task);
        thread.start();


        Thread.sleep(LOCKUP_DETECT_TIMEOUT);
        try{
            thread.interrupt();
            thread.join();

        }
        catch(Exception e){
            e.printStackTrace();
        }





    }
}
