import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ComparisonSortTest {
    @Test
    public void createRandomTest(){
        assertEquals(new int[100], ComparisonSort.createRandom(100));

    }
}
