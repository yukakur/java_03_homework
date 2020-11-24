public class ForTesting {

    @BeforeSuite
    public static void test1Primary() {
        System.out.println("метод beforeSuite");
    }

    @Test(priority = 5)
    public static void test2() {
        System.out.println("приоритет 5");
    }
    @Test(priority = 2)
    public static void test3() {
        System.out.println("приоритет 2");
    }
    @Test(priority = 4)
    public static void test4() {
        System.out.println("приоритет 4");
    }
    @Test
    public static void test5() {
        System.out.println("приоритет дефолтный");
    }

    @AfterSuite
    public static void test6Last() {
        System.out.println("метод afterSuite");
    }
}
