package forms;

import base.driver.BaseForm;
import base.elements.Button;
import org.openqa.selenium.By;

public class NewsForm extends BaseForm {

    private final Button myPage = new Button(By.xpath("//li[@id = 'l_pr']"),"Button My Profile");

    public NewsForm() {
        super(new Button(By.id("post_field"), "News page"), "News page");
    }

    public void goToMyPage() {
        myPage.clickBtn();
    }
}
