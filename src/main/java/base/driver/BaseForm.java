package base.driver;

import base.elements.BaseElement;

public abstract class BaseForm {
    private BaseElement uniqueElement;
    private String formName;


    public BaseForm(BaseElement uniqueElement, String name)
    {
        this.uniqueElement = uniqueElement;
        formName = name;
    }

    public boolean isDisplayed() {
        Loggerr.getLogger().info("Проверяем наличие уникального элемента " + formName);
        return uniqueElement.isDisplayed();
    }




}
