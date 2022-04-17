package base.driver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    public static Alert waitAlert() {
        return new WebDriverWait(Driver.getDriver(), Duration.ofMillis(50))
                .until(ExpectedConditions.alertIsPresent());
    }

}
