import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

public class RussianTestWhiteBox {
    @Test
    public void runRussianTestWhiteBox(){
        int x = Russian.multiply(3, 6);
        assertEquals(x, 3 * 6);
    }
}