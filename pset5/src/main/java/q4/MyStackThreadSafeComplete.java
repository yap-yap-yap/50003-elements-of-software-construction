package q4;

import java.util.concurrent.locks.ReentrantLock;

class WorkerFixed extends Thread {
    MyStackThreadSafeComplete stack;
    public WorkerFixed(MyStackThreadSafeComplete stack) {
        this.stack = stack;
    }
    public void run() {
        for (int i = 0; i < 1000; i++)
            stack.pop();
    }
}
public class MyStackThreadSafeComplete extends MyStack {
    ReentrantLock stack_lock = new ReentrantLock(); // implemented with a single lock for both stackArray and top instead of synchronised methods to prevent race condition if push and pop are called concurrently.
    //pre-condition: s > 0
    //post-condition: maxSize == s && top == -1 && stackArray != null
    public MyStackThreadSafeComplete(int s) {
        super(s); //Do we need "synchronized" for the constructor? // no because the constructor is called in a single thread when initialising the stack class.
    }

    //pre-condition: top >= 0
    //post-condition: the top element is removed
    public synchronized long pop() {
        long toReturn;
        synchronized (stack_lock){
            while (isEmpty()) {
                try {
                    //System.out.println("i am waiting...");
                    stack_lock.wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

            //System.out.println("current top = " + top);
            toReturn = stackArray[top];
            top--;
            stack_lock.notifyAll();

            assert top >=-1;
            return toReturn;
        }

    }

    public synchronized void push(long j){
        synchronized (stack_lock) {
            while (isFull()) {
                try {
                    stack_lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //System.out.println(top);
            top++;
            stackArray[top] = j;
            stack_lock.notifyAll();

            assert top < maxSize;
            return;
        }

    }

    public synchronized long peek(){
        long toReturn;
        synchronized (stack_lock){
            while (isFull() || isEmpty()){
                try{
                    stack_lock.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

            toReturn = stackArray[top];
            stack_lock.notifyAll();

            return toReturn;
        }

    }

    public synchronized boolean isEmpty(){
        synchronized (stack_lock){
            return top == -1;
        }
    }

    public synchronized boolean isFull(){
        synchronized (stack_lock){
            return top == maxSize;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WorkerFixed[] workers = new WorkerFixed[10];
        MyStackThreadSafeComplete stack = new MyStackThreadSafeComplete(10000);
        for (int i = 0; i < 10000; i++)
            stack.push(i);

        System.out.println(stack.top);
        int activeCount = Thread.activeCount();

        for (int i = 0; i < 10; i++) {
            workers[i] = new WorkerFixed(stack);
        }
        for (WorkerFixed worker : workers) {
            worker.start();
        }

        while (Thread.activeCount() > activeCount) {
            Thread.yield();
        }

        System.out.println(stack.top);

    }

}