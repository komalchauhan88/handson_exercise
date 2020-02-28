package main.java.com.framework.setup;

import com.drivers.DriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class BasePage {

    public WebDriver driver;

    public BasePage() {
        driver = DriverFactory.getDriver();
    }

    protected Actions getActions() {
        return new Actions(driver);
    }

    protected void pressEnterKey() {
        getActions().sendKeys(Keys.ENTER).build().perform();
    }

    public void takeScreenShot() throws IOException {
        TakesScreenshot t = (TakesScreenshot) driver;
        File source = t.getScreenshotAs(OutputType.FILE);
        File destination = new File("./src/test/resources/screenshot/screenshot.png");
        FileUtils.copyFile(source, destination);
    }

}
