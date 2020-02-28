package main.java.com.Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Element {

    private WebElement element;
    private By by = null;
    private long timeOutInSeconds = 15;
    private WebDriver driver;

    public Element(String locator, LocatorType locatorType) {
        this.driver = com.drivers.DriverFactory.getDriver();
        this.by = getLocatorBy(locator, locatorType);
    }

    private By getLocatorBy(final String locator, final LocatorType locatorType) {
        switch (locatorType) {
            case ID:
                return By.id(locator);
            case CSS:
                return By.cssSelector(locator);
            case LINK_TEXT:
                return By.linkText(locator);
            case XPATH:
                return By.xpath(locator);
            case CLASS_NAME:
                return By.className(locator);
            default:
                return By.xpath(locator);
        }
    }

    public WebElement getElement() {
        int count = 0;
        WebElement element = null;
        while (count<2) {
            try {
                element = new WebDriverWait(com.drivers.DriverFactory.getDriver(), timeOutInSeconds)
                        .until(ExpectedConditions.visibilityOfElementLocated(by));
                break;
            } catch (StaleElementReferenceException exception) {
                count++;
            }
        }
        return element;
    }

    public List<WebElement> getElements() {
        int count = 0;
        List<WebElement> elements = new ArrayList<>();
        while (count<2) {
            try {
                elements.add(new WebDriverWait(com.drivers.DriverFactory.getDriver(), timeOutInSeconds)
                        .until(ExpectedConditions.visibilityOfElementLocated(by)));
                break;
            } catch (StaleElementReferenceException exception) {
                count++;
            }
        }
        return elements;
    }

    public void click() {
        getElement().click();
    }

    public void sendKeys(final CharSequence charSequence) {
        getElement().clear();
        getElement().sendKeys(charSequence);
    }

    public enum LocatorType {
        ID, NAME, CLASS_NAME, XPATH, CSS, LINK_TEXT
    }
}
