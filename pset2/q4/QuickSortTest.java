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
public class QuickSortTest {
    
    int[] array;
    int[] expected_array;

    public QuickSortTest(int[] array, int[] expected_array){
        this.array = array;
        this.expected_array = expected_array;
    }

    @Parameters
    public static Collection<Object[]> arrays(){
        return Arrays.asList(new Object[][]{
            {new int[]{5, 4, 3}, new int[]{3, 4, 5}},
            {new int[]{30, 55, 32}, new int[]{30, 32, 55}},
            {new int[]{2, 4, 3, 12, 7}, new int[]{2, 3, 4, 7, 12}},
        });
        
    } 

    @Test
    public void runTest(){
        QuickSort quickSort = new QuickSort();
        quickSort.sort(array);
        assertArrayEquals(array, expected_array); //doesn't this just take the array from the test object? the sorted array is in the QuickSort object, and it can't be accessed. idk seems to work tho
        
    }

    
}
