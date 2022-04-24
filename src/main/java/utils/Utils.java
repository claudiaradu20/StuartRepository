package utils;

import net.serenitybdd.core.Serenity;
import org.openqa.selenium.WebDriver;

public class Utils {

    private WebDriver driver;

    public WebDriver getDriver() {
        if (driver == null) {
            driver = Serenity.getDriver();
        }
        return driver;
    }
}
