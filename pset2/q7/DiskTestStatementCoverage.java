import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;

@RunWith(Parameterized.class)
public class DiskTestStatementCoverage {
    private int x;
    private int y;
    
    public DiskTestStatementCoverage(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Parameters
    public static Collection<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
            {2, 0},
            {1010, -20}
        });
    }

    @Test
    public void runDiskTest(){
        Disk disk = new Disk(x, y);
        try{
            disk.manipulate();
        }
        catch(Exception exception){
            fail("Exception caught");
        }
    }

}
