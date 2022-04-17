package forms;

import base.driver.BaseForm;
import base.elements.Button;
import base.elements.TextField;
import org.openqa.selenium.By;

public class AuthenticationForm extends BaseForm {

    private final Button signIn = new Button(By.xpath("//button[@class = 'FlatButton FlatButton--primary FlatButton--size-l FlatButton--wide VkIdForm__button VkIdForm__signInButton']"), "Login in button");

    public AuthenticationForm() {
        super(new TextField(By.id("index_login"),"Authentication page"), "Authentication page");
    }

    public void clickToEntire() {
        signIn.clickBtn();
    }
}
