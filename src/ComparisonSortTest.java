import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ComparisonSortTest {

    @Test
    public void constructorTest(){
        assertNotNull(new ComparisonSort());
    }

    @Test
    public void mainTest(){
        InputStream originalIn = System.in;
        try{
            System.setIn(new ByteArrayInputStream("10\n".getBytes()));
            assertDoesNotThrow(() -> ComparisonSort.main());

            System.setIn(new ByteArrayInputStream("-1\n".getBytes()));
            assertDoesNotThrow(() -> ComparisonSort.main());
        } finally {
            System.setIn(originalIn);
        }
    }

    @Test
    public void createRandomTest(){
        int[] res1 = ComparisonSort.createRandom(100);
        assertNotNull(res1);
        assertEquals(100, res1.length);

        int[] res2 = ComparisonSort.createRandom(-1);
        assertNull(res2);
    }

    @Test
    public void insertionSortTest(){
        int[] list1 = {8,3,7,5,0,1};
        int comparisons1 = ComparisonSort.insertionSort(list1);
        assertArrayEquals(new int[] {0,1,3,5,7,8}, list1);
        assertEquals(15, comparisons1);

        int[] list2 = {};
        int comparisons2 = ComparisonSort.insertionSort(list2);
        assertArrayEquals(new int[] {}, list2);
        assertEquals(0, comparisons2);

        int[] list3 = {6, 7, 6, 7, 6, 7};
        int comparisons3 = ComparisonSort.insertionSort(list3);
        assertArrayEquals(new int[] {6,6,6,7,7,7}, list3);
        assertEquals(8, comparisons3);

        int[] list4 = {1,2,3,4,5};
        int comparisons4 = ComparisonSort.insertionSort(list4);
        assertArrayEquals(new int[] {1,2,3,4,5}, list4);
        assertEquals(4, comparisons4);
    }

    @Test
    public void mergeSortTest(){
        int[] list1 = {8,3,7,5,0,1};
        int comparisons1 = ComparisonSort.mergeSort(list1);
        assertArrayEquals(new int[] {0,1,3,5,7,8}, list1);
        assertEquals(10, comparisons1);

        int[] list2 = {};
        int comparisons2 = ComparisonSort.mergeSort(list2);
        assertArrayEquals(new int[] {}, list2);
        assertEquals(0, comparisons2);

        int[] list3 = {6, 7, 6, 7, 6, 7};
        int comparisons3 = ComparisonSort.mergeSort(list3);
        assertArrayEquals(new int[] {6,6,6,7,7,7}, list3);
        assertEquals(9, comparisons3);
    }


}
