import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestArrayContains {

    ArraySearch array;

    @Before
    public void init() {
        array = new ArraySearch();
    }

    @Test
    public void TestArray1() {
        Assert.assertTrue(array.findInArray(new int []{1, 2, 3, 3}) );
    }

    @Test
    public void TestArray2() {
        Assert.assertFalse(array.findInArray(new int []{ 2, 3, 3}) );
    }

    @Test
    public void TestArray3() {
        Assert.assertTrue(array.findInArray(new int []{ 4, 3, 3, 2}) );
    }

    @Test
    public void TestArray4() {
        Assert.assertFalse(array.findInArray(new int []{ 9, 3, 3, 5}) );
    }




}
