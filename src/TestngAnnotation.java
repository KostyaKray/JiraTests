import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TestngAnnotation {
    // test case 1
    @Test
    public void testCase1() {
        System.out.println("Test case №1"); //5
    }
    // test case 2
    @Test
    public void testCase2() {
        System.out.println("Test case №2"); //8
    }
    //test case 3
    @Test
    public void testCase3() {
        System.out.println("test case № 3");
    }
        @BeforeMethod
    public void beforeMethod() {
        System.out.println("in beforeMethod"); //4 //7
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("in afterMethod"); //6 //9
    }
    @BeforeClass
    public void beforeClass() {
        System.out.println("in beforeClass"); //3
    }
    @AfterClass
    public void afterClass() {
        System.out.println("in afterClass"); //10
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("in beforeTest"); //2
    }
    @AfterTest
    public void afterTest() {
        System.out.println("in afterTest"); //11
    }
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("in beforeSuite"); //1
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("in afterSuite"); //12
    }

}
/*
beforeSuite() method is executed only once. first
afterSuite() method executes only once. last
beforeTest() 2, beforeClass() 3, afterClass() 10, and afterTest() 11 methods are executed only once.
beforeMethod() method executes for each test case but before executing the test case. 2 раза
afterMethod() method executes for each test case but after executing the test case. 2 раза
In between beforeMethod() and afterMethod(), each test case executes.*/