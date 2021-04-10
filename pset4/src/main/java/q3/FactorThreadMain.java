//package q3;
import java.math.BigInteger;

public class FactorThreadMain {
    public static void main( String[] args ){
        //System.out.println("hello world");
        BigInteger number = new BigInteger("77");
        FactorThread.factor(number, 3);
        //System.out.println("smallest prime factor: " + result);
    }
    
}
