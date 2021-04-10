//package q2;
import java.math.BigInteger;

public class FactorThreadNoInterruptMain {
    public static void main( String[] args ){
        //System.out.println("hello world");
        BigInteger number = new BigInteger("77");
        FactorThreadNoInterrupt.factor(number, 5);
        //System.out.println("smallest prime factor: " + result);
    }
    
}
