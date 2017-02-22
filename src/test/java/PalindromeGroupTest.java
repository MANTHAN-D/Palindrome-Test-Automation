import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by madoshi on 2/20/17.
 */
public class PalindromeGroupTest {
    private Palindrome palin;

    @DataProvider(name="nullInput")
    public Object[][] getNullString(){
        return new Object[][]{{null,false}};
    }

    @DataProvider(name="numberedInput")
    public Object[][] getNumberedString(){
        return new Object[][]{{"2345432",true},{"12345432",false},{"2345432",true},{"234543279",false}};
    }

    @DataProvider(name="alphaInput")
    public Object[][] getAplhaString(){
        return new Object[][]{{"aabccd",false},{"fabccbaf",true},{"huiiujk",false},{"werrew",true}};
    }

    @DataProvider(name="specialSymbolsInput")
    public Object[][] getSpecialSymbolsString(){
        return new Object[][]{{"#aabccd",false},{"fabc*cbaf",false},{"hui%iujk",false},{"^werrew^",false}};
    }

    @DataProvider(name="mixedInput")
    public Object[][] getMixedString(){
        return new Object[][]{{"@aab123",false},{"4a2cc2a4",true},{"25hui&iujk52",false},{"wer454rew",true}};
    }

    @DataProvider(name="invalidInput")
    public Object[][] getInvalidString(){
        return new Object[][]{{"320aab123",false},{"4a2cp2a4",false},{"25huiiujk52",false},{"wer4564rew",false}};
    }

    @DataProvider(name="alphanumInput")
    public Object[][] getAlphanumString(){
        return new Object[][]{{"aab123",false},{"4a2cc2a4",true},{"25huiiujk52",false},{"wer454rew",true}};
    }

    @DataProvider(name="validInput")
    public Object[][] getValidString(){
        return new Object[][]{{"321abba123",true},{"4a2cc2a4",true},{"25kjuiiujk52",true},{"wer454rew",true}};
    }

    @BeforeGroups(groups = {"positive","negative"})
    public void beforeTestGroup(){
        System.out.println("Starting set of tests for positive and negative group");
        palin = new Palindrome();
    }

    @Test(groups = {"negative", "boundary"}, dataProvider = "nullInput", enabled= true)//, expectedExceptions = NullPointerException.class)
    public void testNull(String input, boolean expectedResult){
        Assert.assertNull(input);
        Assert.assertFalse(palin.isPalindrome(input));
        Assert.assertEquals(palin.isPalindrome(input),false);
    }

    @Test (groups = {"negative", "boundary"})
    @Parameters("emptyString")
    public void testEmpty(String emptyString){
        Assert.assertEquals(palin.isPalindrome(emptyString), true);
    }

    @Test (groups = {"negative"})
    @Parameters("spacedString")
    public void testSpace(String spacedString){
        Assert.assertTrue(palin.isPalindrome(spacedString));
    }

    @Test (groups = {"negative"})
    @Parameters("punctuationString")
    public void testPunctuation(String punctuationString){
        Assert.assertNotSame(palin.isPalindrome(punctuationString),true);
    }

    @Test (groups = {"positive"}, dataProvider = "numberedInput")
    public void testNumbers(String input, boolean expectedResult){
        Assert.assertSame(palin.isPalindrome(input),expectedResult);
    }

    @Test (groups = {"positive"}, dataProvider = "alphaInput")
    public void testAlphabets(String input, boolean expectedResult){
        Assert.assertEquals(palin.isPalindrome(input),expectedResult);
    }

    @Test (groups = {"negative"}, dataProvider = "specialSymbolsInput")
    public void testWithSpecialSymbols(String input, boolean expectedResult){
        Assert.assertTrue(palin.isPalindrome(input) == expectedResult);
    }

    @Test (groups = {"negative", "positive"}, dataProvider = "mixedInput")
    public void testMixedString(String input, boolean expectedResult){
        Assert.assertNotSame(palin.isPalindrome(input),!expectedResult);
    }

    @Test (groups = {"negative"}, dataProvider = "invalidInput")
    public void testInvalidPalin(String input, boolean expectedResult){
        Assert.assertFalse(palin.isPalindrome(input) != expectedResult);
    }

    @Test (groups = {"positive"}, dataProvider = "alphanumInput")
    public void testAlphanumericPalin(String input, boolean expectedResult){
        Assert.assertNotEquals(palin.isPalindrome(input),!expectedResult);
    }

    @Test (groups = {"positive"}, dataProvider = "validInput")
    public void testValidPalin(String input, boolean expectedResult){
        Assert.assertSame(palin.isPalindrome(input),expectedResult);
    }

    @AfterGroups(groups = {"boundary"})
    public void afterTestGroup(){
        System.out.println("Completed set of tests for boundary group");
    }

}
