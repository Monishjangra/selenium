package formType;

import org.testng.annotations.Test;
import tests.Common;

@Test
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
