package formType;

import listeners.MyListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.Common;

@Test
@Listeners(MyListener.class)
public class InputTest extends Common {

//    public InputTest() {
//        super();
//    }

    @Test(priority = 1)
    public void inputName() throws InterruptedException {
        homePage.input(prop.getProperty("inputName"), prop.getProperty("inputEmail"), prop.getProperty("inputPhone"));
        Thread.sleep(2000);
    }

}
