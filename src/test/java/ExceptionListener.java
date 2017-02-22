import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Created by madoshi on 2/20/17.
 */
public class ExceptionListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult tr){
        System.out.println(tr.getName() + "() test failed");
        System.out.println("Failed test exception : "+ tr.getThrowable());
        //Set the status to 1 to catch exception and pass the test
        tr.setStatus(1);
    }
}
