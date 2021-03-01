import static org.junit.Assert.*;

import org.junit.Test;

public class FindMaxTest {
    @Test
    public void testMaxFail(){
        int x = FindMax.max(new int[]{0,1,2});
        assertFalse(x == 2);
    }

    //2 different ways for this one. either just try/catch but the try part will fail if the exception isn't thrown, or just denote the expected thrown exception
    @Test //(expected = ArrayIndexOutOfBoundsException.class)
    public void testMaxError(){
        try{
            int x = FindMax.max(new int[]{});
            assertTrue(x == 0);
            fail("ArrayIndexOutOfBoundsException was not thrown");
        }
        catch(Exception ArrayIndexOutOfBoundsException){
        }

        /*int x = FindMax.max(new int[]{});
        assertTrue(x == 0);*/
    }

    @Test
    public void testMaxPass(){
        int x = FindMax.max(new int[]{5,6,17,8,2});
        assertTrue(x == 17);
    }
}
