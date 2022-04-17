package base.driver;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;

public class AlertsUtils {
    private static Alert alert;

    public static void switchToAlert() {
        alert = WaitUtils.waitAlert();
    }

    public static String getWords() {
        switchToAlert();
        Loggerr.getLogger().info("Берём текст Alert.");
        return alert.getText();
    }

    public static void acceptAlert() {
        switchToAlert();
        Loggerr.getLogger().info("Alert принимается.");
        alert.accept();
    }

    public static void dismissAlert() {
        Loggerr.getLogger().info("Alert отменяется.");
        alert.dismiss();
    }

    public static void sendAlert(String text) {
        switchToAlert();
        Loggerr.getLogger().info("Вводится текст в Alert");
        alert.sendKeys(text);
    }

    public static Boolean alertIsClose() {
        boolean close = false;
        try {
            switchToAlert();
        }catch (TimeoutException e) {
            close = true;
        }
        return close;
    }
}
