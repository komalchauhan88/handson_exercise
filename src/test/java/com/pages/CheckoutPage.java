package test.java.com.pages;

import main.java.com.Elements.Element;
import main.java.com.framework.setup.BasePage;

public class CheckoutPage extends BasePage {

    private Element guestCheckOut = new Element("//div[@data-test='login-choice-new']/div[2]", Element.LocatorType.XPATH);

    private Element emailTextBox = new Element("//input[@id='email']", Element.LocatorType.XPATH);

    private Element continueAsGuest = new Element("//button[@id='loginForm']", Element.LocatorType.XPATH);

    public void clickOnCheckoutAsGuest() {
        guestCheckOut.click();
    }

    public void enterEmail(String email) {
        emailTextBox.sendKeys(email);
        continueAsGuest.click();
    }
}
