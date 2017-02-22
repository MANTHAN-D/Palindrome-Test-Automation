import org.testng.Assert;
import org.testng.annotations.*;


/**
 * Created by madoshi on 2/20/17.
 */
public class PalindromeTest {

    private Palindrome palin;

    @BeforeSuite
    public void startingTestSuite(){
        System.out.println("Starting test suite");
    }

    @BeforeTest
    public void beforeStartingTest(){
        System.out.println("Starting the test");
    }

    @BeforeClass
    public void setUp(){
        System.out.println("Setting up test suit");
        palin = new Palindrome();
    }

    @BeforeMethod
    public void beforeEachTestMethod(){
        System.out.println("Beginning execution of the test method");
    }

    @Test
    public void testTestMe() {
        Assert.assertTrue(palin.testMe("Test value").equals("I return Test value"));
        Assert.assertFalse(!palin.testMe("Test value").equals("I return Test value"));
    }

    @AfterMethod
    public void afterEachTestMethod(){
        System.out.println("Completed execution of the test method");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("Destroying test suit setup");
        palin = null;
    }

    @AfterTest
    public void afterCompletingTest(){
        System.out.println("Completing the test");
    }

    @AfterSuite
    public void endingTestSuite(){
        System.out.println("Ending test suite");
    }
}
