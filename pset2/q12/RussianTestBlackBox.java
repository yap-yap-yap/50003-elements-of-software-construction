import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

public class RussianTestBlackBox {
    
    @Test
    public void runRussianTestBlackBoxValid1(){
        try{
            int x = Russian.multiply(2, 3);
            assertEquals(x, 2 * 3);
        }
        catch(Exception exception){
            fail("Exception caught");
        }
    }
    
    @Test
    public void runRussianTestBlackBoxValid2(){
        try{
            int x = Russian.multiply(0, 3);
            assertEquals(x, 0 * 3);
        }
        catch(Exception exception){
            fail("Exception caught");
        }
    }

    @Test
    public void runRussianTestBlackBoxValid3(){
        try{
            int x = Russian.multiply(2, 0);
            assertEquals(x, 2 * 0);
        }
        catch(Exception exception){
            fail("Exception caught");
        }
    }

    @Test
    public void runRussianTestBlackBoxValid4(){
        try{
            int x = Russian.multiply(0, 0);
            assertEquals(x, 0 * 0);
        }
        catch(Exception exception){
            fail("Exception caught");
        }
    }

    @Test
    public void runRussianTestBlackBoxValid5(){
        try{
            int x = Russian.multiply(-2, 0);
            assertEquals(x, -2 * 0);
        }
        catch(Exception exception){
            fail("Exception caught");
        }
    }

    @Test
    public void runRussianTestBlackBoxValid6(){
        try{
            int x = Russian.multiply(0, -3);
            assertEquals(x, 0 * -3);
        }
        catch(Exception exception){
            fail("Exception caught");
        }
    }

    @Test
    public void runRussianTestBlackBoxValid7(){
        try{
            int x = Russian.multiply(-2, 3);
            assertEquals(x, -2 * 3);
        }
        catch(Exception exception){
            fail("Exception caught");
        }
    }

    @Test
    public void runRussianTestBlackBoxInvalid1(){
        try{
            int x = Russian.multiply(2, -3);
            assertNotEquals(x, 2 * -3);
        }
        catch(Exception exception){
            fail("Exception caught");
        }
    }

    @Test
    public void runRussianTestBlackBoxInvalid2(){
        try{
            int x = Russian.multiply(-2, -3);
            assertNotEquals(x, -2 * -3);
        }
        catch(Exception exception){
            fail("Exception caught");
        }
    }
}

