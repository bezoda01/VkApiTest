package forms;

import base.driver.BaseForm;
import base.elements.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class EntireForm extends BaseForm {

    private final TextField usernameField = new TextField(By.name("login"), "Username field");
    private final TextField passwordField = new TextField(By.name("password"), "Password field");

    public EntireForm() {
        super(new TextField(By.name("login"),"Entire page"), "Entire page");
    }

    public void enterAndLogin(String username, String password) {
        usernameField.sendText(username);
        usernameField.sendText(Keys.ENTER);
        passwordField.sendText(password);
        passwordField.sendText(Keys.ENTER);
    }
}
