package base.driver;

import org.openqa.selenium.WebDriver;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = DriverBrowserFactory.setBrowser();
            Loggerr.getLogger().info(driver.toString() + "CREATED");
        }
        return driver;
    }

    public static void setDriverToNull() {
        driver = null;
    }
}
