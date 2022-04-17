package base.driver;

import java.util.Set;

public class DriverUtils {

    public static void getUrl(String url) {
        Driver.getDriver().get(url);
    }

    public static void tearDown() {
        Driver.getDriver().quit();
        Driver.setDriverToNull();
    }

    public static void windowSize(String size) {
        switch (size) {
            case "max":
                Driver.getDriver().manage().window().maximize();
                break;
            case "min":
                Driver.getDriver().manage().window().minimize();
                break;
            case "full":
                Driver.getDriver().manage().window().fullscreen();
                break;
            default:
                Loggerr.getLogger().info("This size '"+size+"' is not available");
                break;
        }
    }

    public static Set<String> setWindows() {
        Loggerr.getLogger().info("Передаем дескрипторы всех открытых окон");
        return Driver.getDriver().getWindowHandles();
    }

    public static String setParentWindow() {
        Loggerr.getLogger().info("Передаем дескриптор родительского окна");
        return Driver.getDriver().getWindowHandle();
    }

    public static void switchWindow(String windowHandle) {
        Loggerr.getLogger().info("Переключаемся в переданное окно");
        Driver.getDriver().switchTo().window(windowHandle);
    }

    public static void switchNotThisWindow(String windowHandle, Set<String> windowsSet) {
        Loggerr.getLogger().info("Переключаемся окно кроме дескриптора входного параметра");
        for (String windows : windowsSet) {
            if (!windows.equals(windowHandle)) {
                Driver.getDriver().switchTo().window(windows);
            }
        }

    }


    public static void switchToParentWindow(String parentWindow, Set<String> windows) {
        Loggerr.getLogger().info("переключаемся на родительскую страницу");
        for (String window : windows) {
            if (window.equals(parentWindow)) {
                switchWindow(window);
                break;
            }
        }
    }

    public static void closeThisWindow() {
        Loggerr.getLogger().info("Закрываем окно");
        Driver.getDriver().close();
    }


}
