import api.Constants;
import base.driver.DriverUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    @BeforeMethod
    protected void beforeMethod(){
        DriverUtils.windowSize("max");
        DriverUtils.getUrl(Constants.environment.getConfig().getBrowser().getUrl());
    }

    @AfterMethod
    public void afterTest(){
            DriverUtils.tearDown();
    }
}
