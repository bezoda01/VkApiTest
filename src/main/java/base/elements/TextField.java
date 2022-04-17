package base.elements;

import base.driver.Loggerr;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class TextField extends BaseElement {
    public TextField(By locator, String name) {
        super(locator, name);
    }

    public void sendText(String text) {
        Loggerr.getLogger().info("Отправляем текст - " + text);
        findElement().sendKeys(text);
    }

    public void sendText(Keys keys) {
        Loggerr.getLogger().info("Отправляем - " + keys.toString());
        findElement().sendKeys(keys);
    }
}
