//package Week9;
//package q2;
import java.math.BigInteger;

public class FactorThread {
    //Precondition: n is a semi-prime number.
    //Postcondition: the returned value is a prime factor of n;
    public static boolean continue_thread = true;
    public static int thread_end = 0;

    public static void factor(BigInteger n, int threadcount) {
        /*BigInteger i = new BigInteger("2");//begin the guess from "2"
        BigInteger zero = new BigInteger("0");
        while (i.compareTo(n) < 0) {
            if (n.remainder(i).compareTo(zero) == 0) {
                return i;
            }
            i = i.add(new BigInteger("1"));
        }*/

       // BigInteger midpoint = n.divide(BigInteger.TWO);
        //BigInteger thread_midpoint = midpoint.divide(BigInteger.TWO); //because anything above the midpoint can't be a prime factor

        //RemainderThread factor1 = new RemainderThread("thread1", n, new BigInteger("2"), thread_midpoint);
        //RemainderThread factor2 = new RemainderThread("thread2", n, thread_midpoint.add(new BigInteger("1")), midpoint);
        
        RemainderThread[] threadarray = new RemainderThread[threadcount];
        for (int i = 0; i < threadcount; i++){
            String threadname = String.format("thread %d",i+1);
            threadarray[i] = new RemainderThread(threadname, n, 2+i, threadcount);
            threadarray[i].start();
        }
        while(continue_thread && thread_end < threadcount){
            
        }

        for (int i = 0; i < threadcount; i++){
            threadarray[i].interrupt();
        }


        //factor1.start();
        //factor2.start();
        /*while(true){
            if(factor1.factor != null || factor2.factor != null){
                factor1.interrupt();
                factor2.interrupt();
                break;
            }
            if(factor1.isAlive() == false && factor2.isAlive() == false){
                System.out.println("No prime factors found");
                break;
            }
        
        }*/
    }
}

class RemainderThread extends Thread {
    BigInteger n;
    BigInteger pointer;
    BigInteger step;
    BigInteger zero = new BigInteger("0");
    BigInteger factor = null;
    String threadname;
    
    public RemainderThread(String threadname, BigInteger n, int pointer, int step){
        this.n = n;
        this.pointer = BigInteger.valueOf(pointer);
        this.step = BigInteger.valueOf(step);
        this.threadname = threadname;
        this.factor = null;
        //System.out.println(pointer);
        //System.out.println(end);
    }

    public void run(){
        while (pointer.compareTo(n) < 0) {
            //BigInteger remainder = n.remainder(pointer);
            //System.out.println("pointer is : " + pointer);
            //System.out.println("remainder is : " + remainder);
            if(this.isInterrupted()){
                try{
                    System.out.println(threadname + " interrupted...");
                    break;
                }
                catch(Exception e){
                    e.printStackTrace();
                    break;
                } 
            }        
            if (n.remainder(pointer).compareTo(zero) == 0) {
                factor = pointer;
                System.out.println("factor is : " + factor);
                FactorThread.continue_thread = false;
                }
            pointer = pointer.add(step);
        }
        FactorThread.thread_end ++;

        
    }

    public void start(){
        Thread thread = new Thread(this, threadname);
        System.out.println("starting thread named: " + threadname);
        thread.start();
    }
}
