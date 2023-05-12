import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ArraysMethodsTest {

    private ArraysMethods arraysMethods;

    @BeforeAll
    public void prepare() {
        arraysMethods = new ArraysMethods();
    }

    @Test
    public void testPullElementsAfterLastFour() {
        int[] arr2 = {1, 2, 3};
        int[] result2 = arraysMethods.pullElementsAfterLastFour(arr2);
        assertEquals(0, result2.length);

        int[] arr3 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] result3 = arraysMethods.pullElementsAfterLastFour(arr3);
        assertArrayEquals(new int[]{1, 7}, result3);

        int[] arr4 = {1, 2, 4, 4, 2, 3, 4, 4, 1, 7, 4, 2};
        int[] result4 = arraysMethods.pullElementsAfterLastFour(arr4);
        assertArrayEquals(new int[]{1, 7, 4, 2}, result4);
    }

    @Test
    public void testCheckOneAndFour() {

        int[] arr1 = new int[0];
        assertFalse(arraysMethods.checkOneAndFour(arr1));

        int[] arr2 = {2, 3, 5, 6};
        assertFalse(arraysMethods.checkOneAndFour(arr2));

        int[] arr3 = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        assertTrue(arraysMethods.checkOneAndFour(arr3));

        int[] arr4 = {1, 1, 1, 1, 1, 1};
        assertFalse(arraysMethods.checkOneAndFour(arr4));

        int[] arr5 = {4, 4, 4, 4, 4, 4};
        assertFalse(arraysMethods.checkOneAndFour(arr5));
    }
}
