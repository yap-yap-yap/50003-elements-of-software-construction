import static org.junit.Assert.*;

import org.junit.Test;

public class FindMaxTest {
    @Test
    public void testMaxFail(){
        int x = FindMax.max(new int[]{0,1,2});
        assertFalse(x == 2);
    }

    @Test
    public void testMaxError(){
        int x = FindMax.max(new int[]{});
        assertTrue(x == 0);
    }

    @Test
    public void testMaxPass(){
        int x = FindMax.max(new int[]{5,6,17,8,2});
        assertTrue(x == 17);
    }
}
