package formType;

import listeners.MyListener;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.Common;

@Test
@Listeners(MyListener.class)
public class ButtonTest extends Common {

    @Test(priority = 1)
    public void radio() throws InterruptedException {
        homePage.male();
        homePage.feMale();
        Thread.sleep(2000);
    }

    @Test(priority = 2)
    public void checkBox() throws InterruptedException {
        homePage.sunday();
        homePage.monday();
        Thread.sleep(2000);
    }

    @Test(priority = 3, dataProvider="dataSupplier")
    public void dropdown(String data) throws InterruptedException {
        homePage.dropDown(data);
        Thread.sleep(2000);
    }

    @DataProvider
    public Object[][] dataSupplier(){
        return new Object[][]{{"//*[@id=\"country\"]/option[5]"}, {"//*[@id=\"country\"]/option[8]"},{"//*[@id=\"country\"]/option[6]"}};
    }
    
    @Test(priority = 4)
    public void select() {
    	homePage.select();
    }

}
