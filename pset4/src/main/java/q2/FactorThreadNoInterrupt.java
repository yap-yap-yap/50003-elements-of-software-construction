//package Week9;
//package q2;
import java.math.BigInteger;


import java.lang.Runnable;

public class FactorThreadNoInterrupt {
    //Precondition: n is a semi-prime number.
    //Postcondition: the returned value is a prime factor of n;
    public static void factor(BigInteger n, int threadcount) {
        /*BigInteger i = new BigInteger("2");//begin the guess from "2"
        BigInteger zero = new BigInteger("0");
        while (i.compareTo(n) < 0) {
            if (n.remainder(i).compareTo(zero) == 0) {
                return i;
            }
            i = i.add(new BigInteger("1"));
        }*/

        //BigInteger midpoint = n.divide(BigInteger.TWO); //because anything above the midpoint can't be a prime factor
        
        //BigInteger thread_midpoint = midpoint.divide(BigInteger.TWO); 
        
        //Remainder factor1 = new Remainder("thread1", n, new BigInteger("2"), thread_midpoint);
        //Remainder factor2 = new Remainder("thread2", n, thread_midpoint.add(new BigInteger("1")), midpoint);

        Remainder[] threadarray = new Remainder[threadcount];
        for (int i = 0; i < threadcount; i++){
            String threadname = String.format("thread %d",i+1);
            threadarray[i] = new Remainder(threadname, n, 2+i, threadcount);
            threadarray[i].start();
        }

        //factor1.start();
        //factor2.start();
        
    }
}

class Remainder implements Runnable{
    BigInteger n;
    BigInteger pointer;
    BigInteger step;
    BigInteger zero = new BigInteger("0");
    BigInteger factor= new BigInteger("0");
    String name;
    
    public Remainder(String name, BigInteger n, int pointer, int step){
        this.n = n;
        this.pointer = BigInteger.valueOf(pointer);
        this.step = BigInteger.valueOf(step);
        this.name = name;
        //System.out.println(pointer);
        //System.out.println(end);
    }

    public void run(){
        while (pointer.compareTo(n) < 0) {
            //BigInteger remainder = n.remainder(pointer);
            //System.out.println("pointer is : " + pointer);
            //System.out.println("remainder is : " + remainder);
            if (n.remainder(pointer).compareTo(zero) == 0) {
                factor = pointer;
                System.out.println("factor is : " + factor);
                
            }
            pointer = pointer.add(step);
        }
    }

    public void start(){
        Thread thread = new Thread(this, name);
        System.out.println("starting thread named: " + name);

        thread.start();
    }
}
