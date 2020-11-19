import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestArrayAfterFour {
    ArraySearch array;
    @Before
    public void init() {
        System.out.println("init");
        array = new ArraySearch();
    }

    @Test
    public void testArray() {
        Assert.assertArrayEquals(new int [] {5, 6, 7}, array.arrayAfterFour(new int[] {1, 2, 3, 4, 5, 4, 5, 6, 7}));
    }
    @Test
    public void testArray2() {
        Assert.assertArrayEquals(new int [] {5, 6, 7}, array.arrayAfterFour(new int[] { 4, 5, 6, 7}));
    }
    @Test(expected = RuntimeException.class)
    public void testArray3() {
        Assert.assertArrayEquals(new int [] {}, array.arrayAfterFour(new int[] {1, 2, 3, 5, 5, 6, 7}));
    }
    @Test
    public void testArray4() {
        Assert.assertArrayEquals(new int [] {1}, array.arrayAfterFour(new int[] {1, 2, 3, 5, 4, 5, 6, 7}));
    }

    @After
    public void shutdown() {
        System.out.println("finish");
    }
}
