package ru.gb.mandrik;

public class TestClass {


    @Test(priority = 5)
    public static void test() {
        System.out.println("Priority 5");
    }

    @Test
    public static void test2() {
        System.out.println("Priority 1");
    }

    @Test(priority = 10)
    public static void test3() {
        System.out.println("Priority 10");
    }

    @Test(priority = 6)
    public static void test4() {
        System.out.println("Priority 6");
    }

    @Test(priority = 7)
    public static void test5() {
        System.out.println("Priority 7");
    }

    @Test(priority = 2)
    public static void test6() {
        System.out.println("Priority 2");
    }

    @BeforeSuite
    public static void before() {
        System.out.println("Before suite");
    }

    @AfterSuite
    public static void after() {
        System.out.println("After suite");
    }
}
